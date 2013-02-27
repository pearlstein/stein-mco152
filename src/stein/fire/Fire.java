package stein.fire;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Fire extends JFrame {

	public Fire() {

		setSize(1440,850);
		setTitle("FIRE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		add(new FireView(), BorderLayout.CENTER);
		
		setFocusable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Fire();
	}
}
