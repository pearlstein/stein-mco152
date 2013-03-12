package stein.interviews;

public class AlphabetSort {

	private String string;
	private int[] characters;

	public AlphabetSort(String string) {
		this.string = string;
		characters = new int[256];
	}

	public void sort() {
		char[] array = string.toCharArray();
		for (char c : array) {
			characters[c]++;
		}
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] > 0) {
				System.out.println((char) i + ": " + characters[i]);
			}
		}
	}

	public static void main(String[] args) {
		AlphabetSort alphabetSort = new AlphabetSort(
				"ABCDEFGHIJKLMNsgfsOPQRS************897243kljfad89849$%^&^*(&658()_( fl  eopsdkajklmnopqrstuvwxyzz");
		alphabetSort.sort();
	}
}
