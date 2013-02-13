package stein.physics;

import java.awt.Graphics;

import javax.swing.JComponent;

//make a custom control to draw a projectile
public class GraphComponent extends JComponent {
	private Projectile projectile = new Projectile(37, 73);

	
	// override paint component of JComponent and in there do the draw calls
	// the only place allowed to draw is inside paint component or by a method
	// called by paint component
	@Override
	protected void paintComponent(Graphics g) {
		// Graphics is representing screen, draw calls on graphics will draw on screen
		
		super.paintComponent(g);
		
		g.translate(0,this.getHeight());
		
		for (int i = 0; i <= 10; i++) {
			g.drawOval((int) projectile.getX(i),-(int) projectile.getY(i), 10,10);
		}

	}

}
