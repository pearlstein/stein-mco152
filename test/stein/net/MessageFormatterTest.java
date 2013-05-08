package stein.net;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessageFormatterTest {

	MessageFormatter messageFormatter;
	@Before
	public void setUp() throws Exception {
		messageFormatter=new MessageFormatter();
	}

	@Test
	public void testFormatMessage() {
		String newString=messageFormatter.formatMessage("Say Stein hi");
		assertEquals("Stein: hi",newString);
		System.out.println(newString);
		
		newString=messageFormatter.formatMessage("Join Stein");
		assertTrue("Stein has joined".equalsIgnoreCase(newString));
		System.out.println(newString);
		
		newString=messageFormatter.formatMessage("Leave Stein");
		assertTrue("Stein has left".equalsIgnoreCase(newString));
		System.out.println(newString);
	}

}
