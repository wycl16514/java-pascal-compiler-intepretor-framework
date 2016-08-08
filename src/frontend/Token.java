package frontend;


public class Token {
    protected TokenType  type;
    protected String     text;
    protected Object     value; //Token 的内容
    protected Source     source;
    protected int        lineNum;
    protected int        position;
    
    public Token(Source source) throws Exception{
    	this.source = source;
    	this.lineNum = source.getLineNum();
    	this.position = source.getPosition();
    	
    	extract();
    }
    
    public TokenType getType() {
    	return type;
    }
    
    public String getText() {
    	return text;
    }
    
    public Object getValue() {
    	return value;
    }
    
    public int getLineNumber() {
    	return lineNum;
    }
    
    public int getPosition() {
    	return position;
    }
    
    protected void extract() throws Exception{
    	text = Character.toString(currentChar());
    	value = null;
    	
    	nextChar();
    }
    
    protected char currentChar() throws Exception{
    	return source.currentChar();
    }
    
    protected char nextChar() throws Exception{
    	return source.nextChar();
    }
    
    protected char peekChar() throws Exception {
    	return source.peekChar();
    }
    
    
}
