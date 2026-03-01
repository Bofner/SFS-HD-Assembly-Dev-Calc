package controllers;

import model.Model;
import view.CalculatorApp;

public class OperandController {
	Model model;
	CalculatorApp app; 

	public OperandController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}

	// Split up any operands
	public String[] splitOperands(String rawOperands){
		// Remove the commas and capitalize
		String[]operands = rawOperands.toUpperCase().split(",");
		// Remove any leading blank spaces
		for(int i = 0; i < operands.length; i++){
			operands[i] = operands[i].trim();
		}

		if(operands.length > 2){
			return null;
		}
		else{
			return operands;
		}
		
	}

}
