package stein.dictionary;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

public class UnscrambleTest {

	@Test
	public void test() {
		try{
		Unscramble unscramble=new Unscramble();
		
		unscramble.setTiles(new char[]{'a','t','e','l','g','b','o'});
		
		HashMap<String,String> map=unscramble.unscrambleTiles();
		assertTrue(map.containsKey("abet"));
		assertTrue(map.containsKey("able"));
		assertTrue(map.containsKey("abo"));
		assertTrue(map.containsKey("ae"));
		assertTrue(map.containsKey("age"));
		assertTrue(map.containsKey("aglet"));
		assertTrue(map.containsKey("ago"));
		assertTrue(map.containsKey("alb"));          
		assertTrue(map.containsKey("ale"));
		assertTrue(map.containsKey("aloe"));
		assertTrue(map.containsKey("alt"));
		assertTrue(map.containsKey("alto"));
		assertTrue(map.containsKey("at"));
		assertTrue(map.containsKey("ate"));
		assertTrue(map.containsKey("ba"));
		assertTrue(map.containsKey("bag"));
		assertTrue(map.containsKey("bagel"));
		assertTrue(map.containsKey("bal"));
		assertTrue(map.containsKey("bale"));
		assertTrue(map.containsKey("bat"));
		assertTrue(map.containsKey("bate"));                                                      
		assertTrue(map.containsKey("be"));
		assertTrue(map.containsKey("beat"));
		assertTrue(map.containsKey("beg"));
		assertTrue(map.containsKey("begat"));
		assertTrue(map.containsKey("begot"));
		assertTrue(map.containsKey("bel"));
		assertTrue(map.containsKey("belga"));
		assertTrue(map.containsKey("belt"));
		assertTrue(map.containsKey("bet"));
		assertTrue(map.containsKey("beta"));
		assertTrue(map.containsKey("blae"));
		assertTrue(map.containsKey("blat"));
		assertTrue(map.containsKey("blate"));
		assertTrue(map.containsKey("bleat"));
		assertTrue(map.containsKey("blet"));
		assertTrue(map.containsKey("bloat"));
		assertTrue(map.containsKey("blot"));
		assertTrue(map.containsKey("bo"));
		assertTrue(map.containsKey("boa"));		
		assertTrue(map.containsKey("boat"));
		assertTrue(map.containsKey("boatel"));
		assertTrue(map.containsKey("bole"));
		assertTrue(map.containsKey("gable"));
		assertTrue(map.containsKey("gale"));
		assertTrue(map.containsKey("gat"));
		assertTrue(map.containsKey("globate"));
		assertTrue(map.containsKey("goat"));
		assertTrue(map.containsKey("goblet"));
		assertTrue(map.containsKey("lag"));
		assertTrue(map.containsKey("late"));
		assertTrue(map.containsKey("oblate"));
		assertTrue(map.containsKey("oe"));
		assertTrue(map.containsKey("ogle"));
		assertTrue(map.containsKey("ole"));
		assertTrue(map.containsKey("olea"));
		assertTrue(map.containsKey("ta"));
		assertTrue(map.containsKey("tab"));
		assertTrue(map.containsKey("tael"));
		assertTrue(map.containsKey("tag"));
		assertTrue(map.containsKey("tale"));
		assertTrue(map.containsKey("tao"));
		assertTrue(map.containsKey("tea"));
		assertTrue(map.containsKey("teal"));
		assertTrue(map.containsKey("tole"));
		assertTrue(map.containsKey("togae"));
		assertTrue(map.containsKey("tela"));
		
		
		assertFalse(map.containsKey("paper"));
		assertFalse(map.containsKey("obligate"));
		assertFalse(map.containsKey("te la"));
		assertFalse(map.containsKey("teila"));
		
		}catch(IOException io){
			System.out.println("ERROR: "+io.getMessage());
		}
	}

}
