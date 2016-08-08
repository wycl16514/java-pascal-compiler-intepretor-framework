package frontend;

import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;

public abstract class Parser implements MessageProducer{
    protected  static SymTab symTab;
    protected static MessageHandler messageHandler;
    static {
    	symTab = null;
    	messageHandler = new MessageHandler();
    }
    
    protected Scanner scanner;
    protected ICode  iCode; //生成中间代码
    
    protected Parser(Scanner scanner) {
    	this.scanner = scanner;
    	this.iCode = null;
    }
    
    public Scanner getScanner() {
    	return scanner;
    }
    
    public ICode getICode() {
    	return iCode;
    }
    
    public SymTab getSymTab() {
    	return symTab;
    }
    
    /*
     * 解析原代码文件，同时生成中间代码以及构造符号表。
     * 不同的编程语言解析器通过继承该接口来解析不同的源代码
     */
    
    public abstract void parse() throws Exception;
    
    /*
     * 返回代码中语法错误的个数
     */
    public abstract int getErrorCount();
    
    public  Token  currentToken() {
    	return scanner.currentToken();
    }
    
    public Token nextToken() throws Exception {
    	return scanner.nextToken();
    }
    
    public void addMessageListener(MessageListener listener) {
    	messageHandler.addListener(listener);
    }
    
    public void removeMessageListener(MessageListener listener) {
    	messageHandler.removeListener(listener);
    }
    
    public void sendMessage(Message message) {
    	messageHandler.sendMessage(message);
    }
    
}
