package stein.fire;

import java.util.LinkedList;
import java.util.Random;

public class Fountain {
	
	private int x;
	private int y;
	private Random randomNumberGenerator;
	
	public Fountain(int x, int y){
		this.x=x;
		this.y=y;
		randomNumberGenerator=new Random();
	}
	
	public Particle getParticle(){
		return new Particle(45 + getRandomNumber(96), 60 + getRandomNumber(41),
				0, getRandomNumber(6),this.x,this.y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private int getRandomNumber(int range) {
		return randomNumberGenerator.nextInt(range);
	}
	public void setParticle(Particle p){
		p.setStartX(this.x);
		p.setStartY(this.y);
	}
}
