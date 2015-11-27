package com.httymd.item;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.httymd.item.registry.IRegisterable;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.util.EnumToolType;
import com.httymd.item.util.ItemUtils;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

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

	public ItemToolExtension(Item.ToolMaterial material, EnumToolType type) {
		this(type.getName(), material, Collections.singleton(type));
	}

	public ItemToolExtension(String prefix, Item.ToolMaterial material, Collection<EnumToolType> types) {
		super(EnumToolType.getResultDamageOf(types), material, EnumToolType.getAllEffectiveBlocksOf(types));
		this.toolTypes = types;
		this.setUnlocalizedName(ItemUtils.findUnlocName(prefix + "_" + material.toString()));
		this.setTextureName(ItemUtils.findTextureName(this.getUnlocalizedName()));
		if(EnumToolType.getAverageFuelTime(this.toolTypes) > 0) GameRegistry.registerFuelHandler(this);
	}

	/**
	 * Gets strength versus a specific block
	 * 
	 * <p>Becomes getStrVsBlock(ItemStack, Block) in 1.8</p>
	 */
	public float func_150893_a(ItemStack stack, Block hitBlock) {
		if (this.isToolType(EnumToolType.PICKAXE))
			return hitBlock.getMaterial() != Material.iron && hitBlock.getMaterial() != Material.anvil
					&& hitBlock.getMaterial() != Material.rock ? super.func_150893_a(stack, hitBlock)
							: this.efficiencyOnProperMaterial;
		if (this.isToolType(EnumToolType.AXE))
			return hitBlock.getMaterial() != Material.wood && hitBlock.getMaterial() != Material.plants
					&& hitBlock.getMaterial() != Material.vine ? super.func_150893_a(stack, hitBlock)
							: this.efficiencyOnProperMaterial;
		return super.func_150893_a(stack, hitBlock);
	}

	/**
	 * Determines whether block can be harvested
	 * 
	 * <p>Becomes canHavestBlock(Block) in 1.8</p>
	 */
	public boolean func_150897_b(Block hitBlock) {
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
		return super.func_150897_b(hitBlock);
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

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (!this.isToolType(EnumToolType.HOE))
			return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);

		if (!player.canPlayerEdit(x, y, z, side, stack))
			return false;
		else {
			UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
			if (MinecraftForge.EVENT_BUS.post(event))
				return false;

			if (event.getResult() == Result.ALLOW) {
				stack.damageItem(1, player);
				return true;
			}

			Block block = world.getBlock(x, y, z);

			if (side != 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z)
					&& (block == Blocks.grass || block == Blocks.dirt)) {
				Block block1 = Blocks.farmland;
				world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, block1.stepSound.getStepResourcePath(),
						(block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

				if (world.isRemote)
					return true;
				else {
					world.setBlock(x, y, z, block1);
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
					EnumToolType.getAverageFuelTime(this.getToolTypes()) 
					: EnumToolType.getAverageFuelTime(this.getToolTypes()) - 50; 
		}
		return 0;
	}
}
