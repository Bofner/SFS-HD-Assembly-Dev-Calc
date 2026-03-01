package model;

public class GBInstruction {
// Properties
	Mnemonic mnemonic;
	Operand operand0;
	Operand operand1;

// Constructor
	public GBInstruction(Mnemonic m, Operand o0, Operand o1){
		this.mnemonic = m;
		this.operand0 = o0;
		this.operand1 = o1;
	}
	public GBInstruction(Mnemonic m, Operand o0){
		this.mnemonic = m;
		this.operand0 = o0;
	}
	public GBInstruction(Mnemonic m){
		this.mnemonic = m;
	}

// Getters
	public Operand getOperand0(){
		return operand0;
	}
	public Operand getOperand1(){
		return operand1;
	}

// Functions
	// Execute associated function from GBInstruction
	public Result executeOpCode(Calculator calc){
		// Depending on the current bit-mode, return the value in the appropriate size
		Result calculation = this.mnemonic.execute(this, calc);

		return calculation;
	}
}
