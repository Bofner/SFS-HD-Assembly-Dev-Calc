package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.GBInstruction;
import model.IllegalOperand;
import model.ImmediateOperand;
import model.Mnemonic;
import model.Model;
import model.NumericBase;
import model.Operand;
import model.OperandType;
import model.Register;
import model.RegisterOperand;
import view.CalculatorApp;

public class TextParserController {
	Model model;
	CalculatorApp app; 

	public TextParserController(Model m, CalculatorApp app) {
		this.model = m;
		this.app = app;
	}
	
	// Separates the Mnemonic and Operands
	public GBInstruction parseInstruction(String userInput){
		// Chekc for OP Codes Based off that, send us somewhere or throw an error
		boolean safeUserInput = true;			// Make sure we have proper input
		Mnemonic mnemonic = null;				// Initialize our Mnemonic
		List<Operand> operandList = new ArrayList<>(Arrays.asList()); 	// Initialize our Operands (even if there aren't any)
		GBInstruction instruction;
	// Trim the input
		String line = userInput.trim();
	// Start by seeing if we just have a plain number input
		Operand tryConversion = checkForProperOperand(line);
		if (tryConversion.getType() != OperandType.ILLEGAL){
			instruction = new GBInstruction(Mnemonic.CONV, tryConversion);
			return instruction;
		}

	// If we got here, then it's not just a plain number input
		// Split mnemonic and operands
		String[] tokens = line.toUpperCase().split(" ", 2);
		// Convert our mnemonic String into a Mnemonic (if we can)
		try{
			mnemonic = Mnemonic.valueOf(tokens[0]);
		} catch(Exception e){
			//System.out.println("Invalid mnemonic");
			instruction = new GBInstruction(Mnemonic.INVM);
			return instruction;
		}

	// Next grab the Operands, if we have any
		if(tokens.length > 1){
			String operandsLineString = tokens[1];
			// Save operands as individual strings
			String[] operandStrings = new OperandController(model, app).splitOperands(operandsLineString);
			if(operandStrings == null){
				//System.out.println("Invalid operands");
				instruction = new GBInstruction(Mnemonic.INVO);
				return instruction;
			}
			// Convert to actual operands
			// Set our strings to be registers or numbers
			for(int i=0; i<operandStrings.length;i++){
				Operand checkOperand = checkForProperOperand(operandStrings[i]);
				if(checkOperand.getType() != OperandType.ILLEGAL){
					operandList.add(checkOperand);
				} else{
					instruction = new GBInstruction(Mnemonic.INVO);
					return instruction;
				}
			} 
		}
		// In the case that we have a zero operand call, we still want to fill our instruction with operands
		if (operandList.size() < 2){
			operandList.add(null);
			operandList.add(null);
		}
		// At this point we should have either: null or an Operand object in our Operand List
		if(safeUserInput){
			instruction = new GBInstruction(mnemonic, operandList.get(0), operandList.get(1));
			return instruction;
		}
		else{
			return null;
		}
	}	

// Check if our input is a proper Hexadecimal, Decimal, Binary or Registry input
	public Operand checkForProperOperand(String userInput){
		Operand o;

		Register r = Register.fromString(userInput);	// Check if we have a register
		// If we have a REGISTER
		if(r != null){
			o = new RegisterOperand(r);
		}
		// If we have an IMMEDIATE
		else{
			// Initialize as DEC since it has no prefixes
			NumericBase operandBase = NumericBase.DEC;					// Our operand's base radix
			String operandPrefix = null;								// The prefix for our operand's base radix
			int operandValue = 0;										// The value of our operand
			String currentStringOperand = userInput.trim();		// The operand without any spaces

			// Check if we have a HEX or BIN prefix
			for(NumericBase baseCheck : new NumericBase[]{NumericBase.HEX, NumericBase.BIN}){
				String checkedPrefix = baseCheck.getPrefixFromString(currentStringOperand);
				if(checkedPrefix != null){
					operandBase = baseCheck;
					operandPrefix = checkedPrefix;
					break;
				}
			}

			// If our operand prefix is null, then we can just parse int
			if(operandPrefix == null){
			// Handle bad input
				try{
					operandValue =  Integer.parseInt(currentStringOperand, operandBase.radix);
					o = new ImmediateOperand(operandValue);
				} catch (Exception e){
					o = new IllegalOperand();
					return o;
				}
			}
			// If we have HEX or BIN
			else{
				String operandValueString = operandBase.removePrefixFromString(currentStringOperand);
			// Handle bad input
				try {
					operandValue =  Integer.parseInt(operandValueString, operandBase.radix);
					o = new ImmediateOperand(operandValue);
				} catch (Exception e){
					//System.out.println("Invalid operand");
					o = new IllegalOperand();
					return o;
				}
			}
		}
			
		return o;
	} 

		// Check for PEMDAS operations, +, -. (, ), *, ^

		// I'll figure this out later...
}
