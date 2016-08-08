package frontend.pascal;

import message.Message;
import message.MessageType;
import frontend.EofToken;
import frontend.Parser;
import frontend.Scanner;
import frontend.Token;

public class PascalParserTD extends Parser {

	public PascalParserTD(Scanner scanner) {
		super(scanner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parse() throws Exception {
		Token token;
		long startTime = System.currentTimeMillis();
		
		while(!((token = nextToken()) instanceof EofToken)) {
			
		}
		
		float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
		sendMessage(new Message(MessageType.PARSER_SUMMARY, new Number[]{
				token.getLineNumber(),
				getErrorCount(),
				elapsedTime
		}));
	}

	@Override
	public int getErrorCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
