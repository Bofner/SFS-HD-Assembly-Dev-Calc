package model;

import controllers.AdditionController;
import controllers.SubtractionController;
import controllers.MultiplicationController;
import controllers.DivisionController;
import controllers.OrController;
import controllers.AndController;
import controllers.XorController;
import controllers.ConverterController;
import controllers.EasterController;
import controllers.InvalidController;
import controllers.LoadRegisterController;
import controllers.CalcModeController;

public enum Mnemonic {
	// Addition
	ADD(2, AdditionController::add),

	// Subtraction
	SUB(2, SubtractionController::sub),

	// Multiplication
	MULT(2, MultiplicationController::mult),

	// Division
	DIV(2, DivisionController::div),

	// Binary Or
	OR(2, OrController::binOr),

	// Binary And
	AND(2, AndController::binAnd),

	//Binary Xor
	XOR(2, XorController::binXor),

	// Load Register
	LD(2, LoadRegisterController::loadRegister),

	// Convert numbers to the 3 available bases
	CONV(1, ConverterController::convertBases),

	// Invalid Operand (Likely not called by user, but they can)
	MODE(1,CalcModeController::updateCalcMode),

	// Invalid Operand (Likely not called by user, but they can)
	INVO(0,InvalidController::invalidOperand),

	// Invalid Mnemonic (Likely not called by user, but they can)
	INVM(0,InvalidController::invalidMnemonic),

	// Display the Splash Screen
	SFS(0, EasterController::steelFingerStudios),
	SFI(0, EasterController::steelFingerStudios);


	// CP

	// RR

	// INC

	// DEC

	// BIT

	// LDI

	// LDD

	// CPL

	// SRL

	// RLA

	// SLA

	// RLC

	// RRC

	// QUIT

	// HELP

	


	// SWAP



// Constructor
	private final int operandCount;
	Mnemonic(int operandCount, InstructionExecutor executor) {
		this.operandCount = operandCount;
		this.executor = executor;
	}

// Getters
	// Return the number of operands
	public int getOperandCount(){
		return this.operandCount;
	}

// Mnemonic embedded function
	// Allows us to call a function from the Mnemonic
	@FunctionalInterface
	public interface InstructionExecutor {
		Result execute(GBInstruction instruction, Calculator calc);
	}
	// Execute the function held by the Mnemonic's parallel controller
	private final InstructionExecutor executor;
	public Result execute(GBInstruction instruction, Calculator calc) {
		return executor.execute(instruction, calc);
	}

		

		
	
}
