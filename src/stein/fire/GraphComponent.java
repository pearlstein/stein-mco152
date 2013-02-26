package stein.fire;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	//private LinkedList<Particle> particles;
	private List<Particle> particles;
	private Random randomNumberGenerator;
	private Iterator<Particle> iterator;

	public GraphComponent(int numCurves) {
		particles = new LinkedList<Particle>();
		randomNumberGenerator = new Random();

		for (int i = 0; i < 100; i++) {
			particles.add(buildRandomParticle());
		}

	}

	private Particle buildRandomParticle() {
		return new Particle(45 + getRandomNumber(96),
				40+ getRandomNumber(41), Color.WHITE, getRandomNumber());
	}

	private int getRandomNumber(int range) {
		return randomNumberGenerator.nextInt(range);
	}

	private double getRandomNumber() {
		return randomNumberGenerator.nextDouble();
	}

	private void setParticleColor(Particle p) {
		double time = p.getTime();

		if (time > p.getLifespan())
			particles.remove(p);
		else if (time > .8)
			p.setColor(Color.GRAY);
		else if (time > .6)
			p.setColor(Color.RED);
		else if (time > .4)
			p.setColor(Color.ORANGE);
		else if (time > .18)
			p.setColor(Color.YELLOW);
	}

	private void addParticles() {
		for (int i = 0; i < 100; i++) {
			particles.add(buildRandomParticle());
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.translate(this.getWidth() / 2, this.getHeight() / 2);

		addParticles();

		g2.setComposite(AlphaComposite
				.getInstance(AlphaComposite.SRC_OVER, .1f));

		int size = 10;

		iterator = particles.listIterator();

		/*
		while (iterator.hasNext()) {
			Particle prt = iterator.next();
			prt.tick();
			
			setParticleColor(prt);
			g.setColor(prt.getColor());

			int x = (int) prt.getX(prt.getTime());
			int y = (int) prt.getY(prt.getTime());

			g.fillOval(x - (size / 2), -(y + (size / 2)), size, size);

			this.repaint();
		}*/

		
		 for (int i = 0; i < particles.size(); i++) {
		 
		 Particle prt = particles.get(i); prt.tick();
		 
		 setParticleColor(prt); g.setColor(prt.getColor());
		 
		 int x = (int) prt.getX(prt.getTime()); int y = (int)
		 prt.getY(prt.getTime());
		 
		 g.fillOval(x - (size / 2), -(y + (size / 2)), size, size);
		 
		 this.repaint();
		 
		 }
	}
}