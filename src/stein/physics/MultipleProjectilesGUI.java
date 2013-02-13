package stein.physics;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MultipleProjectilesGUI extends JFrame {

	public MultipleProjectilesGUI() {

		setSize(800,600);
		setTitle("MULTIPLE PROJECTILES GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		add(new GUIComponent(20), BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		new MultipleProjectilesGUI();
	}
}
