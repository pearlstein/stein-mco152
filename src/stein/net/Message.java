package stein.net;

public interface Message {
	public abstract void handle(ChatGUI gui,String string);
	public abstract boolean isMessage(String string);
	public abstract void buildMessage(String string);
}
