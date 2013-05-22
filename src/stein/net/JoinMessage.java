package stein.net;

import java.io.IOException;


public class JoinMessage implements Message {

	private String clientName;
	
	@Override
	public void handle(ChatGUI gui,String string){
		buildMessage(string);
		gui.getConversationPanel().addSpeaker(clientName);

		string=clientName+" has joined";
		gui.modifyChatMessage(string);
		
		try{
		gui.sendAnnounceMessage();
		}catch(IOException io){
			io.printStackTrace();
		}

	}

	@Override
	public boolean isMessage(String string) {
		return (string.startsWith("JOIN"));
	}

	@Override
	public void buildMessage(String string) {
		clientName=string.substring(5);		
	}
}
