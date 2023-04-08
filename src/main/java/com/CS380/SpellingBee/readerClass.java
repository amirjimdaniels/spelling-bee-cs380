package com.CS380.SpellingBee;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class readerClass {
/*
 * Takes input from a list of strings which are retrieved using fileNameGetter method. The function iterates over file names
 * and uses the buffered reader to read the files line by line and splits around non alphabetical letters. If the word mathes alphabetic characters
 * then the words are addded to the completeWords list.
 */
	
    public List<String> getCompleteWords (List<String> filePaths)
    {   List<String> CompleteWords = new ArrayList<>();
        for (String filePath : filePaths)
        {
            try (BufferedReader myreader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = myreader.readLine()) != null )
                {
                    String[] words = line.split("[\\s,\\p{Punct}]+");
                        for (String word : words)
                        {
                            if (word.matches("[a-zA-Z]+")) {
                                CompleteWords.add(word);
                            }
                        }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

     return CompleteWords;
    }
}