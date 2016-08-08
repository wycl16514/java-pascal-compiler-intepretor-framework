package frontend;
import java.io.BufferedReader;
import java.io.IOException;

import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;
import message.MessageType;


public class Source implements MessageProducer{
   public static final char EOL = '\n'; //end of line
   public static final char EOF = (char)0; //end of file
   private static int INITIAL_CHAR_POS = -2;
   
   private  BufferedReader  reader;  //用来读取源代码文件
   private  String line;   //一行源代码
   private  int    lineNum;  //当前处于源代码文件的第几行
   private  int    currentPos = INITIAL_CHAR_POS;  //当前处于第几列
   private  MessageHandler messageHandler;
   
   public Source(BufferedReader  reader) throws IOException {
	   this.lineNum = 0;
	   this.currentPos = -2;
	   this.reader = reader;
	   this.messageHandler = new MessageHandler();
   }
   
   public int getLineNum() {
	   return lineNum;
   }
   
   public int getPosition() {
	   return currentPos;
   }
   /*
    * 当前从源文件中读入的字符
    */
   public char currentChar() throws Exception{
	   if (currentPos == INITIAL_CHAR_POS) {
		   readLine();
		   return nextChar();
	   } else if (line == null) {
		   return EOF;
	   } else if((currentPos == -1) || (currentPos == line.length())){
		   return EOL;
	   } else if (currentPos > line.length()) {
		   readLine();
		   return nextChar();
	   } else {
		   return line.charAt(currentPos);
	   }
   }
   
   public char nextChar() throws Exception{
	   ++currentPos;
	   return currentChar();
   }
   
   public char peekChar() throws Exception{
	   currentChar();
	   if (line == null) {
		   return EOL;   
	   }
	   
	   int  nextPos = currentPos + 1;
	   return nextPos < line.length() ? line.charAt(nextPos) : EOL;
   }
   
   private void readLine() throws IOException{
	   line = reader.readLine();
	   currentPos = -1;
	   
	   if (line != null) {
		   ++lineNum;
		   sendMessage(new Message(MessageType.SOURCE_LINE, new Object[]{lineNum, line}));
	   }
   }
   
   public void close() throws Exception{
	   if (reader != null) {
		   try {
			   reader.close();
		   }
		   catch(IOException ex) {
			   ex.printStackTrace();
			   throw ex;
		   }
	   }
   }

@Override
public void addMessageListener(MessageListener listener) {
	messageHandler.addListener(listener);
	
}

@Override
public void removeMessageListener(MessageListener listener) {
	messageHandler.removeListener(listener);
}

@Override
public void sendMessage(Message message) {
	messageHandler.sendMessage(message);
}
   
}
