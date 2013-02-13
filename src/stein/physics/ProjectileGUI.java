package stein.physics;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ProjectileGUI extends JFrame{
	
	public ProjectileGUI(){

		setSize(800,600);
		setTitle("Projectile GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		add(new GraphComponent(1),BorderLayout.CENTER);

		
		setVisible(true);
	}
	
	public static void main(String[] args){
		new ProjectileGUI();
	}
}
