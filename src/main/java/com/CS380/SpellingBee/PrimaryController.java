package com.CS380.SpellingBee;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PrimaryController implements Initializable {

	String[] listOfLetters = {"M", "A", "H", "G", "O", "N", "Y"};
	//Game gameInstance = new Game(listOfLetters, new WordGenerator(new TrieVisitor(new Trie())));
	

	//This is a data structure that allows for the listView to display objects
	ObservableList<String> enteredWords = FXCollections.observableArrayList();
	@FXML
	ListView<String> enteredWordsView = new ListView<String>();


	
	@FXML
	Button buttonTop;
	@FXML
	Button buttonTopLeft;
	@FXML
	Button buttonTopRight;
	@FXML
	Button buttonCenter;
	@FXML
	Button buttonBottomLeft;
	@FXML
	Button buttonBottomRight;
	@FXML
	Button buttonBottom;
	@FXML
	Button buttonEnter;
	@FXML
	Button buttonShuffle;
	@FXML
	Button buttonDelete;
	@FXML
	Label enteredText = new Label("");
	
	

	
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		enteredWordsView.setItems(enteredWords);
	}
	
	
	
	
	@FXML
	public void clickTopButton (ActionEvent Action)
	{	
	
		String text = buttonTop.getText();
		enteredText.setText(enteredText.getText().concat(text) );
		System.out.println(text);
	}
	@FXML
	public void clickButtonTopRight (ActionEvent Action)
	{
		String text = buttonTopRight.getText();
		enteredText.setText(enteredText.getText().concat(text) );
		System.out.println(text);

	}	
	@FXML
	public void clickButtonTopLeft(ActionEvent Action)
	{
		String text = buttonTopLeft.getText();
		enteredText.setText(enteredText.getText().concat(text) );
		System.out.println(text);

	}
	@FXML
	public void clickButtonBottomRight (ActionEvent Action)
	{
		String text = buttonBottomRight.getText();
		enteredText.setText(enteredText.getText().concat(text) );
		System.out.println(text);

	}
	@FXML
	public void clickButtonBottom (ActionEvent Action)
	{
		String text = buttonBottom.getText();
		enteredText.setText(enteredText.getText().concat(text) );
		System.out.println(text);

	}
	@FXML
	public void clickButtonBottomLeft (ActionEvent Action)
	{
		String text = buttonBottomLeft.getText();
		enteredText.setText(enteredText.getText().concat(text) );
		System.out.println(text);

	}
	@FXML
	public void clickButtonCenter (ActionEvent Action)
	{
		String text = buttonCenter.getText();
		enteredText.setText(enteredText.getText().concat(text) );
		System.out.println(text);

	}
	@FXML
	public void clickEnterButton (ActionEvent Action)
	{	
		enteredWords.add(enteredText.getText());
		enteredText.setText("");
		System.out.println("ClickedEnter");
		

	}
	@FXML
	public void clickShuffleButton (ActionEvent Action)
	{
		List<String> lettersFromButton = new ArrayList<String>();
		lettersFromButton.add(buttonBottom.getText());
		lettersFromButton.add(buttonBottomLeft.getText());
		lettersFromButton.add(buttonTopLeft.getText());
		lettersFromButton.add(buttonTop.getText());
		lettersFromButton.add(buttonTopRight.getText());
		lettersFromButton.add(buttonBottomRight.getText());
		
		Collections.shuffle(lettersFromButton);
		
		buttonBottom.setText(lettersFromButton.get(0));
		buttonBottomLeft.setText(lettersFromButton.get(1));
		buttonTopLeft.setText(lettersFromButton.get(2));
		buttonTop.setText(lettersFromButton.get(3));
		buttonTopRight.setText(lettersFromButton.get(4));
		buttonBottomRight.setText(lettersFromButton.get(5));

		
		System.out.println("ClickedShuffle");

	}
	@FXML
	public void clickDeleteButton (ActionEvent Action){
		enteredText.setText(enteredText.getText().substring(0, enteredText.getText().length()-1));
		System.out.println("ClickedDelete");

		
	}
	

}
