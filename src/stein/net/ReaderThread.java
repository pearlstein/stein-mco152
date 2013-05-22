package stein.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderThread extends Thread {

	private ChatGUI gui;
	private InputStream in;
	private final static Logger log = Logger.getLogger(MessageFormatter.class
			.getName());
	private Message[] messageList;
	private Message message;
	
	public ReaderThread(Socket socket, ChatGUI chat) throws IOException {
		gui = chat;
		in = socket.getInputStream();
		messageList=new Message[]{new JoinMessage(),new LeaveMessage(),new SayMessage(),new AnnounceMessage()};
	}


	public void run() {

		Scanner scanner = new Scanner(in);
		while (scanner.hasNext()) {
			String msgString = scanner.nextLine();
			
			log.log(Level.INFO, msgString);
			
			for(Message m:messageList){
				if(m.isMessage(msgString)){
					message=m;
					break;
				}
			}
			message.handle(gui,msgString);
			log.log(Level.INFO, "after getChatMessage()");
		}
	}

}