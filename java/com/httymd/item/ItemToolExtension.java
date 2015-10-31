package com.httymd.item;

import com.httymd.item.registry.IRegisterable;
import com.httymd.item.util.EnumToolType;
import com.httymd.item.util.ItemUtils;

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
 * Reproduces All vanilla tool behaviors (including a hoe, even if it isn't technically a tool) without extending original tools.
 * To detect type of tool item, please use {@link EnumToolType} instead of instanceof
 * @author George Albany
 *
 */
public class ItemToolExtension extends ItemTool implements IRegisterable {

	protected final EnumToolType toolType;
	
	public ItemToolExtension(Item.ToolMaterial material, EnumToolType type) {
		super(type.getAttackDamage(), material, type.getEffectiveBlocks());
		this.toolType = type;
		this.setUnlocalizedName(ItemUtils.findUnlocName(type.toString() + "_" + material.toString()));
		this.setTextureName(ItemUtils.findTextureName(this.getUnlocalizedName()));
	}
	
	public Item registerItem() {
		GameRegistry.registerItem(this, this.getRegistryName());
		return this;
	}

	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}
	
	public EnumToolType getToolType() {
		return this.toolType;
	}
	
	public boolean func_150897_b(Block hitBlock)
    {
		if(this.toolType == EnumToolType.PICKAXE)	return hitBlock == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (hitBlock != Blocks.diamond_block && hitBlock != Blocks.diamond_ore ? (hitBlock != Blocks.emerald_ore && hitBlock != Blocks.emerald_block ? (hitBlock != Blocks.gold_block && hitBlock != Blocks.gold_ore ? (hitBlock != Blocks.iron_block && hitBlock != Blocks.iron_ore ? (hitBlock != Blocks.lapis_block && hitBlock != Blocks.lapis_ore ? (hitBlock != Blocks.redstone_ore && hitBlock != Blocks.lit_redstone_ore ? (hitBlock.getMaterial() == Material.rock ? true : (hitBlock.getMaterial() == Material.iron ? true : hitBlock.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
		if(this.toolType == EnumToolType.SHOVEL)	return hitBlock == Blocks.snow_layer ? true : hitBlock == Blocks.snow;
		return super.func_150897_b(hitBlock);
	}

    public float func_150893_a(ItemStack stack, Block hitBlock)
    {
        if(this.toolType == EnumToolType.PICKAXE) return hitBlock.getMaterial() != Material.iron && hitBlock.getMaterial() != Material.anvil && hitBlock.getMaterial() != Material.rock ? super.func_150893_a(stack, hitBlock) : this.efficiencyOnProperMaterial;
        if(this.toolType == EnumToolType.AXE)     return hitBlock.getMaterial() != Material.wood && hitBlock.getMaterial() != Material.plants && hitBlock.getMaterial() != Material.vine ? super.func_150893_a(stack, hitBlock) : this.efficiencyOnProperMaterial;
        return super.func_150893_a(stack, hitBlock);
    }
    
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	if(this.toolType != EnumToolType.HOE) return super.onItemUse(stack, player, world, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
    	
    	if (!player.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, stack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(player, stack, world, p_77648_4_, p_77648_5_, p_77648_6_);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
                stack.damageItem(1, player);
                return true;
            }

            Block block = world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);

            if (p_77648_7_ != 0 && world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_).isAir(world, p_77648_4_, p_77648_5_ + 1, p_77648_6_) && (block == Blocks.grass || block == Blocks.dirt))
            {
                Block block1 = Blocks.farmland;
                world.playSoundEffect((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (world.isRemote)
                {
                    return true;
                }
                else
                {
                    world.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, block1);
                    stack.damageItem(1, player);
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }
}
