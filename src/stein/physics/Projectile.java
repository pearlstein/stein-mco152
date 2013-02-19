package stein.physics;

import java.awt.Color;

public class Projectile {

	//private for data encapsulation
	private double angle;
	private double velocity;
	private Color color;
	private double time;
	
	public Projectile(double angle, double velocity,Color color) {
		this.angle = angle;
		this.velocity = velocity;
		this.color=color;
		this.time=0;
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

	public static void main(String[] args){
		Projectile p=new Projectile(11,37,Color.blue);
	}
	public double getTime(){
		return this.time;
	}
	public void tick(){
		this.time+=.001;
	}
	
}
