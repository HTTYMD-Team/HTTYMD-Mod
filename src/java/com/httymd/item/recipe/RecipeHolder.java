package com.httymd.item.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;

import com.httymd.api.item.WeaponType;
import com.httymd.registry.ItemRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHolder {
	private final List<Object> parameters = new ArrayList<Object>();

	private final Map<ItemStack, ItemStack> inputToOut = new HashMap<ItemStack, ItemStack>();

	public RecipeHolder(Object ...params) {
		final List<String> rec = new ArrayList<String>();
		final List<Character> rep = new ArrayList<Character>();
		final List<ItemStack> objs = new ArrayList<ItemStack>();

		for(final Object o : params)
			if(o instanceof String)
				rec.add((String) o);
			else if(o instanceof Character)
				rep.add((Character) o);
			else if(o instanceof Item)
				objs.add(new ItemStack((Item)o));
			else if(o instanceof Block)
				objs.add(new ItemStack((Block)o));
			else if(o instanceof ItemStack)
				objs.add((ItemStack) o);

		if(rep.size() < objs.size()) throw new IllegalArgumentException("Not enough characters inserted");

		this.parameters.addAll(rec);
		int i = 0;
		for(; i < objs.size(); i++) {
			this.parameters.add(rep.get(i));
			this.parameters.add(objs.get(i));
		}
		if(rep.size() <= i)
			this.parameters.add('#');
		else
			this.parameters.add(rep.get(i));
	}

	public RecipeHolder put(ItemStack input, ItemStack output) {
		this.inputToOut.put(input, output);
		return this;
	}

	public RecipeHolder put(ToolMaterial material, WeaponType type) {
		this.put(new ItemStack(material.func_150995_f()), new ItemStack(ItemRegistry.weaponMap.get(material).get(type)));
		return this;
	}

	public void addRecipe() {
		final int last = this.parameters.size();

		for(final Entry<ItemStack, ItemStack> e : this.inputToOut.entrySet()) {
			this.parameters.add(e.getKey());
			GameRegistry.addRecipe(e.getValue(), this.parameters.toArray());
			this.parameters.remove(last);
		}
	}
}
