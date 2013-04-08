package stein.fire;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Fire extends JFrame {

	public Fire() {

		setSize(1200,850);
		//setSize(800,600);
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
