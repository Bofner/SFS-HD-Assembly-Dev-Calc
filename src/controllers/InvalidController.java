package controllers;

import model.Calculator;
import model.GBInstruction;
import model.Message;
import model.Model;
import model.Result;
import view.CalculatorApp;

public class InvalidController {
	Model model;
	CalculatorApp app; 

	public InvalidController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}
	
	// Send the user an INVALID OPERAND error
	public static Result invalidOperand(GBInstruction instruction, Calculator calc){
		Result result = new Result(Message.OPERAND_ERROR);
		return result;
	}

	// Send the user an INVALID MNEMONIC error
	public static Result invalidMnemonic(GBInstruction instruction, Calculator calc){
		Result result = new Result(Message.MNEMONIC_ERROR);
		return result;
	}
}
