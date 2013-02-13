package stein.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.QuadCurve2D;

import javax.swing.JComponent;

public class GUIComponent extends JComponent {

	private Projectile[] projectilesArray;
	private int startAngle;
	private int startVelocity;

	public GUIComponent(int numCurves) {
		projectilesArray = new Projectile[numCurves];
		startAngle = 37;
		startVelocity = 73;

		//set up array of projectiles with increasing angles and velocities
		for (int i = 0; i < numCurves; i++) {
			projectilesArray[i] = new Projectile(startAngle, startVelocity);
			startAngle += 3;
			startVelocity += 3;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.translate(30, this.getHeight()-100);
		
		//set initial color
		g.setColor(new Color(0, 255, 0));

		//set starting size of points
		int size = 10;
		
		for (int j = 0; j < projectilesArray.length; j++) {
			//change color for each projectile
			g.setColor(new Color(g.getColor().getRed() + 30, g.getColor().getGreen() - 30, g.getColor().getBlue() + 30));
			//increment size of points for each projectile
			size +=3;
			
			int prevX=0;
			int prevY=0;
			for (int i = 0; i <= 10; i++) {
				int x = (int) projectilesArray[j].getX(i);
				int y = (int) projectilesArray[j].getY(i);
				
				g.drawOval(x-(size/2),- (y+(size/2)), size, size);
				
				if(i>0)
					//g.drawLine(x,-y,(int)projectilesArray[j].getX(i-1),-(int)projectilesArray[j].getY(i-1));
					g.drawLine(x,-y,prevX,-prevY);
				
				prevX=x;
				prevY=y;
			}
		}

	}
}
