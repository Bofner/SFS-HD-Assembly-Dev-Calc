package model;

import java.util.HashMap;
import java.util.Map;

public enum CalcMode {
// Modes
	eightBit,
	sixteenBit;

// String maps
	private static final Map<String, CalcMode> calcModeLookup = new HashMap<>();
	static{
		calcModeLookup.put("eightBit", CalcMode.eightBit);
		calcModeLookup.put("sixteenBit", CalcMode.sixteenBit);
    }

// Functions
	// Get calcMode from string
	public static CalcMode fromString(String token){
		return calcModeLookup.get(token);
	}


}
