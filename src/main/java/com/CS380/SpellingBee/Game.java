package com.CS380.SpellingBee;

import java.util.List;

public class Game implements GameLogic {
	private int points = 0;
	WordGenerator wordGen;
	private String[] listOfLetters;
	private String rank;
	
	public Game(String []inputListOfLetters, WordGenerator inputWordGen) {
		this.listOfLetters = listOfLetters;
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

	@Override
	public boolean isCorrectWordLength(String word) {
		if (word.length() < 4)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean containsCenterLetter(String word, char center) {
		
			return word.contains("" + center);
	}

	@Override
	public void createPangram(String[] listOfLetters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPangram(String word, String[] listOfLetters) {
		
	for (String letter: listOfLetters){
		if (!word.contains(letter))
		{
			return false;}
	}
		return true;
	}
	/*
	 * Simple method to calculate the amount of points allotted for each word entered
	 */
	
	public void calculatePoints(String word)
	{
		if (isCorrectWordLength(word))
		{
			List<String> wordList = wordGen.getDailyWordsAsList();
			
			if (wordList.contains(word))
			{
				if (isPangram(word, listOfLetters))
				{
					points += 7;
				}
				points += word.length() -3;
			}
		}
	}
	
	/*
	 * Calculates max amount of points based off of daily words list
	 */
	
	public int maxPoints()
	{ 
		List<String> wordList = wordGen.getDailyWordsAsList();
		int score = 0;
		
		for (String word : wordList)
		{
			if (isPangram(word, listOfLetters))
			{
				score +=7;
			}
			score += word.length() -3;
		}
		
		
		return score;
	}
	
	/*
	 * Assigns rank based on percentage of maxPoints achieved
	 */
	
	public void progressBar ()
	{
		int max = maxPoints();
		if (points == max)
		{
			rank = "Queen Bee";
		}
	
		else if (points >= max *.7)
		{
			rank = "Genius";
		}
		
		else if (points >= max *.5)
		{
			rank = "Aamazing";
		}
	
		else if (points >= max*.4)
		{
			rank = "Great";
		}
		
		else if (points >= max *.25)
		{
			rank = "Nice";
		}
	
		else if (points >= max*.15)
		{
			rank = "Solid";
		}
	
		else if (points >= max*.08)
		{
			rank = "Good";
		}
		else if (points >= max*.05)
		{
			rank = "Moving Up";
		}
		
		else if (points >= max*.02)
		{
			rank = "Good Start";
		}
		
		else {
			rank = "Beeginner";
		}
	}
	
	
	

}
