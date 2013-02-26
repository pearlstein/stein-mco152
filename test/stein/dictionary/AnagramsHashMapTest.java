package stein.dictionary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnagramsHashMapTest {

	@Test
	public void testAreAnagrams(){
		AnagramsHashMap a=new AnagramsHashMap();
		
		assertTrue(a.areAnagrams("spear", "pears"));
		assertFalse(a.areAnagrams("apple","aplee"));
		assertFalse(a.areAnagrams("pares","paaes"));
		assertTrue(a.areAnagrams("apple","palep"));
	}
}
