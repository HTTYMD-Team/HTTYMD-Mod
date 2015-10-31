package com.httymd.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import com.httymd.util.CreativeTab;
import com.httymd.util.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWeaponCrossbow extends ItemExtension {
	
	public static final String NBT_POWER = "BowStoredPower";
	
	public static final float RESET_POWER = 0.0F;

	public final ArrayList<String> iconList = new ArrayList<String>();

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	@SideOnly(Side.CLIENT)
	private IIcon lastIcon;

	public ItemWeaponCrossbow(String name, int numberOfActions) {
		this(name, numberOfActions, CreativeTab.DRAGON_TAB);
	}

	public ItemWeaponCrossbow(String name, int numberOfActions, CreativeTabs tab) {
		super(name, tab);
		maxStackSize = 1;
		setMaxDamage(384);
		for (int i = 0; i < numberOfActions; i++) {
			iconList.add("p" + i);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	private boolean pullInventory(EntityLivingBase entity, ItemStack itemStack, Item item) {
		if ((entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isCreativeMode)
				|| EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0) {
			return true;
		}

		return Utils.consumeItem(entity, item);
	}

	private void insertToInventory(EntityLivingBase entity, ItemStack itemStack) {
		Utils.insertItem(entity, itemStack);
	}

	public ItemStack onStartUsing(ItemStack item, World world, EntityLivingBase entity) {
		boolean bowDraw = this.isBowDrawn(item);
		boolean isCreative = entity instanceof EntityPlayer ? ((EntityPlayer) entity).capabilities.isCreativeMode : false;

		if (bowDraw) {
			if(entity.isSneaking()) {
				this.insertToInventory(entity, new ItemStack(Items.arrow, 1));
				this.resetBow(item);
				return item;
			}
				
			float arrowPower = this.getBowPower(item);
			EntityArrow entityarrow = new EntityArrow(world, entity, arrowPower * 2);
			if (arrowPower > 1) {
				entityarrow.setIsCritical(true);
			}
			
			int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, item);
			if (powerLevel > 0) {
				entityarrow.setDamage(entityarrow.getDamage() + (double) powerLevel * 0.5D + 0.5D);
			}
			
			int knockbackLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, item);
			if (knockbackLevel > 0) {
				entityarrow.setKnockbackStrength(knockbackLevel);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, item) > 0) {
				entityarrow.setFire(100);
			}

			item.damageItem(1, entity);
			world.playSoundAtEntity(entity, "random.bow", 1, 1 / (itemRand.nextFloat() * 0.4F + 1.2F) + arrowPower * 0.5F);

			if (isCreative) {
				entityarrow.canBePickedUp = 2;
			}

			if (!world.isRemote) {
				world.spawnEntityInWorld(entityarrow);
			}

			this.resetBow(item);
		} else {

			ArrowNockEvent event = new ArrowNockEvent((EntityPlayer) entity, item);
			MinecraftForge.EVENT_BUS.post(event);
			if (event.isCanceled()) {
				return event.result;
			}

			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).setItemInUse(item, getMaxItemUseDuration(item));

		}
		return item;
	}

	public void onStopUsing(ItemStack item, World world, EntityLivingBase entity, int dur) {
		boolean bowDrawn = this.isBowDrawn(item);

		if (!bowDrawn) {
			double durationDelta = getMaxItemUseDuration(item) - dur;

			ArrowLooseEvent event = new ArrowLooseEvent((EntityPlayer) entity, item, (int) durationDelta);
			MinecraftForge.EVENT_BUS.post(event);
			if (event.isCanceled()) {
				return;
			}
			
			durationDelta = event.charge;
			if (pullInventory(entity, item, Items.arrow)) {
				float arrowPower = (float) durationDelta / 20;
				arrowPower = ((arrowPower * arrowPower + arrowPower * 2) / 3) * 2;

				if ((double) arrowPower < 0.1D) {
					insertToInventory(entity, new ItemStack(Items.arrow));
					return;
				}

				if (arrowPower > 2) {
					arrowPower = 2;
				}

				this.setBowPower(item, arrowPower);
				world.playSoundAtEntity(entity, "mob.sheep.shear", 2.0F, 0.8F);// Best loading sound
			}
		}
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int dur) {
		onStopUsing(item, world, player, dur);
	}

	@Override
	public ItemStack onEaten(ItemStack item, World world, EntityPlayer player) {
		return item;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack item) {
		return 72000;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		return onStartUsing(item, world, player);
	}

	@Override
	public int getItemEnchantability() {
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (usingItem == null) {
			return this.getIcon(stack, renderPass);
		}
		int deltaDuration = getMaxItemUseDuration(stack) - useRemaining;
		if (isBowDrawn(usingItem)) {
			return iconArray[iconArray.length - 1];
		}
		if (iconArray.length <= deltaDuration) {
			deltaDuration = iconArray.length - 1;
		} else {
			lastIcon = iconArray[deltaDuration];
		}
		return iconArray[deltaDuration];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister registry) {
		super.registerIcons(registry);
		iconArray = new IIcon[iconList.size() + 1];

		iconArray[0] = itemIcon;
		for (int i = 1; i < iconArray.length; ++i) {
			iconArray[i] = registry.registerIcon(this.getIconString() + "_" + iconList.get(i-1));
		}
	}

	@Override
	public EnumAction getItemUseAction(ItemStack item) {
		return EnumAction.bow;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		if (this.isBowDrawn(stack)) {
			return iconArray[iconArray.length - 1];
		} else {
			return itemIcon;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 1; i++) {
			list.add(new ItemStack(item, 1));
		}
	}

	public void setBowPower(ItemStack stack, float power) {
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setFloat(NBT_POWER, power);
	}

	public float getBowPower(ItemStack stack) {
		if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey(NBT_POWER)) {
			resetBow(stack);
			return RESET_POWER; //quicker, might as well optimize anyway
		}
		return stack.getTagCompound().getFloat(NBT_POWER);
	}

	public boolean isBowDrawn(ItemStack stack) {
		return getBowPower(stack) > RESET_POWER;
	}

	public void resetBow(ItemStack stack) {
		setBowPower(stack, RESET_POWER);
	}
} 
