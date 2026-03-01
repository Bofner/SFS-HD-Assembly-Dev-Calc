package model;

public enum LegalCharacter {
	SPACE(' '),
	COMMA(','),
	POUND('#'),
	DOLLAR('$'),
	PERCENT('%'),
	ZERO('0'),
	ONE('1'),
	TWO('2'),
	THREE('3'),
	FOUR('4'),
	FIVE('5'),
	SIX('6'),
	SEVEN('7'),
	EIGHT('8'),
	NINE('9'),
	PLUS('+'),
	MINUS('-'),
	FORWARD_SLASH('/'),
	ASTERIX('*'),
	OPEN_PAREN('('),
	CLOSE_PAREN(')');

	public final char characters;
	LegalCharacter(char characters){
		this.characters = characters;
	}

	// Returns the legal character
	public char getLegalCharacterFromChar(char tokenChar) {
		char illegalChar = '!';
		if (tokenChar == characters) {
			return characters;
		} else{
			return illegalChar;
		}
        
    }
	
}
