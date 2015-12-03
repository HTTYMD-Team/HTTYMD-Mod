package com.httymd.item;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.httymd.item.registry.IRegisterable;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.util.EnumToolType;
import com.httymd.item.util.ItemUtils;

import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Reproduces All vanilla tool behaviors (including a hoe, even if it isn't
 * technically a tool) without extending original tools. To detect type of tool
 * item, please use {@link #isToolType(EnumToolType)} instead of instanceof
 *
 * @author George Albany
 *
 */
public class ItemToolExtension extends ItemTool implements IRegisterable, IFuelHandler {

	protected final Collection<EnumToolType> toolTypes;

	public ItemToolExtension(String prefix, Item.ToolMaterial material, Collection<EnumToolType> types) {
		super(EnumToolType.getResultDamageOf(types), material, EnumToolType.getAllEffectiveBlocksOf(types));
		this.toolTypes = types;
		this.setUnlocalizedName(ItemUtils.findUnlocName(prefix + "_" + material.toString()));
		//this.setTextureName(ItemUtils.findTextureName(this.getUnlocalizedName()));
		if(EnumToolType.getAverageFuelTime(this.toolTypes) > 0) GameRegistry.registerFuelHandler(this);
	}
	
	public ItemToolExtension(Item.ToolMaterial material, EnumToolType type) {
		this(type.getName(), material, Collections.singleton(type));
	}

	/**
	 * Determines whether block can be harvested
	 */
	public boolean canHarvestBlock(Block hitBlock) {
		if (this.isToolType(EnumToolType.PICKAXE))
			return hitBlock == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3
					: hitBlock != Blocks.diamond_block && hitBlock != Blocks.diamond_ore
							? hitBlock != Blocks.emerald_ore && hitBlock != Blocks.emerald_block
									? hitBlock != Blocks.gold_block && hitBlock != Blocks.gold_ore
											? hitBlock != Blocks.iron_block && hitBlock != Blocks.iron_ore
													? hitBlock != Blocks.lapis_block && hitBlock != Blocks.lapis_ore
															? hitBlock != Blocks.redstone_ore
																	&& hitBlock != Blocks.lit_redstone_ore
																			? hitBlock.getMaterial() == Material.rock
																					? true
																					: hitBlock
																							.getMaterial() == Material.iron
																									? true
																									: hitBlock.getMaterial() == Material.anvil
																			: this.toolMaterial.getHarvestLevel() >= 2
															: this.toolMaterial.getHarvestLevel() >= 1
													: this.toolMaterial.getHarvestLevel() >= 1
											: this.toolMaterial.getHarvestLevel() >= 2
									: this.toolMaterial.getHarvestLevel() >= 2
							: this.toolMaterial.getHarvestLevel() >= 2;
		if (this.isToolType(EnumToolType.SHOVEL))
			return hitBlock == Blocks.snow_layer ? true : hitBlock == Blocks.snow;
		return super.canHarvestBlock(hitBlock);
	}

	/**
	 * Gets strength versus a specific block
	 */
	public float getStrVsBlock(ItemStack stack, Block hitBlock) {
		if (this.isToolType(EnumToolType.PICKAXE))
			return hitBlock.getMaterial() != Material.iron && hitBlock.getMaterial() != Material.anvil
					&& hitBlock.getMaterial() != Material.rock ? super.getStrVsBlock(stack, hitBlock)
							: this.efficiencyOnProperMaterial;
		if (this.isToolType(EnumToolType.AXE))
			return hitBlock.getMaterial() != Material.wood && hitBlock.getMaterial() != Material.plants
					&& hitBlock.getMaterial() != Material.vine ? super.getStrVsBlock(stack, hitBlock)
							: this.efficiencyOnProperMaterial;
		return super.getStrVsBlock(stack, hitBlock);
	}
	
	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}

	public Set<String> getToolClasses(ItemStack stack) {
		return this.getToolTypes() != null ? EnumToolType.getAllNames(this.getToolTypes()) : super.getToolClasses(stack);
	}

	public Collection<EnumToolType> getToolTypes() {
		return this.toolTypes;
	}

	/**
	 * Determines whether this tool contains the same {@link EnumToolType} as type
	 */
	public boolean isToolType(EnumToolType type) {
		return this.getToolTypes().contains(type);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos p, EnumFacing f,
			float hitX, float hitY, float hitZ) {
		if (!this.isToolType(EnumToolType.HOE))
			return super.onItemUse(stack, player, world, p, f, hitX, hitY, hitZ);

		if (!player.canPlayerEdit(p, this.getMovingObjectPositionFromPlayer(world, player, true).sideHit, stack))
			return false;
		else {
			UseHoeEvent event = new UseHoeEvent(player, stack, world, p);
			if (MinecraftForge.EVENT_BUS.post(event))
					return false;

			if (event.getResult() == Result.ALLOW) {
				stack.damageItem(1, player);
				return true;
			}
			
			Block block = world.getBlockState(p).getBlock();
			
			if (f != EnumFacing.DOWN && world.getBlockState(p.add(0, 1, 0)).getBlock().isAir(world, p.add(0, 1, 0)) && (block == Blocks.grass || block == Blocks.dirt)) {
				Block block1 = Blocks.farmland;
				world.playSoundEffect((double) ((float) p.getX() + 0.5F), (double) ((float) p.getY() + 0.5F),
						(double) ((float) p.getZ() + 0.5F), block1.stepSound.getStepSound(),
						(block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getFrequency() * 0.8F);
				if (world.isRemote) return true;
				else {
					world.setBlockState(p, block1.getDefaultState());
					stack.damageItem(1, player);
					return true;
				}
			} else
				return false;
		}
	}

	public Item registerItem() {
		ItemRegistry.registerItem(this, this.getRegistryName());
		return this;
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() == this) {
			return this.toolMaterial == ToolMaterial.WOOD ? 
					EnumToolType.getAverageFuelTime(this.getToolTypes()) + 50 
					: EnumToolType.getAverageFuelTime(this.getToolTypes()); 
		}
		return 0;
	}
}
