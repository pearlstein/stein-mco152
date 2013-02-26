package stein.fire;

import java.awt.Color;

public class Particle {

	//private for data encapsulation
	private double angle;
	private double velocity;
	private double time;
	private double lifespan;
	
	public Particle(double angle, double velocity,double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time=time;
	}
	public Particle(double angle, double velocity,double time,double lifespan) {
		this.angle = angle;
		this.velocity = velocity;
		this.time=time;
		this.setLifespan(lifespan);
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
	public void setTime(double time){
		this.time=time;
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
