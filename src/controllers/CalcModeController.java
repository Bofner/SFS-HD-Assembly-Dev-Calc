package controllers;

import model.Calculator;
import model.GBInstruction;
import model.Message;
import model.Model;
import model.Operand;
import model.Result;
import view.CalculatorApp;
import model.CalcMode;

public class CalcModeController {
	Model model;
	CalculatorApp app; 

	public CalcModeController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}
	
	// Determine what command the user has written, or if we need to send them an error
	public static Result updateCalcMode(GBInstruction instruction, Calculator calc){
		Result result;
		Operand operand0 = instruction.getOperand0();
		if(operand0 == null){
			result = new Result(Message.OPERAND_ERROR);
		}
		else if(operand0.getOperandValue(calc) == 8){
			calc.setCalcMode(CalcMode.eightBit);
			result = new Result(Message.SUCCESS);
		}
		else if(operand0.getOperandValue(calc) == 16){
			calc.setCalcMode(CalcMode.sixteenBit);
			result = new Result(Message.SUCCESS);
		}
		else{
			result = new Result(Message.OPERAND_ERROR);
		}

		return result;
	}
}
