package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import model.Model;

public class CalculatorUI {
	Model model;
	CalculatorApp app; 
// This is BAD
	int jankScale = 3;

// Constructor
	public CalculatorUI(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
		try {
			calcScreen = ImageIO.read(getClass().getResource("/gfx/SimpleCalc.png"));
		} catch (Exception e) {
			System.out.println("Failed to load background.");
			System.out.println(e);
		}

		try {
			calcFontImage = ImageIO.read(getClass().getResource("/gfx/SfiFont.png"));
		} catch (Exception e) {
			System.out.println("Failed to load font.");
			System.out.println(e);
		}

		try {
			List<BufferedImage> icons = new ArrayList<>();
			icons.add(ImageIO.read(getClass().getResource("/gfx/icon16.png")));
			icons.add(ImageIO.read(getClass().getResource("/gfx/icon32.png")));
			icons.add(ImageIO.read(getClass().getResource("/gfx/icon64.png")));
			icons.add(ImageIO.read(getClass().getResource("/gfx/icon640.png")));

			app.setIconImages(icons);
		} catch (Exception e) {
			System.out.println("Failed to load icon.");
			System.out.println(e);
		}
	}

// Icon image
		BufferedImage iconImage;
	// Getters
	public BufferedImage getIconImage(){
		return this.calcScreen;
	}	

// Background
	// Data
	BufferedImage calcScreen;
	// Getters
	public BufferedImage getCalcBcakgroundImage(){
		return this.calcScreen;
	}	

// Scale
	int scale = 1;
	public int getScale(){
		return this.scale;
	}	

// Font 
	// Data
	BufferedImage calcFontImage;
	final int startingFontIndex = 32;
	final int rows = 6;
	final int columns = 16;
	final int fontWidth = 8 * jankScale;
	final int fontHeight = 8 * jankScale;
	// Getters
	public int getstartingFontIndex(){
		return this.startingFontIndex;
	}	
	public int getRows(){
		return this.rows;
	}	
	public int getColumns(){
		return this.columns;
	}	
	public int getFontWidth(){
		return this.fontWidth;
	}	
	public int getFontHeight(){
		return this.fontWidth;
	}	
	public BufferedImage getcalcFontImage(){
		return this.calcFontImage;
	}	


// Command line 
	// Data
	private final int commandLineZeroPositionX = 8 * jankScale;
	private final int commandLineZeroPositionY = 24 * jankScale;
	private final int commandLineLength = 18;
	// Getters
	public int getCommandLinePositionX(){
		return this.commandLineZeroPositionX;
	}

	public int getCommandLinePositionY(){
		return this.commandLineZeroPositionY;
	}

	public int getCommandLineLength(){
		return this.commandLineLength;
	}

// Decimal line
	// Data
	private final int decimalLineZeroPositionX = 8 * jankScale;
	private final int decimalLineZeroPositionY = 48 * jankScale;
	private final int decimalLineLength = 5;
	// Getters
	public int getDecimalLinePositionX(){
		return this.decimalLineZeroPositionX;
	}

	public int getDecimalLinePositionY(){
		return this.decimalLineZeroPositionY;
	}

	public int getDecimalLineLength(){
		return this.decimalLineLength;
	}

// Hexadecimal line
		// Data
	private final int hexadecimalLineZeroPositionX = 56 * jankScale;
	private final int hexadecimalLineZeroPositionY = 48 * jankScale;
	private final int hexadecimalLineLength = 6;
	private final int hexadecimalNumLength = 4;
	// Getters
	public int getHexadecimalLinePositionX(){
		return this.hexadecimalLineZeroPositionX;
	}

	public int getHexadecimalLinePositionY(){
		return this.hexadecimalLineZeroPositionY;
	}

	public int getHexadecimalLineLength(){
		return this.hexadecimalLineLength;
	}

	public int getHexadecimalNumLength(){
		return this.hexadecimalNumLength;
	}

// CalcMode line
		// Data
	private final int calcModeLineZeroPositionX = 112 * jankScale;
	private final int calcModeLineZeroPositionY = 48 * jankScale;
	private final int calcModeLineLength = 5;
	// Getters
	public int getCalcModeLinePositionX(){
		return this.calcModeLineZeroPositionX;
	}

	public int getCalcModeLinePositionY(){
		return this.calcModeLineZeroPositionY;
	}

	public int getCalcModeLineLength(){
		return this.calcModeLineLength;
	}


// Binary line
	// Data
	private final int binaryLineZeroPositionX = 8 * jankScale;
	private final int binaryLineZeroPositionY = 72 * jankScale;
	private final int binaryLineLength = 18;
	private final int binaryNumLength = 16;
	// Getters
	public int getBinaryLinePositionX(){
		return this.binaryLineZeroPositionX;
	}

	public int getBinaryLinePositionY(){
		return this.binaryLineZeroPositionY;
	}

	public int getBinaryLineLength(){
		return this.binaryLineLength;
	}

	public int getBinaryNumLength(){
		return this.binaryNumLength;
	}

	// Register A
	// Data
	private final int registerALineZeroPositionX = 56;
	private final int registerALineZeroPositionY = 32;
	private final int registerALineLength = 2;

	// Getters
	public int getRegisterALinePositionX(){
		return this.registerALineZeroPositionX;
	}

	public int getRegisterALinePositionY(){
		return this.registerALineZeroPositionY;
	}

	public int getRegisterALineLength(){
		return this.registerALineLength;
	}
}
