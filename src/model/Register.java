package model;

import java.util.HashMap;
import java.util.Map;

public enum Register {
// Registers
	A,
	B,
	C,
	D,
	E,
	F,
	H,
	L;

// String maps
	private static final Map<String, Register> registerLookup = new HashMap<>();
	static{
		registerLookup.put("A", Register.A);
		registerLookup.put("B", Register.B);
		registerLookup.put("C", Register.C);
		registerLookup.put("D", Register.D);
		registerLookup.put("E", Register.E);
		registerLookup.put("F", Register.F);
		registerLookup.put("H", Register.H);
		registerLookup.put("L", Register.L);
	}

// Functions
	// Get register from string
	public static Register fromString(String token){
		return registerLookup.get(token);
	}



	


	
}
