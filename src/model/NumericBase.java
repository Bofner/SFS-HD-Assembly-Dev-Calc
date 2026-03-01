package model;

public enum NumericBase {
	HEX(16, "$", "0X", "#"),
	BIN(2, "%", "0B"),
	DEC(10);

	public final int radix;
	private final String[] prefixes;
	int value = 0;

	NumericBase(int radix, String... prefixes){
		this.radix = radix;
		this.prefixes = prefixes;
	}

	// Check if we have the prefix we want
	public boolean checkPrefix(String token) {
        for (String p : prefixes) {
            if (token.startsWith(p)) {
                return true;
            }
        }
        return false;
    }

	// Returns the prefix
	public String getPrefixFromString(String token) {
        for (String p : prefixes) {
            if (token.startsWith(p)) {
                return token.substring(0, p.length());
            }
        }
        return null;
    }

	// Returns the number after the prefix
	public String removePrefixFromString(String token) {
        for (String p : prefixes) {
            if (token.startsWith(p)) {
                return token.substring(p.length());
            }
        }
        return token;
    }
	
}
