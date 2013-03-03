package stein.fire;

import java.awt.Color;

public class Particle {

	//private for data encapsulation
	private double angle;
	private double velocity;
	private double time;
	private double lifespan;
	private int startX;
	private int startY;
	private double sinAngle;
	private double cosAngle;
	
	public Particle(double angle, double velocity,double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time=time;
		this.sinAngle=Math.sin(Math.toRadians(angle));
		this.cosAngle=Math.cos(Math.toRadians(this.angle));
	}
	public Particle(double angle, double velocity,double time,double lifespan) {
		this.angle = angle;
		this.velocity = velocity;
		this.time=time;
		this.setLifespan(lifespan);
		this.sinAngle=Math.sin(Math.toRadians(angle));
		this.cosAngle=Math.cos(Math.toRadians(this.angle));
	}
	public Particle(double angle, double velocity,double time,double lifespan,int startX,int startY) {
		this.angle = angle;
		this.velocity = velocity;
		this.time=time;
		this.setLifespan(lifespan);
		this.startX=startX;
		this.startY=startY;
		this.sinAngle=Math.sin(Math.toRadians(angle));
		this.cosAngle=Math.cos(Math.toRadians(this.angle));
	}
	public int getStartX() {
		return startX;
	}
	public void setStartX(int startX) {
		this.startX = startX;
	}
	public int getStartY() {
		return startY;
	}
	public void setStartY(int startY) {
		this.startY = startY;
	}
	public double getX(double time){
		return this.cosAngle * velocity * time+startX;
	}
	public double getY(double time){
		return this.sinAngle * velocity * time + (.5 * -9.8 * time * time)+startY;
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
	public void tick(){
		this.time+=.06;
	}
}
