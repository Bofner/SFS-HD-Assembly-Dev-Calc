package model;

public class Result {
	int intResult;
	String hexResult;
	String decResult;
	String binResult;
	Message message;			// For giving the user feedback if the result failed

	// A result that didn't succeed. Used for reporting an ERROR
	public Result(Message m){
		this.message = m;
		this.decResult = m.getDecErrorMessage();
		this.hexResult = m.getHexErrorMessage();
		this.binResult = m.getBinErrorMessage();
	}

	// A successful result. Used to show the user the result of their input command
	public Result(int i, Message m, Calculator calc){
		if(calc.getCalcMode() == CalcMode.eightBit){
			this.intResult = i & 0xFF;
			this.hexResult = String.format("  0x%02X",this.intResult);
			this.decResult = String.format("  %3s",this.intResult);
			this.binResult = "        " + String.format("0b%8s",Integer.toBinaryString(this.intResult & 0xFF)).replace(' ', '0');
		}
		else if (calc.getCalcMode() == CalcMode.sixteenBit){
			this.intResult = i & 0xFFFF;
			this.hexResult = String.format("0x%04X",this.intResult);
			this.decResult = String.format("%5s",this.intResult);
			this.binResult = String.format("0b%16s",Integer.toBinaryString(this.intResult & 0xFFFF)).replace(' ', '0');
		}		
		this.message = m;
	}

// Getters
	public int getIntResult(){
		return this.intResult;
	}
	public String getHexResult(){
		return this.hexResult;
	}
	public String getDecResult(){
		return this.decResult;
	}
	public String getBinResult(){
		return this.binResult;
	}
	public Message getmessage(){
		return this.message;
	}

// Setters
/* 	public void setIntResult(int intResult){
		this.intResult = intResult;
	}
	public void setHexResult(String  hexValue){
		this.hexResult = hexValue;
	}
	public void setDecResult(String  decValue){
		this.decResult = decValue;
	}
	// setBinResult();
	public void setMessage(Message m){
		this.message = m; 
	} */

}


