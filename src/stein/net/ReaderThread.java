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
	private MessageFormatter messageFormatter;
	private final static Logger log = Logger.getLogger(MessageFormatter.class
			.getName());

	public ReaderThread(Socket socket, ChatGUI chat) throws IOException {
		gui = chat;
		in = socket.getInputStream();
		messageFormatter = new MessageFormatter();
	}


	public void run() {

		Scanner scanner = new Scanner(in);
		while (scanner.hasNext()) {
			String msg = scanner.nextLine();
			msg = messageFormatter.formatMessage(msg);
			log.log(Level.INFO, msg);
			System.out.println(msg);
			gui.getChatMessage(msg);
			log.log(Level.INFO, "after getChatMessage()");
		}
	}

}