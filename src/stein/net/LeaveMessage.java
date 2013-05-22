package stein.net;

public class LeaveMessage implements Message{

	private String clientName;
	
	@Override
	public void handle(ChatGUI gui,String string) {
		buildMessage(string);
		gui.getConversationPanel().removeSpeaker(clientName);

		string=clientName+" has left";
		gui.modifyChatMessage(string);
		
	}

	@Override
	public boolean isMessage(String string) {
		return (string.startsWith("LEAVE"));
	}

	@Override
	public void buildMessage(String string) {
		clientName=string.substring(6);
		
	}

}
