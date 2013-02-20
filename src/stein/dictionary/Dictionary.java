package stein.dictionary;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
	private HashMap<String, String> wordMap;

	public Dictionary(File file) throws IOException {
		wordMap = new HashMap<String, String>();
		importList(file);
	}

	private void importList(File file) throws IOException {

		Scanner readFile = new Scanner(file);
		while (readFile.hasNext()) {
			String next = readFile.next();
			wordMap.put(next, next);
		}

		readFile.close();

	}

	public boolean contains(String word) {
		return wordMap.containsKey(word);
	}

}
