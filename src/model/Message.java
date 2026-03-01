package model;

public enum Message {
	UNINITIALIZED("UNINT"),
	SFS("STEEL", "FINGER", "  STUDIOS"),
	POST_BOOT,
	SUCCESS,
	OPERAND_ERROR("ERR:", "SYNTAX", "INVALID OPERAND(S)"),
	MNEMONIC_ERROR("ERR:", "SYNTAX", "INVALID OPCODE"); 

// Constructor
	private  String errorMessage = "ERROR";
	private  String decMessage = "DEC";
	private  String hexMessage = "HEX";
	private  String binMessage = "BIN";
	Message() {
	}
	Message(String msg) {
		this.errorMessage = msg;
	}
	Message(String decMsg, String hexMsg, String binMsg) {
		this.decMessage = decMsg;
		this.hexMessage = hexMsg;
		this.binMessage = binMsg;
	}

// Getters
	// Return the error message
	public String getErrorMessage(){
		return this.errorMessage;
	}
	// Return the decimal error message
	public String getDecErrorMessage(){
		return this.decMessage;
	}
	// Return the hexadecimal error message
	public String getHexErrorMessage(){
		return this.hexMessage;
	}
	// Return the binary error message
	public String getBinErrorMessage(){
		return this.binMessage;
	}

}
