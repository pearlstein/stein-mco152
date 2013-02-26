package stein.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramsArrayTest {

	@Test
	public void testAreAnagrams(){
		AnagramsArray a=new AnagramsArray();
		
		assertTrue(a.areAnagrams("spear", "pears"));
		assertFalse(a.areAnagrams("apple","aplee"));
		assertFalse(a.areAnagrams("pares","paares"));
		assertTrue(a.areAnagrams("apple","palep"));
	}
}
