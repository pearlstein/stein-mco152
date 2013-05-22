package stein.net;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ConversationPanel extends JPanel {
	private DefaultListModel defaultList;
	private JList clientList;
	private JScrollPane scroll;
	private HashMap<String, String> clientMap;

	public ConversationPanel() {
		setLayout(new BorderLayout());
		setSize(200,200);
		add(new JLabel("Clients: "), BorderLayout.NORTH);
		setBorder(new EmptyBorder(50,30,50,30));

		defaultList = new DefaultListModel();
		clientList = new JList(defaultList);
		scroll = new JScrollPane(clientList);
		add(scroll, BorderLayout.CENTER);
		clientMap=new HashMap<String,String>();
	}

	public void addSpeaker(String name) {
		if (!clientMap.containsKey(name)) {
			clientMap.put(name, name);
			defaultList.addElement(name);
		}
	}

	public void removeSpeaker(String name) {
		clientMap.remove(name);
		defaultList.removeElement(name);
	}

}
