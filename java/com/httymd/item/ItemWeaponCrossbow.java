package com.httymd.item;

import java.util.List;

import com.httymd.util.CreativeTab;
import com.httymd.util.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

/**
 * A crossbow item which is able to hold a charge a later fire (aka: charge and forget)
 * 
 * @author George Albany
 *
 */
public class ItemWeaponCrossbow extends ItemExtension {

	public static final String NBT_POWER = "BowStoredPower";

	public static final float RESET_POWER = 0.0F;
	public static final float MAX_POWER = 1.7F;

	public final String[] iconList;

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	//@SideOnly(Side.CLIENT)
	//private IIcon lastIcon;

	public ItemWeaponCrossbow(String name, int numberOfActions) {
		this(name, numberOfActions, CreativeTab.DRAGON_TAB);
	}

	public ItemWeaponCrossbow(String name, int numberOfActions, CreativeTabs tab) {
		super(name, tab);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
		this.setFull3D();
		this.iconList = new String[numberOfActions];
		for(int i = 0; i < numberOfActions; i++) this.iconList[i] = "p" + i;
	}

	public float getBowPower(ItemStack stack) {
		if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey(NBT_POWER)) {
			this.resetBow(stack);
			return RESET_POWER; // quicker, might as well optimize anyway
		}
		return stack.getTagCompound().getFloat(NBT_POWER);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (usingItem == null)
			return this.getIcon(stack, renderPass);
		int deltaDuration = this.getMaxItemUseDuration(stack) - useRemaining;
		if (this.isBowDrawn(usingItem))
			return this.iconArray[this.iconArray.length - 1];
		if (this.iconArray.length <= deltaDuration)
			deltaDuration = this.iconArray.length - 1;
		//else
			//this.lastIcon = this.iconArray[deltaDuration];
		return this.iconArray[deltaDuration];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		if (this.isBowDrawn(stack))
			return this.iconArray[this.iconArray.length - 1];
		else
			return this.itemIcon;
	}

	@Override
	public int getItemEnchantability() {
		return 1;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack item) {
		return EnumAction.bow;//1.8: EnumAction.bow to EnumAction.BOW
	}

	@Override
	public int getMaxItemUseDuration(ItemStack item) {
		return 72000;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 1; i++)
			list.add(new ItemStack(item, 1));
	}

	private void insertToInventory(EntityLivingBase entity, ItemStack itemStack) {
		Utils.insertItem(entity, itemStack);
	}

	public boolean isBowDrawn(ItemStack stack) {
		return this.getBowPower(stack) > RESET_POWER;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		return this.onStartUsing(item, world, player);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int dur) {
		this.onStopUsing(item, world, player, dur);
	}

	public ItemStack onStartUsing(ItemStack stack, World world, EntityLivingBase entity) {
		boolean isCreative = entity instanceof EntityPlayer ? ((EntityPlayer) entity).capabilities.isCreativeMode : false;

		if (this.isBowDrawn(stack)) {
			if (entity.isSneaking()) {
				this.insertToInventory(entity, new ItemStack(Items.arrow, 1));
				this.resetBow(stack);
				return stack;
			}

			float arrowPower = this.getBowPower(stack);
			EntityArrow entityarrow = new EntityArrow(world, entity, arrowPower * 2);
			if (arrowPower > 1)
				entityarrow.setIsCritical(true);

			int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
			if (powerLevel > 0)
				entityarrow.setDamage(entityarrow.getDamage() + powerLevel * 0.5D + 0.5D);

			int knockbackLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
			if (knockbackLevel > 0)
				entityarrow.setKnockbackStrength(knockbackLevel);

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
				entityarrow.setFire(100);

			stack.damageItem(1, entity);
			world.playSoundAtEntity(entity, "random.bow", 1,
					1 / (itemRand.nextFloat() * 0.4F + 1.2F) + arrowPower * 0.5F);

			if (isCreative)
				entityarrow.canBePickedUp = 2;

			if (!world.isRemote)
				world.spawnEntityInWorld(entityarrow);

			this.resetBow(stack);
		} else {

			ArrowNockEvent event = new ArrowNockEvent((EntityPlayer) entity, stack);
			MinecraftForge.EVENT_BUS.post(event);
			if (event.isCanceled())
				return event.result;

			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).setItemInUse(stack, this.getMaxItemUseDuration(stack));

		}
		return stack;
	}

	public void onStopUsing(ItemStack item, World world, EntityLivingBase entity, int dur) {
		boolean bowDrawn = this.isBowDrawn(item);

		if (!bowDrawn) {
			double durationDelta = this.getMaxItemUseDuration(item) - dur;

			ArrowLooseEvent event = new ArrowLooseEvent((EntityPlayer) entity, item, (int) durationDelta);
			MinecraftForge.EVENT_BUS.post(event);
			if (event.isCanceled())
				return;

			durationDelta = event.charge;
			if (this.pullInventory(entity, item, Items.arrow)) {
				float arrowPower = (float) (durationDelta * 0.05F);
				arrowPower = (arrowPower * arrowPower + arrowPower * 2) / 3 * 2;

				if (arrowPower < 0.1D) {
					this.insertToInventory(entity, new ItemStack(Items.arrow));
					return;
				}
				if (arrowPower > MAX_POWER) arrowPower = MAX_POWER;
				this.setBowPower(item, arrowPower);
				world.playSoundAtEntity(entity, "mob.sheep.shear", 2.0F, 0.8F);// Best loading sound
			}
		}
	}

	private boolean pullInventory(EntityLivingBase entity, ItemStack itemStack, Item item) {
		if (entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isCreativeMode
				|| EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0)
			return true;

		return Utils.consumeItem(entity, item);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister registry) {
		super.registerIcons(registry);
		this.iconArray = new IIcon[this.iconList.length + 1];

		this.iconArray[0] = this.itemIcon;
		for (int i = 1; i < this.iconArray.length; ++i)
			this.iconArray[i] = registry.registerIcon(this.getIconString() + "_" + this.iconList[i-1]);
	}

	public void resetBow(ItemStack stack) {
		this.setBowPower(stack, RESET_POWER);
	}

	public void setBowPower(ItemStack stack, float power) {
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setFloat(NBT_POWER, power);
	}
}
