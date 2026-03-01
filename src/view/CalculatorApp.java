package view;

import javax.swing.JFrame;

import java.awt.Dimension;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import controllers.InputController;
import model.LegalCharacter;
import model.Model;

public class CalculatorApp extends JFrame{

	private DrawingPanel contentPane;
	// Getter
	public DrawingPanel getContentFrame(){
		return this.contentPane;
	}
	Model model;
	private CalculatorUI calculatorUI = new CalculatorUI(model, CalculatorApp.this);
	// Getter
	public CalculatorUI getCalculatorUI(){
		return this.calculatorUI;
	}

// Constructor
	public CalculatorApp(Model m) throws IOException{
		// Initialize the background of our calculator application
		super();
		this.model = m;
		setTitle("SFS H↔D");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Draw the graphics for our calculator app
		// Grab the image files we want
		BufferedImage calcScreen = calculatorUI.getCalcBcakgroundImage();
		BufferedImage calcFont = calculatorUI.getcalcFontImage();
		contentPane = new DrawingPanel(m, CalculatorApp.this, calculatorUI, calcScreen, calcFont);
		
		// Set the content pane to be the correct size for our drawing
		contentPane.setPreferredSize(new Dimension(calcScreen.getWidth(),  calcScreen.getHeight()));
		setContentPane(contentPane);
		pack();            // Use this so our content pane is the correct size, not just the window
		setLocationRelativeTo(null); // center on screen	

		// Check for any key inputs from the user
		contentPane.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e){
			// Check for our non-displaying keys
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					new InputController(m, CalculatorApp.this).executeUserInstruction();
				} else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					new InputController(m, CalculatorApp.this).backspaceUserInstruction();
				}
				repaint();
			}
			@Override
			public void keyTyped(KeyEvent e){
				char inputChar = Character.toUpperCase(e.getKeyChar());
			// Check for any key presses from letters
				if(Character.isUpperCase(inputChar)){
					// Update the command line buffer
					new InputController(m, CalculatorApp.this).updateCommandLine(inputChar);
				} else{
			// Check for our other legal characters
				for(LegalCharacter legalCheck : LegalCharacter.values()){
					char checkedCharacter = legalCheck.getLegalCharacterFromChar(inputChar);
					if(checkedCharacter != '!'){
						// Update the command line buffer
						new InputController(m, CalculatorApp.this).updateCommandLine(inputChar);
						break;
					}
				}
			// Display our new command line
				//new FontMapperController(m, CalculatorApp.this).convertCommandLineStringToFont();
				repaint();
				}
			}
		});
	}


}
