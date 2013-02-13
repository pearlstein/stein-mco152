package stein.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class GUIComponent extends JComponent {

	private Projectile[] projectilesArray;
	private double time = 0;

	public GUIComponent(int numCurves) {
		projectilesArray = new Projectile[numCurves];

		Random randomNum = new Random();

		// set up array of projectiles with increasing angles and velocities and
		// randomColors
		for (int i = 0; i < numCurves; i++) {
			projectilesArray[i] = new Projectile(randomNum.nextInt(360),
					100+randomNum.nextInt(201),
					new Color(randomNum.nextInt(256),randomNum.nextInt(256), randomNum.nextInt(256)));
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.translate(this.getWidth() / 2, this.getHeight() / 2);
		
		for(int i=0;i<this.getWidth();i+=5){
			g.drawLine(i,this.getHeight(),this.getWidth(),0);
		}
		time += .001;
		

		// set starting size of points
		int size = 10;

		for (int j = 0; j < projectilesArray.length; j++) {
			// increment size of points for each projectile
			size += 3;

			g.setColor(projectilesArray[j].getColor());

			int prevX = 0;
			int prevY = 0;

			int x = (int) projectilesArray[j].getX(time);
			int y = (int) projectilesArray[j].getY(time);

			g.fillOval(x - (size / 2), -(y + (size / 2)), size, size);
			//g.fillRect(x-(size/4), -(y+size/4), size, size);

			/*
			 * if(time>0)
			 * //g.drawLine(x,-y,(int)projectilesArray[j].getX(i-1),-(
			 * int)projectilesArray[j].getY(i-1));
			 * g.drawLine(x,-y,prevX,-prevY);
			 */
			prevX = x;
			prevY = y;

			this.repaint();

		}

	}
}
