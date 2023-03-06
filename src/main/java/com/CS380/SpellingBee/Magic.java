package com.CS380.SpellingBee;

/**
 * This is an ever-developing piece of code, which is simply a toolbox for commonly used regex functions.
 * 
 *
 */
public class Magic {
	
	
	/**
	 * Simple method to find unique characters of an inputed string.
	 * 
	 * This method is relatively space and time complex, so feel free to improve it!
	 * 
	 * (looking at you amir)
	 * 
	 * @param input a string
	 * @return a string with only the unique characters
	 */
	public static String uniqueCharactersOnlyOf(String input) {
		
		String[] chars = input.split("");
		
		for (int i = 0; i < chars.length; i++) {
			for (int j = i+1; j < chars.length; j++) {
				if (i == j) {
					chars[j] = null;
				}
			}
		}
		
		StringBuilder builder = new StringBuilder();
		
		for (String str : chars) {
			if (str != null) {
				builder.append(str);
			}
		}
		
		return builder.toString();
	}

}
