package stein.net;

public class Messages {

	private MessageType messageType;
	private String msg;
	private String name;
	
	public Messages(String str){
		parseMessage(str);
	}
	private void parseMessage(String string){
		int index=string.indexOf(' ');
		String msgType=string.substring(0, index);
		this.messageType=MessageType.valueOf(msgType);
		
		int secondIndex=string.indexOf(' ',++index);
		this.name=string.substring(index,secondIndex);
		
		this.msg=string.substring(secondIndex);
		
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public String getMsg() {
		return msg;
	}
	public String getName() {
		return name;
	}
	public static void main(String[] args){
		Messages m=new Messages("JOIN stein hi whats up");
		System.out.println(m.getMessageType().toString());
		System.out.println(m.getName());
		System.out.println(m.getMsg());
	}

}
