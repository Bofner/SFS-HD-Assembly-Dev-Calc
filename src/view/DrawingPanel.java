package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import controllers.FontMapperController;
import model.Model;
import model.Register;
import model.Result;
import model.TextSprite;

public class DrawingPanel extends JPanel {
	Model model;
	CalculatorApp app;
	CalculatorUI calculatorUI;
	BufferedImage calcScreen;
	BufferedImage calcFont;
	int scale;

	public DrawingPanel(Model model, CalculatorApp app, CalculatorUI ui, BufferedImage background, BufferedImage font) {
		this.model = model;
		this.app = app;
		this.calculatorUI = ui;
		// Grab the image files we want
		this.calcFont = ui.getcalcFontImage();
		this.calcScreen = ui.getCalcBcakgroundImage();		
		this.scale = ui.getScale();
		
	}

	// Here is where all of our drawing will take place
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw the background
		g.drawImage(calcScreen, 0, 0, null);
		// Draw our command line on top of that
		drawStringAsFont(g, model.getCommandLineBuffer(), calculatorUI.getCommandLinePositionX(), calculatorUI.getCommandLinePositionY());

		// Draw the base conversions
		Result resultSprites = model.getCurrentResult();
		// DEC) Draw the dec font
		drawStringAsFont(g, resultSprites.getDecResult(), calculatorUI.getDecimalLinePositionX(), calculatorUI.getDecimalLinePositionY());

		// HEX) Draw the hex font
		drawStringAsFont(g, resultSprites.getHexResult(), calculatorUI.getHexadecimalLinePositionX(), calculatorUI.getHexadecimalLinePositionY());

		// BIN) Draw the bin font
		drawStringAsFont(g, resultSprites.getBinResult(), calculatorUI.getBinaryLinePositionX(), calculatorUI.getBinaryLinePositionY());
			
		// Draw the history

		// Draw the registers
		// A) Draw the current value of A in Hexadecimal
/* 		String registerAFString = "0x" + Integer.toHexString(model.getCalculator().getRegister(Register.A)).toUpperCase()
								 + Integer.toHexString(model.getCalculator().getRegister(Register.F)).toUpperCase();
		drawStringAsFont(g, registerAFString, calculatorUI.getRegisterALinePositionX(), calculatorUI.getRegisterALinePositionY()); */

		// Draw the flags

		// Draw the cursor
		
		
	}	

	private void drawStringAsFont(Graphics g, String line, int x0, int y0){
		TextSprite[] lineSprites = new FontMapperController(model, app).convertStringToFont(line);
		for(int i = 0; i < line.length();i++){
			g.drawImage(calcFont, 
			x0 + (i * calculatorUI.getFontWidth()),
			y0, 
			x0 + (i * calculatorUI.getFontWidth()) + calculatorUI.getFontWidth(),
			y0 + calculatorUI.getFontHeight(),
			lineSprites[i].getsourceX1(), lineSprites[i].getsourceY1(),
			lineSprites[i].getsourceX2(), lineSprites[i].getsourceY2(),
				null);
		}
	}

// Getter
	public int getScale(){
		return this.scale;
	}
	
}
