package stein.net;

public class AnnounceMessage implements Message {

	private String clientName;
	
	@Override
	public void handle(ChatGUI gui,String string) {
		buildMessage(string);
		gui.getConversationPanel().addSpeaker(clientName);

		
	}

	@Override
	public boolean isMessage(String string) {
		return (string.startsWith("ANNOUNCE"));
	}

	@Override
	public void buildMessage(String string) {
		clientName=string.substring(9);
		
	}

}
