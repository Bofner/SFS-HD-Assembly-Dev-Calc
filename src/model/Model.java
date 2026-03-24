package model;

public class Model {
	
	private Calculator calc = new Calculator();
	private StringBuilder commandLineBuffer = new StringBuilder();

// Initializer
	public Model( ) {}

// Getters
	public Calculator getCalculator() { return calc; }


// Command Line
	
	// Returns an all caps version of the user input
	public String getCommandLineBuffer() { 
		String currentCommandLine = commandLineBuffer.toString();
		return currentCommandLine; 
	}

// Setters
	public void appendCommandLineBuffer(char userInput) { 
		commandLineBuffer.append(userInput);
	}

	public void resetCommandLineBuffer() { 
		commandLineBuffer.setLength(0);
	}

	public void backspaceCommandLineBuffer(int cursorPos) { 
		if(commandLineBuffer.length() > 0 && cursorPos >= 0){
			// Remove the character and shorten the commandLineBuffer
			commandLineBuffer.deleteCharAt(cursorPos);
		}
	}

	public void deleteCommandLineBuffer(int cursorPos) { 
		if(commandLineBuffer.length() > 0 && cursorPos < commandLineBuffer.length()){
			// Remove the character and shorten the commandLineBuffer
			commandLineBuffer.deleteCharAt(cursorPos + 1);
			System.out.println("Current String Builder Length: " + getCommandLineBuffer().length());
		}
	}

	// Delete History

	// History

// Current Result
	private Result currentResult = new Result(0, Message.UNINITIALIZED, calc);
// Getters
	// Returns the most current result
	public Result getCurrentResult() { 
		return this.currentResult; 
	}

// Setter
	public void setNewResult(Result r){
		// Put old result into HISTORY

		// Update to new result
		this.currentResult = r;
	}



	

}
