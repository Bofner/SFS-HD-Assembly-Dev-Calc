package model;

import java.util.EnumMap;

public class Calculator {
// Initializer
    public Calculator() {
        // Initialize all registers to 0
        for (Register r : Register.values()) {
            registers.put(r, (byte) 0);
        }
	}

    private CalcMode calcMode = CalcMode.sixteenBit;

// All of the CPU's Registers
	private final EnumMap<Register, Byte> registers =
            new EnumMap<>(Register.class);

// Getters
	public byte getRegister(Register r) {
        return registers.get(r);
    }

// Setters
    public void setRegister(Register r, byte value) {
        registers.put(r, value);
    }

// Mode
	
	// Returns the current mode
	public CalcMode getCalcMode() { 
		return this.calcMode; 
	}
    public String getCalcModeString(){
        if (calcMode == CalcMode.eightBit){
            return "8-BIT";
        }
        else{
            return "16BIT";
        }
        
    }

// Setters
	public void setCalcMode(CalcMode newCalcMode) { 
		this.calcMode = newCalcMode;
	}


}
