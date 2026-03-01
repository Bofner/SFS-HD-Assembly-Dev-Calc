package model;

public class ImmediateOperand extends Operand{

	public final int immediateValue;		// immediateValue of the register or immediate
	//public final int width;		// Is it 8-bit or 16-bit? Or higher?

// Constructor
	// Imediate Operand
	public ImmediateOperand(int value){
		super(OperandType.IMMEDIATE);
		this.immediateValue = value;
		//this.width = width;
	}

// Getters
	public int getOperandValue(Calculator calc){
		return this.immediateValue;
	}
}

