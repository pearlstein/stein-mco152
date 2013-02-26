package stein.dictionary;

import java.util.HashMap;

public class AnagramsHashMap {
	private HashMap<Character,Integer> map;
	
	public boolean areAnagrams(String word1,String word2){
		map=new HashMap<Character,Integer>();
		
		for(int i=0;i<word1.length();i++){
			int j=0;
			if(map.containsKey(word1.charAt(i))){
				j=map.get(word1.charAt(i));
			}
			map.put(word1.charAt(i),++j);
		}
		
		for(int i=0;i<word2.length();i++){
			Integer j=map.get(word2.charAt(i));
			
			map.remove(word2.charAt(i));
			
			if(j==null){
				return false;
			}
			if(j>1){
				map.put(word2.charAt(i),--j);
			}
		}
		
		return map.isEmpty();
		
	}
}
