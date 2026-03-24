package controllers;

import model.Calculator;
import model.GBInstruction;
import model.Message;
import model.Model;
import model.Result;
import view.CalculatorApp;

public class ConverterController {
	Model model;
	CalculatorApp app; 

	public ConverterController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}
	
	// Convert the user input into the proper bases
	public static Result convertBases(GBInstruction instruction, Calculator calc){
		Result result;
		if(instruction.getOperand0() == null){
			result = new Result(Message.OPERAND_ERROR);
		}
		else{
			result = new Result(instruction.getOperand0().getOperandValue(calc), Message.SUCCESS, calc);
		}
		
		return result;
	}
}
