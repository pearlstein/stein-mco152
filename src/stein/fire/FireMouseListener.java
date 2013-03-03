package stein.fire;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.LinkedList;

public class FireMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {
		FireView view = (FireView) event.getSource();

		LinkedList<Fountain> fountainList = view.getFountains();

		Iterator<Fountain> iterator = fountainList.iterator();

		boolean removed = false;

		while (iterator.hasNext()) {
			Fountain fountain = iterator.next();
			// if distance is less than 10, remove fire
			if (Math.sqrt(Math.pow((fountain.getX() - event.getX()), 2)
					+ Math.pow(fountain.getY() - (view.getHeight() - event.getY()),2)) 
						< 10) {
				iterator.remove();
				removed = true;
			}
		}
		if (!removed)
			view.addFountain(event.getX(), view.getHeight() - event.getY());
	}

	@Override
	public void mouseEntered(MouseEvent event) {

	}

	@Override
	public void mouseExited(MouseEvent event) {

	}

	@Override
	public void mousePressed(MouseEvent event) {

	}

	@Override
	public void mouseReleased(MouseEvent event) {

	}

}
