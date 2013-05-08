package stein.net;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MessageFormatter {

	public String formatMessage(String msg) {
		
		ArrayList<String> messages = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(msg);
		while (tokenizer.hasMoreTokens()) {
			messages.add(tokenizer.nextToken());
		}

		String name=messages.get(1);
		if (messages.get(0).equalsIgnoreCase("SAY")) {
			msg = name + ": " ;
			for(int i=2;i<messages.size();i++){
				msg+=messages.get(i)+" ";
			}
		} else if (messages.get(0).equalsIgnoreCase("JOIN")) {
			msg = name + " HAS JOINED";
		} else if (messages.get(0).equalsIgnoreCase("LEAVE")) {
			msg = name + " HAS LEFT";
		}
		
		return msg;
	}
}
