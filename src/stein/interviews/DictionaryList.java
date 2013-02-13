package stein.interviews;

import java.util.HashMap;
import java.util.Random;

public class DictionaryList {
	private String[] words;

	public DictionaryList(int num) {
		words = new String[num];
		Random random=new Random();
		for(int i=0;i<num;i++){
			Character character=new Character((char) (random.nextInt(65)));
			words[i]=character+"";
		}
		
	}

	public void getList() {
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < this.words.length; i++) {
			if (!map.containsKey(words[i])) {
				map.put(words[i], words[i]);
				System.out.println(words[i]);
			}
		}
	}

	public static void main(String[] args) {
		DictionaryList list = new DictionaryList(5);
		list.getList();
	}
}
