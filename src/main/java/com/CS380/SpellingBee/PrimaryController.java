package com.CS380.SpellingBee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

public class PrimaryController implements Initializable {

	String[] listOfLetters = {"M", "A", "H", "O", "G", "O", "N", "Y"};
	Game gameInstance = new Game(listOfLetters, new WordGenerator(new TrieVisitor(new Trie())));
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
	{	gameInstance.addWordToEntered(enteredText.getText());
		enteredText.setText("");
		System.out.println("ClickedEnter");
		

	}
	@FXML
	public void clickShuffleButton (ActionEvent Action)
	{
		System.out.println("ClickedShuffle");

	}
	@FXML
	public void clickDeleteButton (ActionEvent Action){
		enteredText.setText(enteredText.getText().substring(0, enteredText.getText().length()-1));
		System.out.println("ClickedDelete");

		
	}
	

}
