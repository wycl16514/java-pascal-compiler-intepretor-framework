package backend;

import message.Message;
import message.MessageType;
import intermediate.ICode;
import intermediate.SymTab;

public class Executor extends Backend {

	@Override
	public void process(ICode iCode, SymTab symTab) throws Exception {
		long startTime = System.currentTimeMillis();
		float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
		int executionCount = 0;
		int runtimeErrors = 0;
		
		sendMessage(new Message(MessageType.INTEPRETER_SUMMARY, new Number[] {
				executionCount,
				runtimeErrors,
				elapsedTime
		}));
		
	}

}
