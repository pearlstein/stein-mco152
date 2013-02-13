package stein.physics;

public class ParabollicCurve {
	private int angle;
	private int velocity;
	
	public ParabollicCurve(int ang,int vel){
		angle=ang;
		velocity=vel;
	}

	public void calculateXY(int startSec, int endSec) {
		double x, y;
		for (int i = startSec; i < endSec + 1; i++) {
			x = calculateX(i);
			y = calculateY(i);
			System.out.println("Time: " + i + " seconds X: " + x + " Y: " + y);
		}
	}

	public double calculateX(int i) {
		double x = Math.cos(Math.toRadians(angle)) * velocity * i;
		return x;
	}

	public double calculateY(int i) {
		double y = Math.sin(Math.toRadians(angle)) * velocity * i
				+ (.5 * -9.8 * (Math.pow(i, 2)));
		return y;
	}

	public static void main(String[] args) {
		ParabollicCurve curve = new ParabollicCurve(37,73);
		curve.calculateXY(0, 10);
	}
}
