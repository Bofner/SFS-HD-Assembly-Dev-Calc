package controllers;

import model.Calculator;
import model.GBInstruction;
import model.Message;
import model.Model;
import model.Result;
import view.CalculatorApp;

public class EasterController {
	Model model;
	CalculatorApp app; 

	public EasterController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}
	
	// Send the user an INVALID OPERAND error
	public static Result steelFingerStudios(GBInstruction instruction, Calculator calc){
		Result result = new Result(Message.SFS);
		return result;
	}

	// Send the user an INVALID MNEMONIC error
	public static Result tonbow(GBInstruction instruction, Calculator calc){
		Result result = new Result(Message.SUCCESS);
		return result;
	}
}
