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

	private LinkedList<Particle> particles;
	private Random randomNumberGenerator;
	private double time;
	private int size;

	public GraphComponent() {
		particles = new LinkedList<Particle>();
		randomNumberGenerator = new Random();
		time = 0.0;
		addParticles();
	}

	private Particle buildRandomParticle() {
		return new Particle(45 + getRandomNumber(96), 60 + getRandomNumber(41),
				time, getRandomNumber(6));
	}

	private int getRandomNumber(int range) {
		return randomNumberGenerator.nextInt(range);
	}

	private Color getParticleColor(Particle p) {
		double pTime = p.getTime();
		if (time - pTime > p.getLifespan())
			return Color.BLACK;
		else if (time - pTime > 3)
			return (Color.GRAY);
		else if (time - pTime > 2)
			return (Color.RED);
		else if (time - pTime > .8)
			return (Color.ORANGE);
		else if (time - pTime > .4)
			return (Color.YELLOW);
		else
			return Color.WHITE;
	}

	private int getParticleSize(Particle p) {
		double pTime = p.getTime();

		if (time - pTime > 3)
			return 28;
		else if (time - pTime > 2)
			return 20;
		else if (time - pTime > .8)
			return 14;
		else if (time - pTime > .4)
			return 12;
		else
			return 10;
	}

	private void addParticles() {
		for (int i = 0; i < 150; i++) {
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

		time += .06;

		Iterator<Particle> iterator = particles.iterator();

		while (iterator.hasNext()) {
			Particle prt = iterator.next();

			if (time - prt.getTime() > prt.getLifespan()) {
				iterator.remove();
			} else {
				g.setColor(getParticleColor(prt));
				size = (getParticleSize(prt));

				int x = (int) prt.getX(time - prt.getTime());
				int y = (int) prt.getY(time - prt.getTime());

				g.fillOval(x - (size / 2), -(y - (size / 2)), size, size);

				this.repaint();
			}
		}
	}
}