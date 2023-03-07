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
		
		input = input.toLowerCase();
		
		StringBuilder output = new StringBuilder();
		
		boolean[] seenCharacters = new boolean[26];
		
		for (int i = 0; i < input.length(); i++) {
			if (!seenCharacters[input.charAt(i) - 'a']) {
				seenCharacters[input.charAt(i) - 'a'] = true;
				output.append(input.charAt(i));
			}
		}
		
		return output.toString();
	}

}
