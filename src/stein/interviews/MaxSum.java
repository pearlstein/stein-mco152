package stein.interviews;

import java.util.Scanner;

public class MaxSum {

	int n;
	int[][] doubleArray;

	public MaxSum(int[][] doubleArray) {
		n = doubleArray.length;
		this.doubleArray = doubleArray;
	}

	public int getMaxSum() {
		int max = 0;
		int startRow = -1;
		int startCol = -1;
		int maxWidth = -1;
		int maxDepth = -1;

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				for (int depth = 0; depth < n; depth++) {
					for (int width = 0; width < n; width++) {
						int sum = 0;
						sum += doubleArray[row][col];
						
						int wide = width;
						while (wide >= 0 && (col + wide) < n) {
							if (wide != 0) {
								sum += doubleArray[row][col + wide];
							}
							
							int deep = depth;
							while (deep > 0 && row + deep < n) {
								sum += doubleArray[row + deep][col + wide];
								deep--;
							}
							
							wide--;
						}
						if (sum > max) {
							max = sum;
							startRow = row;
							startCol = col;
							maxWidth = width;
							maxDepth = depth;
						}
					}
				}
			}
		}

		System.out.println("max sum: " + max);
		System.out.println("startRow: " + startRow);
		System.out.println("startCol: " + startCol);
		System.out.println("maxWidth: " + (maxWidth + 1));
		System.out.println("maxDepth: " + (maxDepth + 1));
		
		return max;

	}
}
