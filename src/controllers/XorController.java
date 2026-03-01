package controllers;

import model.Calculator;
import model.GBInstruction;
import model.Message;
import model.Model;
import model.Operand;
import model.RegisterOperand;
import model.Result;
import view.CalculatorApp;

public class XorController {
	Model model;
	CalculatorApp app; 

	public XorController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}
	
	// Determine what command the user has written, or if we need to send them an error
	public static Result binXor(GBInstruction instruction, Calculator calc){
		Result result;
		Operand operand0 = instruction.getOperand0();
		Operand operand1 = instruction.getOperand1();
		if(operand0 == null ||  operand1 == null){
			result = new Result(Message.OPERAND_ERROR);
		}
		else{
			int xorResult = operand0.getOperandValue(calc) ^ operand1.getOperandValue(calc);
			// Update a register if it was operand0
			if((operand0 instanceof RegisterOperand regOp)){
				calc.setRegister(regOp.getRegisterName(), (byte)xorResult);
			}
			result = new Result(xorResult, Message.SUCCESS);
			// Update our Flags register
		}
		return result;
	}
}
