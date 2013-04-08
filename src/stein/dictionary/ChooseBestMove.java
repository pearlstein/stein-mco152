package stein.dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class ChooseBestMove {

	
	private ArrayList<Character> tilesList;
	private ArrayList<String> possibleWords;
	private Iterator<String> i;
	private FormWordsWithTiles u;
	private ArrayList<String> wordsSoFar;
	
	public ChooseBestMove(ArrayList<Character> tilesList) throws IOException{
		this.tilesList=tilesList;
		wordsSoFar=new ArrayList<String>();
		u=new FormWordsWithTiles((tilesList));
		possibleWords=u.getWordsThatCanBeFormedWithTiles();
		

	}
	
	public ArrayList<String> chooseOne() throws IOException{
		i=possibleWords.iterator();
		while (i.hasNext()){
			wordsSoFar.clear();
			String choice=i.next();
			if (tilesList.size()-choice.length()>0){
				wordsSoFar.add(choice);
				boolean b=next(0);
				if (b){
					System.out.println("finished properly");
					return wordsSoFar;
				}
			}
			else{
				System.out.println("finished properly");
				return wordsSoFar;
			}
		}
		System.out.println("Couldn't finish all tiles");
		return wordsSoFar;
		
	}
	
	public ArrayList<Character> convertToList(char[] array){
		ArrayList<Character> list=new ArrayList<Character>();
		for (char c: array){
			list.add(c);
		}
		return list;
	}
	
	public char[] convertToArray(ArrayList<Character>  list){
		char[] array=new char[list.size()];
		for (int i=0; i<list.size(); i++){
			array[i]=list.get(i);
		}
		return array;
	}
	
	public boolean containsChar(String s, char c){
		for (char each: s.toCharArray()){
			if (each==c){
				return true;
			}
		}
	return false;
	}
	
	
	public int numTimesLetterAppears(ArrayList<Character> list, char c) {
		int i = 0;
		for (char each : list) {
			if (each == c) {
				i++;
			}
		}
		return i;
	}
	
	public ArrayList<Character> copyExclusiveLetters(ArrayList<Character> list, ArrayList<Character> exclusion){
		ArrayList<Character> newList=new ArrayList<Character>();
		int[] numTimesLetterAdded=new int[list.size()];
		for(int i=0; i<list.size(); i++){
			
			char c=list.get(i);
			
			
			if(!exclusion.contains(c)){
				if (!(numTimesLetterAdded[i]>=numTimesLetterAppears(list, c))){
					newList.add(c);
					numTimesLetterAdded[i]++;
					
				}
			}
		}
		return newList;
	}
	public boolean next(int charToChoose) throws IOException{
		System.out.println(wordsSoFar);
		ArrayList<Character> charsSoFar=new ArrayList<Character>();
		for (String s: wordsSoFar){
			for (char c: s.toCharArray()){
				charsSoFar.add(c);
			}
		}
		ArrayList<Character> tilesCopy=copyExclusiveLetters(tilesList,charsSoFar);
			//System.out.println("tiles copy "+tilesCopy);
			if (tilesCopy.size()==0){
				return true;
				//wordsSoFar.clear();
			}
			char c=charsSoFar.get(charToChoose);
			//System.out.println("c is "+c);
				char[] newArray=new char[tilesCopy.size()+1];
				int i=0;
				for (i=0; i<tilesCopy.size(); i++){
					newArray[i]=tilesCopy.get(i);
				}
				newArray[i]=c;
				
				FormWordsWithTiles f2=new FormWordsWithTiles(convertToList(newArray));
				ArrayList<String> words=f2.getWordsThatCanBeFormedWithTiles();
				//System.out.println("num words that can be made  "+words.size());
				for  (int j=0; j<words.size(); j++){
					if (!containsChar(words.get(j), c)){
						words.remove(j);
						j--;
					}
				}
			
				if (words.isEmpty()){
					System.out.println("no more words to make");
					return false;
				}
				else{
					String str=words.get(0);
					wordsSoFar.add(str);		
					next(++charToChoose);
				}
				
					
				
				
			return false;	
	}
	
	public static void main(String[]args){
		ArrayList<Character> tiles=new ArrayList<Character>();
		tiles.add('a');
		tiles.add('p');
		tiles.add('p');
		tiles.add('l');
		tiles.add('e');
		tiles.add('s');
		
	
		try{
		ChooseBestMove c=new ChooseBestMove(tiles);
		System.out.println(c.chooseOne());
		}catch(Exception e){
			System.out.println("exception "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
