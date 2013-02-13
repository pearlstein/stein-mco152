package stein.physics;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParabollicCurveTest {

	ParabollicCurve aCurve=new ParabollicCurve(37,73);
	
	@Test
	public void testCalculateX() {
		assertTrue(aCurve.calculateX(5)==291.50196116726187);
		
		assertEquals(0,aCurve.calculateX(0),.9);
		
		assertEquals(291,aCurve.calculateX(5),.9);
		
		assertEquals(583,aCurve.calculateX(10),.9);
	}

	@Test
	public void testCalculateY() {
		assertTrue(aCurve.calculateY(5)==97.16248345049762);
		
		assertEquals(0,aCurve.calculateY(0),.9);

		assertEquals(97,aCurve.calculateY(5),.9);

		assertEquals(-50,aCurve.calculateY(10),.9);
	}
}
