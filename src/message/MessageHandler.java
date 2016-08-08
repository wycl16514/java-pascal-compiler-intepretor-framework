package message;

import java.util.ArrayList;

public class MessageHandler {
    private Message message;
    private ArrayList<MessageListener> listeners;
    
    public MessageHandler() {
    	this.listeners = new ArrayList<MessageListener>();
    }
    
    public void addListener(MessageListener listener) {
    	listeners.add(listener);
    }
    
    public void removeListener(MessageListener listener) {
    	listeners.remove(listener);
    }
    
    public void sendMessage(Message message) {
    	this.message = message;
    	notifyListeners();
    }
    
    private void notifyListeners() {
    	for (MessageListener listener : listeners) {
    		listener.messageReceived(message);
    	}
    }
    
}
