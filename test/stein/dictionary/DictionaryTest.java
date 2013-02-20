package stein.dictionary;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import stein.dictionary.Dictionary;

public class DictionaryTest {
	
	@Test
	public void testContains()throws IOException{
		Dictionary dictionary=new Dictionary(new File(
				"E:\\stein-mco152\\src\\stein\\dictionary\\wordlist.txt"));
		
		assertTrue(dictionary.contains("word"));
		assertFalse(dictionary.contains("baddksfg"));
		assertTrue(dictionary.contains("zymurgy"));
	}
}
