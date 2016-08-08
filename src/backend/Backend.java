package backend;

import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;

public abstract class Backend implements MessageProducer {
    protected  static  MessageHandler messageHandler;
    
    static {
    	messageHandler = new MessageHandler();
    }
    
    protected SymTab symTab;
    protected ICode iCode;
    
    public abstract void process(ICode iCode, SymTab symTab) throws Exception;
    
    public void sendMessage(Message message) {
    	messageHandler.sendMessage(message);
    }
    
    public void addMessageListener(MessageListener listener) {
    	messageHandler.addListener(listener);
    }
    
    public void removeMessageListener(MessageListener listener) {
    	messageHandler.removeListener(listener);
    }
    
}
