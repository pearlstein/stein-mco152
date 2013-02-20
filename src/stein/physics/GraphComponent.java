package stein.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	private Projectile[] projectilesArray;
	private Random randomNumberGenerator;

	public GraphComponent(int numCurves) {
		projectilesArray = new Projectile[numCurves];
		randomNumberGenerator=new Random();

		// set up array of projectiles with increasing angles, velocities and
		// randomColors
		for (int i = 0; i < numCurves; i++) {
			projectilesArray[i] = buildRandomProjectile();
		}
	}

	private Projectile buildRandomProjectile() {
		return new Projectile(getRandomNumber(360),
				200 + getRandomNumber(301), 
				new Color(getRandomNumber(256),getRandomNumber(256), getRandomNumber(256)));
	}

	private void drawGraph(Graphics g) {
		for (int i = 0; i < this.getWidth(); i += 15) {
			g.drawLine(i, 0, i, this.getHeight());
		}
		for (int i = 0; i < this.getHeight(); i += 15) {
			g.drawLine(0, i, this.getWidth(), i);
		}
	}

	private int getRandomNumber(int range) {
		return randomNumberGenerator.nextInt(range);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawGraph(g);

		g.translate(this.getWidth() / 2, this.getHeight() / 2);

		// set starting size of points
		int size = 10;

		// int prevX = 0;
		// int prevY = 0;

		for (int j = 0; j < projectilesArray.length; j++) {
			// increment size of points for each projectile
			size += 3;

			g.setColor(projectilesArray[j].getColor());

			projectilesArray[j].tick();
			int x = (int) projectilesArray[j].getX(projectilesArray[j].getTime());
			int y = (int) projectilesArray[j].getY(projectilesArray[j].getTime());

			// continuity and lifespan
			// if projectile goes off current window, replace it with a new projectile at the origin
			if (isOffScreen(x, y)) {
					 		projectilesArray[j] = buildRandomProjectile();
			}

			g.fillOval(x - (size / 2), -(y + (size / 2)), size, size);

			/*
			 * if(projectilesArray[j].getTime()>0){
			 * g.drawLine(x,-y,prevX,-prevY); prevX = x; prevY = y; }
			 */

			this.repaint();

		}

	}

	private boolean isOffScreen(int x, int y) {
		return x > (this.getWidth() / 2) || x < -(this.getWidth() / 2)
				|| y > (this.getHeight() / 2)|| y < -(this.getHeight() / 2);
	}
}
