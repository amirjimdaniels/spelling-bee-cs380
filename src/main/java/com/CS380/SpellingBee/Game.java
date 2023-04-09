package com.CS380.SpellingBee;

import java.util.List;

/**
 * Class that stores information about the current game status, such as points/rank/etc.
 */
public class Game implements GameLogic {
	private int points = 0; //tracks the number of points the player has
	WordGenerator wordGen; //generates the words for the day
	private String[] listOfLetters; //stores the list of letters in the game
	private String rank = "Beginner"; //the rank the player has reached for the day
	private int rankValue = 0; //a number to represent the rank (for progress bar in UI)
	
	/**
	 * Constructor
	 * @param inputListOfLetters
	 * @param inputWordGen
	 */
	public Game(String []inputListOfLetters, WordGenerator inputWordGen) {
		this.listOfLetters = inputListOfLetters;
		this.wordGen = inputWordGen;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the wordGen
	 */
	public WordGenerator getWordGen() {
		return wordGen;
	}

	/**
	 * @param wordGen the wordGen to set
	 */
	public void setWordGen(WordGenerator wordGen) {
		this.wordGen = wordGen;
	}

	/**
	 * @return the listOfLetters
	 */
	public String[] getListOfLetters() {
		return listOfLetters;
	}

	/**
	 * @param listOfLetters the listOfLetters to set
	 */
	public void setListOfLetters(String[] listOfLetters) {
		this.listOfLetters = listOfLetters;
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public int getRankValue() {
		return rankValue;
	}

	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}
	
	/**
	 * Sets both rank and the rank value for the progress bar
	 */
	public void setRank(String rank, int rankValue) {
		this.rank = rank;
		this.rankValue = rankValue;
	}

	/**
	 * Returns true if the word is at least 4 letters long
	 */
	@Override
	public boolean isCorrectWordLength(String word) {
		return word.length() >= 4;
	}
	
	/**
	 * Returns true if the center character is in the word
	 */
	@Override
	public boolean containsCenterLetter(String word, char center) {
		return word.contains("" + center); //use "" + center for one character String
	}
	
	/**
	 * TODO: Should be WordGenerator method
	 */
	@Override
	public void createPangram(String[] listOfLetters) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Returns true if the word is a pangram
	 */
	@Override
	public boolean isPangram(String word, String[] listOfLetters) {
		
		/*
		 * If length < 7, it is impossible for the word to be a pangram
		 */
		if (word.length()<7) {
			return false;
		}
		/*
		 * Go through each letter in the set of letters, return false if any letter is not present
		 */
		for (String letter: listOfLetters){
			if (!word.contains(letter))
			{
				return false;
			}
		}
		return true; //If every letter is in the word, we know the word is a pangram
	}
	
	/*
	 * Simple method to calculate the amount of points allotted for each word entered
	 */
	public void calculatePoints(String word)
	{
		if (isCorrectWordLength(word))
		{
			List<String> wordList = wordGen.getDailyWordsAsList();
			
			/*
			 * Make sure the word entered is in the daily word bank
			 */
			if (wordList.contains(word))
			{
				if (isPangram(word, listOfLetters))
				{
					points += 7; //pangrams are worth 7 extra points
				}
				//each word is worth points equal to the length of the word minus 3
				points += word.length() -3;
			}
		}
		this.progressBar(); //calculate the rank after updating the number of points
	}
	
	/*
	 * Calculates the total amount of points possible today
	 */
	public int maxPoints()
	{
		
		List<String> wordList = wordGen.getDailyWordsAsList(); //get the daily word bank
		int total = 0; //keep a local total variable to track the total points possible
		
		/*
		 * Get the value of each of today's words and add it to the total
		 */
		for (String word : wordList)
		{
			if (isPangram(word, listOfLetters))
			{
				total += 7; //pangrams are worth 7 extra points
			}
			//each word is worth points equal to the length of the word minus 3
			total += word.length() -3; 
		}
		
		
		return total; //return the total
	}
	
	/*
	 * Assigns rank based on percentage of maxPoints achieved
	 */
	public void progressBar()
	{
		int max = maxPoints(); //get the max points possible for rank calculations
		
		/*
		 * Determine the player's rank based on the percentage of the total points they have acquired
		 */
		if (points == max) //100% of points achieved (Hidden Rank)
		{
			this.setRank("Queen Bee", 9);
		}
		else if (points >= max *.7) //At least 70% of points achieved
		{
			this.setRank("Genius", 8);
		}
		else if (points >= max *.5) //At least 50% of points achieved
		{
			this.setRank("Aamazing", 7);
		}
		else if (points >= max*.4) //At least 40% of points achieved
		{
			this.setRank("Great", 6);
		}
		else if (points >= max *.25) //At least 25% of points achieved
		{
			this.setRank("Nice", 5);
		}
		else if (points >= max*.15) //At least 15% of points achieved
		{
			this.setRank("Solid", 4);
		}
		else if (points >= max*.08) //At least 8% of points achieved
		{
			this.setRank("Good", 3);
		}
		else if (points >= max*.05) //At least 5% of points achieved
		{
			this.setRank("Moving Up", 2);
		}
		else if (points >= max*.02) //At least 2% of points achieved
		{
			this.setRank("Good Start", 1);
		}
		else { //Default rank
			this.setRank("Beginner", 0);
		}
	}

}
