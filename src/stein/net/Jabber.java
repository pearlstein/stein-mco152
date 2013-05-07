package stein.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Jabber {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 8080);
		OutputStream out = socket.getOutputStream();

		String message;
		for (int i = 0; i < 1000; i++) {
			message = "LINE #" + (i + 1) + "\n";
			out.write(message.getBytes());
			out.flush();
		}

		socket.close();
	}
}
