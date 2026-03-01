package controllers;

import model.Model;
import model.TextSprite;
import view.CalculatorApp;

public class FontMapperController {
	Model model;
	CalculatorApp app; 
	
// Initializer
	public FontMapperController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}

// Turn a string into an array of text sprites for the UI to display
	public TextSprite[] convertStringToFont(String s){
		// Grab the Dec value
		TextSprite[] textSpritesArray = new TextSprite[s.length()];
		// Find each character's coresponding glyph in our SfiFont.png file
		for(int i = 0; i < s.length(); i++){
			// Get the current char and its numerical unicode representation
			char currentChar = s.charAt(i);
			int currentCharValue = currentChar;
			int fontCharX = ((currentCharValue - app.getCalculatorUI().getstartingFontIndex()) % 16) * app.getCalculatorUI().getFontWidth();
			int fontCharY = ((currentCharValue - app.getCalculatorUI().getstartingFontIndex()) / 16) * app.getCalculatorUI().getFontHeight();
			TextSprite textSprite = new TextSprite(fontCharX, fontCharY, fontCharX + app.getCalculatorUI().getFontWidth(), fontCharY + app.getCalculatorUI().getFontHeight());
			textSpritesArray[i] = textSprite;
		}
		return textSpritesArray;
	}

}
