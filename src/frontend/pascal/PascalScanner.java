package frontend.pascal;

import frontend.EofToken;
import frontend.Scanner;
import frontend.Source;
import frontend.Token;

public class PascalScanner extends Scanner {

	public PascalScanner(Source source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Token extractToken() throws Exception {
		Token token;
		char currentChar = currentChar();
		
		if (currentChar == Source.EOF) {
			token = new EofToken(source);
		} else {
			token = new Token(source);
		}
		
		return token;
	}

}
