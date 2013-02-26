package stein.fire;

import java.awt.Color;

public class Particle {

	//private for data encapsulation
	private double angle;
	private double velocity;
	private Color color;
	private double time;
	private double lifespan;
	
	public Particle(double angle, double velocity,Color color) {
		this.angle = angle;
		this.velocity = velocity;
		this.color=color;
		this.time=0;
	}
	public Particle(double angle, double velocity,Color color,double lifespan) {
		this.angle = angle;
		this.velocity = velocity;
		this.color=color;
		this.time=0;
		this.setLifespan(lifespan);
	}
	public void setColor(Color c){
		this.color=c;
	}
	public Color getColor(){
		return color;
	}
	public double getX(double time){
		return Math.cos(Math.toRadians(angle)) * velocity * time;
	}
	public double getY(double time){
		return Math.sin(Math.toRadians(angle)) * velocity * time + (.5 * -9.8 * time * time);
	}
	public double getTime(){
		return this.time;
	}
	public void tick(){
		this.time+=.008;
	}
	public double getLifespan() {
		return lifespan;
	}
	public void setLifespan(double lifespan) {
		this.lifespan=lifespan>0?lifespan:1.0;
	}
	public double getAngle() {
		return angle;
	}
	public double getVelocity() {
		return velocity;
	}
}
