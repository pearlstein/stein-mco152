package stein.dictionary;

import java.util.Arrays;

public class AnagramsArray {
	private char[] listOne;
	private char[] listTwo;
	
	public boolean areAnagrams(String word1, String word2) {
		listOne=new char[word1.length()];
		listTwo=new char[word2.length()];
		
		listOne=word1.toCharArray();
		listTwo=word2.toCharArray();
		
		Arrays.sort(listOne);
		Arrays.sort(listTwo);
		
		return Arrays.equals(listOne,listTwo);
	}
}
