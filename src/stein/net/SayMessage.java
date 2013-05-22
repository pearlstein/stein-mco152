package stein.net;

public class SayMessage implements Message {

	private String clientName;
	private String messageText;

	@Override
	public void handle(ChatGUI gui, String string) {
		buildMessage(string);
		string = clientName + ": " + messageText;
		gui.modifyChatMessage(string);

	}

	@Override
	public boolean isMessage(String string) {
		return (string.startsWith("SAY"));
	}

	@Override
	public void buildMessage(String string) {
		int index = string.indexOf(' ', 4);
		clientName = string.substring(4, index);
		messageText = string.substring(clientName.length() + 5);
	}

}
