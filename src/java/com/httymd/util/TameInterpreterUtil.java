package com.httymd.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.google.common.collect.Lists;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

/**
 * Handles and interprets commands in the tame system
 * 
 * @author George Albany
 *
 */
public class TameInterpreterUtil {

	public static final char SEPERATOR = ',';
	public static final char NOT = '!';
	public static final char ITM_PREFIX = ':';
	public static final String MULTI_ENT = "[]";
	public static final String ITM = "()";
	
	private static Map<String, Class<? extends Entity>> stringToClassCache;
	
	private static class FakeCommandSender implements ICommandSender {

		@Override
		public String getCommandSenderName() {
			return null;
		}

		@Override
		public IChatComponent func_145748_c_() {
			return null;
		}

		@Override
		public void addChatMessage(IChatComponent p_145747_1_) {			
		}

		@Override
		public boolean canCommandSenderUseCommand(int p_70003_1_, String p_70003_2_) {
			return false;
		}

		@Override
		public ChunkCoordinates getPlayerCoordinates() {
			return null;
		}

		@Override
		public World getEntityWorld() {
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static Map<Class<? extends Entity>, List<Item>> parseString(String str) {
		Map<Class<? extends Entity>, List<Item>> result = new HashMap<Class<? extends Entity>, List<Item>>(); // return of parsed string
		Map<String, Class<? extends Entity>> classStringMap = new HashMap<String, Class<? extends Entity>>(); // holds modified EntityList.stringToClassMappings (all spaces removed and lowercased)
		if(stringToClassCache != null && !stringToClassCache.isEmpty()){ // checks if stringToClassCache is empty or null
			classStringMap = stringToClassCache;
		} else {
			List<Class<?>> entClassList = new ArrayList<Class<?>>(EntityList.stringToClassMapping.keySet());
			List<String> entStrArr = new ArrayList<String>(EntityList.stringToClassMapping.entrySet());
			for(int i=0; i < entStrArr.size(); i++) {
				classStringMap.put(entStrArr.get(i).replace(' ', (char)0).toLowerCase(Locale.US), (Class<? extends Entity>) entClassList.get(i));
			}
			stringToClassCache = classStringMap;
			// This replaces all string values in stringToClassMapping to have no spaces and be lowercased
		}
		
		str = str.replace(' ', (char)0).toLowerCase(Locale.US); // Strips spaces and lowercases input string
		int[] current = {0}; // current index, array because java does not support primitive pointer operations
		do {
			List<String> entGroupList = getNextEntities(str, current);// Gets all entity strings into a list
			for(int i = 0; i<entGroupList.size(); i++) { // iterates through the entity string list to assign items for the entity's item list in the result map
				if(!classStringMap.containsKey(entGroupList.get(i))) continue; // skips entities that don't exist
				if(!result.containsKey(classStringMap.get(entGroupList.get(i)))) // prevents reseting existing entity keys
					result.put(classStringMap.get(entGroupList.get(i)), new ArrayList<Item>());
				
				result.get(entGroupList.get(i)).addAll(parseItemString(str.substring(current[0]+1), true));
			}
		} while(current[0] != str.length()-1);
		
		return result;
	}
	
	/**
	 * Retrieves a list of items parsed from the string
	 * @param str The string to parse
	 * @param tokenEnd Whether the ITM end token is required, will return an empty list if true and end token is not found
	 */
	public static List<Item> parseItemString(String str, boolean tokenEnd) {
		if(str.isEmpty() || str == null) return Collections.emptyList();
		if(str.indexOf(SEPERATOR) == -1) return Lists.newArrayList(Collections.singleton(getItemFromString(str)));
		List<Item> result = new ArrayList<Item>();
		
		int beginning = 0, end = 0;
		do {
			end = str.indexOf(SEPERATOR, beginning) - 1;
			result.add(getItemFromString(str.substring(beginning, end)));
			beginning = end + 2;
		} while (str.charAt(beginning) != ITM.charAt(1) && beginning != str.length()-1);
		if(tokenEnd && str.charAt(beginning) != ITM.charAt(1)) {
			result = Collections.emptyList();
		}
		result.removeAll(Collections.singleton(null));
		
		return result;
	}
	
	/**
	 * Reads a list of entity strings from an entity group, returns null if group does not contain a group start and end character
	 * @param group The string to parse
	 * @param current A one integer array for specifying the current parsing location after the function returns, optional
	 */
	public static List<String> parseEntityGroup(String group, int[] current) {
		ArrayList<String> result = new ArrayList<String>();
		
		int beginning = 0;
		if(group.charAt(beginning) != MULTI_ENT.charAt(0)) {
			beginning = group.indexOf(MULTI_ENT.charAt(0));
		}
		if(beginning == -1 || group.indexOf(MULTI_ENT.charAt(1)) == -1) return Collections.emptyList();
		beginning++;
		
		int end;
		do {
			end = group.indexOf(SEPERATOR, beginning) - 1;
			if(end < 0) {
				beginning = group.indexOf(MULTI_ENT.charAt(1));
				break;
			}
			result.add(group.substring(beginning, end));
			beginning = end + 2;
		} while(true);
		current[0] = beginning;
		
		return result;
	}
	
	/**
	 * Retrieves a string list containing the name of the next entity, or entity group. If current is not at a SEPERATOR character or is not the first character (that is legal) of the string, skips to next legal character
	 * @param str The string to retrieve an entity or entity group from
	 * @param current A one integer array for specifying the current parsing location, will become location of end (one character before parenthesis)
	 * @return A list containing the next entity/entities, or an empty list if the current index or string contain nothing valid
	 */
	public static List<String> getNextEntities(String str, int[] current) { // This is what I consider a hack in java, stupid java, why you no support pointers
		while(!isLegalFirstCharacter(str.charAt(current[0]))) {
			current[0] = str.indexOf(SEPERATOR, current[0])+1;
			if(current[0] == 0) return Collections.emptyList();
		}
		
		if(str.charAt(current[0]) == MULTI_ENT.charAt(0)) {
			return parseEntityGroup(str, current);
		} else if(Character.isLetterOrDigit(str.charAt(current[0])) || str.charAt(current[0]) == '_') {
			int end = str.indexOf(ITM.charAt(0), current[0]);
			
			if(end > str.indexOf(SEPERATOR, current[0])) {
				end = str.indexOf(SEPERATOR, current[0]);
			}
			List<String> result = Lists.newArrayList(Collections.singleton(str.substring(current[0], end)));
			current[0] = end-1;
			return result;
		} else {
			return Collections.emptyList();
		}
	}
	
	/**
	 * Returns whether character is a legal first character
	 * @param character The character to check
	 */
	public static boolean isLegalFirstCharacter(char character) {
		return character == MULTI_ENT.charAt(0) || Character.isLetterOrDigit(character) || character == '_';
	}
	
	/**
	 * Retrieves an item by name, returns null if name does exist, strings missing a colon will be treated as minecraft items (will be prefixed with "minecraft:")
	 * @param name The name of the item
	 * @see CommandBase#getItemByText(ICommandSender, String)
	 */
	public static Item getItemFromString(String name) {
		if(name.indexOf(ITM_PREFIX) == -1) name = "minecraft"+ITM_PREFIX+name;
		try {
			return CommandBase.getItemByText(new FakeCommandSender(), name);
		} catch(Exception e) {
			return null;
		}
	}
}
