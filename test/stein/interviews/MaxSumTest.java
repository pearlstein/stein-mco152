package stein.interviews;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaxSumTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMaxSum() {
		int n = 4;
		int[][] doubleArray = new int[n][n];
		doubleArray[0][0] = 0;
		doubleArray[0][1] = -2;
		doubleArray[0][2] = -7;
		doubleArray[0][3] = 0;
		doubleArray[1][0] = 9;
		doubleArray[1][1] = 2;
		doubleArray[1][2] = -6;
		doubleArray[1][3] = 2;
		doubleArray[2][0] = -4;
		doubleArray[2][1] = 1;
		doubleArray[2][2] = -4;
		doubleArray[2][3] = 1;
		doubleArray[3][0] = -1;
		doubleArray[3][1] = 8;
		doubleArray[3][2] = 0;
		doubleArray[3][3] = -2;

		MaxSum maxSum=new MaxSum(doubleArray);
		
		assertEquals(15,maxSum.getMaxSum());

		doubleArray[2][0] = -9;
		doubleArray[3][1] = 9;
		assertEquals(12,maxSum.getMaxSum());
		
		doubleArray[2][2] = 10;
		doubleArray[2][3] = 10;
		doubleArray[3][2] = 10;
		doubleArray[3][3] = 10;
		
		doubleArray[3][1] = -9;
		
		assertEquals(40,maxSum.getMaxSum());
	}

}
