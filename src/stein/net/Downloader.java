package stein.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;

public class Downloader {

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		// to download web page, using http-port 80
		Socket socket = new Socket("www.amazon.com", 80);

		// to write to socket, get output stream to socket
		OutputStream out = socket.getOutputStream();
		out.write("GET /index.html\n\n".getBytes());
		out.flush();// flush sends the data along

		// now that wrote, get back the data with inputStream
		InputStream in = socket.getInputStream();

		// first method
		byte byteReturned = 0;
		while (byteReturned != -1) {
			byteReturned = (byte) in.read();
			System.out.print((char) byteReturned);
		}
		// a little better
		byte[] byteArray = new byte[1024];
		int numRead = in.read(byteArray, 0, byteArray.length);
		while (numRead != -1) {
			System.out.print(new String(byteArray, 0, numRead));
			numRead = in.read(byteArray, 0, byteArray.length);
		}
		
		//correct way with apache library
		String s=IOUtils.toString(in);
		System.out.println(s);
		
		socket.close();

	}
}
