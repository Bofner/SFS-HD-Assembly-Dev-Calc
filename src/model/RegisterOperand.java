package model;

public class RegisterOperand extends Operand{
	public final Register name;		// Register name, or null if immediate
	//public final int width;		// Is it 8-bit or 16-bit? Or higher?

	// Register Operand
	public RegisterOperand(Register register){
		super(OperandType.REGISTER);
		this.name = register;
		//this.width = register.getWidth();
	}

// Getters
	public Register getRegisterName(){
		return this.name;
	}
	public int getOperandValue(Calculator calc){
		return calc.getRegister(this.name);
	}
}
