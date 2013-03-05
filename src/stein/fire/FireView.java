package stein.fire;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JComponent;

public class FireView extends JComponent {

	private ArrayList<Particle> particles;
	private LinkedList<Fountain> fountains;
	private ArrayList<Particle> pool;
	private int pointer;
	private Iterator<Particle> iterator;

	public FireView() {
		particles = new ArrayList<Particle>();
		fountains = new LinkedList<Fountain>();
		pool = new ArrayList<Particle>();
		pointer = 0;

		FireMouseListener listener = new FireMouseListener();
		this.addMouseListener(listener);

		addParticlesToPool();
	}

	private Color getParticleColor(Particle p) {
		double time = p.getTime();
		if (time > p.getLifespan())
			return (Color.BLACK);
		else if (time > 3)
			return (Color.GRAY);
		else if (time > 2)
			return (Color.RED);
		else if (time > .8)
			return (Color.ORANGE);
		else if (time > .4)
			return (Color.YELLOW);
		else
			return Color.WHITE;
	}

	private int getParticleSize(Particle p) {
		double time = p.getTime();

		if (time > 3)
			return 28;
		else if (time > 2)
			return 20;
		else if (time > .8)
			return 14;
		else if (time > .4)
			return 12;
		else
			return 10;
	}

	private void addParticlesToPool() {
		for (int i = 0; i < 80000; i++) {
			pool.add(new Fountain(-1, -1).getParticle());
		}
	}

	private void getParticlesFromPool(Fountain f) {
		for (int i = 0; i < 100; i++) {
			// reset pointer to beginning of list, if reach end
			if (pointer == pool.size() - 1){
				pointer = 0;
			}
			Particle p = pool.get(pointer++);
			
			while (p.getStartX() != -1) {
				if (pointer == pool.size() - 1){
					pointer = 0;
				}
				p = pool.get(pointer++);
			}

			p.setTime(0);
			p.setStartX(f.getX());
			p.setStartY(f.getY());
			particles.add(p);

		}
	}

	private void returnParticleToPool(Particle p) {
		p.setStartX(-1);
		p.setStartY(-1);
		particles.remove(p);
	}

	private void addParticles(Fountain f) {
		for (int i = 0; i < 200; i++) {
			particles.add(f.getParticle());
		}
	}

	public void addFountain(int x, int y) {
		Fountain fountain = new Fountain(x, y);
		fountains.add(fountain);

		addParticles(fountain);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.translate(0, this.getHeight());

		Iterator<Fountain> iter = fountains.iterator();
		while (iter.hasNext()) {
			getParticlesFromPool(iter.next());
		}

		g.setColor(Color.GREEN);
		g.drawString("" + particles.size(), -this.getWidth() / 2 + 40,
				this.getHeight() / 2 - 40);

		g2.setComposite(AlphaComposite
				.getInstance(AlphaComposite.SRC_OVER, .1f));

		//iterator = particles.iterator();
		for(int i=0;i<particles.size();i++) {
			Particle prt = particles.get(i);
			prt.tick();

			if (prt.getTime() > prt.getLifespan()) {
				returnParticleToPool(prt);
			} else {
				g.setColor(getParticleColor(prt));
				int size = (getParticleSize(prt));

				int x = (int) prt.getX(prt.getTime());
				int y = (int) prt.getY(prt.getTime());

				g.fillOval(x - (size / 2), -(y - (size / 2)), size, size);

			}

		}
		this.repaint();
	}

	public LinkedList<Fountain> getFountains() {
		return this.fountains;
	}
}