package Anagram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//Given a sequence of words, print all anagrams together


public class Anagram1Map {

	Node[] word_list =  new Node[200];
	
	public Anagram1Map() {
//		for(int i=0; i<10;i++)
//			words[i]=null;
		Arrays.fill(word_list, null);
	}
	
	public static class Node {
		String word;
		Node next;
		int size;
		
		
		Node(String word){
			this.word =  word;
			this.next = null;
			this.size=0;
		}
		
	}
	
	public void addWord(String words[]) {
		
		int key =0;
		Node parent=null;
		for(String word : words)
		{
			key = key(word);
			 
			// adding the node at begining
			if(word_list[key]==null)
			{
				Node temp = new Node(word);
				temp.size+=1;
				word_list[key] = temp;
				
			}
				
			else {
				parent = word_list[key];
//				
				Node temp = new Node(word);
				temp.next = parent;
				temp.size = parent.size + 1;
				word_list[key]=temp;
			}
			
		}
	
		
//		int index = word.length();
//		int wordvalue = wordValue(word); 
//		
//		if(words[index]==null)
//		{
//			words[index]= new Node(word);
//		}
//		else {
//			Node parent = words[index];
//			while(parent.next!=null)
//			{ 
//				int wordvalue1 =wordValue(parent.word); 
//				if(wordvalue1==wordvalue)
//					break;
//				else parent = parent.next;
//			}
//			if(parent.next==null)
//			 parent.next = new Node(word);
//		}
	}

	public void printWords()
	{
		for(int key=0;key<200;key++)
		{
			if(word_list[key]!=null)
			{
				Node walk = word_list[key];
				while(walk!=null)
				{
					System.out.print(walk.word + " ");
					walk= walk.next;
				}
//				System.out.println(key + " " + " size " + word_list[key].size);
				System.out.println( word_list[key].size);
			}
		}
	}
	
	private int key(String word) {

		int sum=0;
		boolean[] visited  = new boolean[256];
		Arrays.fill(visited, false);
//		System.out.println(word + " " +sum);
		for(int i=0; i<word.length();i++)
		{
			if(!visited[word.charAt(i)])
			{
				if((word.charAt(i)>= 'A') &&  (  'Z' >= word.charAt(i)))
				{
					sum+=  word.charAt(i) -(int)'A';
				   //System.out.println(word.charAt(i) -(int)'A' + " "+ word.charAt(i));
				}
					
				
				else  if((word.charAt(i)>= 'a') &&  (  'z' >= word.charAt(i)))
					{
						sum+=  word.charAt(i) -(int)'a';
					  //System.out.println(word.charAt(i) -(int)'a' + " "+ word.charAt(i));
					}
			  
				    visited[word.charAt(i)]=true;
				 
			}
		}
		return sum%200;
	}
	
	public static void main(String[] agrs) throws IOException
	{
//      Scanner in = new Scanner(System.in);
//		String line = "The white tiger was Bigger then the Stronger";
//		String words[] = line.split(" ");
		BufferedReader br = new BufferedReader(new FileReader("src/files/Anagram1Map.txt"));
		String str = "";
		
		try {
			str = br.readLine();
			
		} catch (NumberFormatException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" INPUT : " + str);
		
		
		String words[] = str.split(" ");
		
		Anagram1Map solu = new Anagram1Map();
		solu.addWord(words);
		solu.printWords();
			
	}
}
