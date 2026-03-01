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
}
