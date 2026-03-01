package model;

public abstract class Operand {
	private final OperandType type;			// Register, Immediate or Illegal?

	protected Operand(OperandType type){
		this.type = type;
	}

	public OperandType getType(){
		return type;
	}

	public abstract int getOperandValue(Calculator calc);

}