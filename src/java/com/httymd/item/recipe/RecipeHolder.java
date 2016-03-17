package com.httymd.item.recipe;

import java.util.ArrayList;
import java.util.Arrays;
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

	private List<String> recipe = new ArrayList<String>();
	private List<Character> representors = new ArrayList<Character>();
	private List<ItemStack> defRepObj = new ArrayList<ItemStack>();
	
	private Map<ItemStack, ItemStack> inputToOut = new HashMap<ItemStack, ItemStack>(); 
	
	public RecipeHolder(Object ...params) {
		for(Object o : params) {
			if(o instanceof String) {
				recipe.add((String) o);
			}
			
			else if(o instanceof Character) {
				representors.add((Character) o);
			}
			
			else if(o instanceof Item) {
				defRepObj.add(new ItemStack((Item)o));
			}
			
			else if(o instanceof Block) {
				defRepObj.add(new ItemStack((Block)o));
			}
			
			else if(o instanceof ItemStack) {
				defRepObj.add((ItemStack) o);
			}
		}
	}
	
	public RecipeHolder put(ItemStack input, ItemStack output) {
		inputToOut.put(input, output);
		return this;
	}
	
	public RecipeHolder put(ToolMaterial material, WeaponType type) {
		this.put(new ItemStack(material.func_150995_f()), new ItemStack(ItemRegistry.weaponMap.get(material).get(type)));
		return this;
	}
	
	public void addRecipe() {
		Object[] charAndStack = new Object[defRepObj.size()*2];
		int index = 0;
		for(int i = 0; i < defRepObj.size(); i+=2, index++) {
			charAndStack[i] = this.representors.get(index);
			charAndStack[i+1] = this.defRepObj.get(index);
		}
		List<Object> l = new ArrayList<Object>();
		l.addAll(recipe);
		l.addAll(Arrays.asList(charAndStack));
		
		Character c;
		try { c = this.representors.get(index); }
		catch(Throwable t) { c = '#'; }
		l.add(c);
		int last = l.size();
		
		for(Entry<ItemStack, ItemStack> e : inputToOut.entrySet()) {
			l.add(e.getKey());
			GameRegistry.addRecipe(e.getValue(), l.toArray());
			l.remove(last);
		}
	}
}
