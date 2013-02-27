package stein.fire;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JComponent;

public class FireView extends JComponent {

	private LinkedList<Particle> particles;
	private LinkedList<Fountain> fountains;

	public FireView() {
		particles = new LinkedList<Particle>();
		fountains = new LinkedList<Fountain>();
		
		FireMouseListener listener=new FireMouseListener();
		this.addMouseListener(listener);
		
		//addFountain(0,this.getHeight());
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

	private void addParticles(Fountain f) {
		for (int i = 0; i < 100; i++) {
			particles.add(f.getParticle());
		}
	}

	public void addFountain(int x, int y) {
		Fountain fountain=new Fountain(x,y);
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
		
		Iterator<Fountain> iter=fountains.iterator();
		while(iter.hasNext()){
			addParticles(iter.next());
		}
		

		g.setColor(Color.GREEN);
		g.drawString("" + particles.size(), -this.getWidth() / 2 + 40,
				this.getHeight() / 2 - 40);

		g2.setComposite(AlphaComposite
				.getInstance(AlphaComposite.SRC_OVER, .1f));

		Iterator<Particle> iterator = particles.iterator();

		while (iterator.hasNext()) {
			Particle prt = iterator.next();
			prt.tick();

			if (prt.getTime() > prt.getLifespan()) {
				iterator.remove();
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

	public LinkedList<Fountain> getFountains(){
		return this.fountains;
	}
}