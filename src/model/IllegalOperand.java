package model;

public class IllegalOperand extends Operand{
	// Register Operand
	public IllegalOperand(){
		super(OperandType.ILLEGAL);
	}

	public int getOperandValue(Calculator calc){
		return 0;
	}
}

