package stein.net;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGUI extends JFrame implements WindowListener {

	private JButton sendBtn;
	private JTextField compose;
	private JTextArea chat;
	private JScrollPane scroll;
	private ReaderThread readerThread;
	private Socket socket;
	private String userName;

	public ChatGUI() throws IOException {
		super();
		
		userName=JOptionPane.showInputDialog("Enter your name: ");
		userName=userName.replace(' ','-');
		
		sendBtn = new JButton("Send");
		compose = new JTextField();
		compose.addKeyListener(new EnterListener());
		chat = new JTextArea();
		scroll = new JScrollPane(chat);
		chat.setEditable(false);
		setLayout(new BorderLayout());

		add(scroll, BorderLayout.CENTER);
		add(new ComposePanel(sendBtn, compose), BorderLayout.SOUTH);
		sendBtn.addActionListener(new ClickListener());
		
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setName("Chat");

		initializeClient();

		readerThread.start();
		setVisible(true);
		
		addWindowListener(this);

	}

	public void windowClosing(WindowEvent w){
		try{
		String s="LEAVE "+userName;
		readerThread.send(s);
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
	private void initializeClient() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.105", 8080);
		readerThread = new ReaderThread(socket, this);
		String s="JOIN "+userName;
		readerThread.send(s);
	}

	public void getChatMessage(String s) {
		String oldChats = chat.getText();
		chat.setText(oldChats + "\n" + s);
	}

	public void sendTheChat() throws IOException {
		String s =  "SAY "+userName+" "+compose.getText();
		readerThread.send(s);
		compose.setText("");

	}

	public static void main(String[] args) {
		try {
			new ChatGUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ComposePanel extends JPanel {
		public ComposePanel(JButton send, JTextField compose) {
			setLayout(new BorderLayout());
			add(compose, BorderLayout.CENTER);
			add(send, BorderLayout.EAST);
		}
	}

	private class ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				sendTheChat();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private class EnterListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			if (event.getKeyCode() == KeyEvent.VK_ENTER) {
				try {
					sendTheChat();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {

		}

	}

	@Override
	public void windowActivated(WindowEvent arg0) {		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {	
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

}