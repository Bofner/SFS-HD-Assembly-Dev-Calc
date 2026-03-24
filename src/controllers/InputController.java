package controllers;

import model.Model;
import model.Result;
import view.CalculatorApp;

public class InputController {
	Model model;
	CalculatorApp app; 
	
	public InputController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}
	
	// Updates the command line buffer
	// Called from any key press
	public void updateCommandLine(char commandLineBufferInput){
		// Check for legal key press
		// Update to all caps
		if(model.getCommandLineBuffer().length() < app.getCalculatorUI().getCommandLineLength()){
			model.appendCommandLineBuffer(commandLineBufferInput);
			
		} 
	}

	// Returns the instruction the user wants the calculator to execute
	// Called from ENTER
	public void executeUserInstruction(){
		// Get the result
		new CalculatorController(model, app).instructionControlPipeline();
	}

	// Does a backspace action on the command line
	// Called from BACK_SPACE
	public void backspaceUserInstruction(){
		model.backspaceCommandLineBuffer(model.getCommandLineBuffer().length() - 1);
	}

	// Does a tab action on the command line
	// Called from BACK_SPACE
	public String tabUserInstruction(){
		Result prevResult = model.getCurrentResult();
		int tabbedInput = prevResult.getIntResult();
		String tabbedCommandLine = String.format("%s",tabbedInput);
		return tabbedCommandLine;
	}

}
