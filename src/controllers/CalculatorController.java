package controllers;

import model.GBInstruction;
import model.Model;
import view.CalculatorApp;

public class CalculatorController {
	Model model;
	CalculatorApp app; 

	public CalculatorController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}
	public void instructionControlPipeline(){
		// Get the current user command line buffer
		String userInstructioString = model.getCommandLineBuffer();
		// Reset the command line
		model.resetCommandLineBuffer();
		// Return instruction String as an Instruction object
		GBInstruction instruction = new TextParserController(model, app).parseInstruction(userInstructioString);
		// Execute GBInstruction and give the result to our model
		// Errors will be handled by the instruction
		model.setNewResult(instruction.executeOpCode(model.getCalculator()));			
	
		// Redraw the screen
		app.getContentFrame().repaint();
		
	}
}
