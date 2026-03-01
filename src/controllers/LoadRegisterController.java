package controllers;

import model.Calculator;
import model.GBInstruction;
import model.Message;
import model.Model;
import model.Operand;
import model.RegisterOperand;
import model.Result;
import view.CalculatorApp;

public class LoadRegisterController {
	Model model;
	CalculatorApp app; 

	public LoadRegisterController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}
	
	// Determine what command the user has written, or if we need to send them an error
	public static Result loadRegister(GBInstruction instruction, Calculator calc){
		Result result;
		Operand destination = instruction.getOperand0();
		// Only run if the instruction is in the form LD REGISTER, IMMEDIATE
		if(!(destination instanceof RegisterOperand regOp)){
			result = new Result(Message.OPERAND_ERROR); 
		}
		else{
			calc.setRegister(regOp.getRegisterName(), (byte) instruction.getOperand1().getOperandValue(calc));
			result = new Result(instruction.getOperand1().getOperandValue(calc), Message.SUCCESS);
		}
		return result;
	}
}
