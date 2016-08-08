package backend;

import message.Message;
import message.MessageType;
import intermediate.ICode;
import intermediate.SymTab;

public class CodeGenerator extends Backend {

	@Override
	public void process(ICode iCode, SymTab symTab) throws Exception {
		long startTime = System.currentTimeMillis();
		float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        int  instructionCount = 0;
        
        sendMessage(new Message(MessageType.COMPILER_SUMMARY, new Number[] {
        		instructionCount,
        		elapsedTime
        }));
	}

}
