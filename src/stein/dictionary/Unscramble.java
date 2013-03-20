package stein.dictionary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Unscramble {
	private TileFactory tileFactory;
	private char[] tiles;
	private Dictionary dictionary;
	private ArrayList<String> anagramList;

	public Unscramble() throws IOException {
		tileFactory = new TileFactory();
		tiles = new char[7];

		try {
			dictionary = new Dictionary(new File("./wordlist.txt"));
		} catch (IOException io) {
			throw io;
		}

		chooseTiles(7);
		anagramList = new ArrayList<String>();
	}
	
	public Unscramble(char[] tiles){
		this.tiles=tiles;
	}
	
	

	private void chooseTiles(int numTiles) {
		for (int i = 0; i < numTiles; i++) {
			tiles[i] = Character.toLowerCase(tileFactory.getRandomTile());
		}
	}

	public HashMap<String, String> unscrambleTiles() {
		HashMap<String, String> wordMap = new HashMap<String, String>();

		ArrayList<String> words = getAnagrams(tiles);
		// get permutations of all anagrams
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				String letters = words.get(i).substring(0, j + 1);
				if (dictionary.contains(letters)) {
					wordMap.put(letters, letters);
				}
			}
		}
		return wordMap;
	}

	private ArrayList<String> getAnagrams(char[] tiles) {
		String word = "";
		for (int i = 0; i < tiles.length; i++) {
			word += tiles[i];
		}
		return anagram(word, "");
	}

	private ArrayList<String> anagram(String s1, String s2) {
		if (s1.length() == 0) {
			anagramList.add(s2);
		} else
			for (int i = 0; i < s1.length(); i++) {
				anagram(s1.substring(0, i) + s1.substring(i + 1, s1.length()),
						s1.charAt(i) + s2);
			}
		return anagramList;
	}

	public void setTiles(char[] tiles) {
		this.tiles = tiles;
	}

	public char[] getTiles() {
		return tiles;
	}

}
