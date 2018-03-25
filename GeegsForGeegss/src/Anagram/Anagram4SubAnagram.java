package Anagram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Anagram Substring Search
public class Anagram4SubAnagram {

	static final int MAX_SIZE =256; 
	
	public static boolean checkAnagram(int[] pattCount,int[] textCount) {
		for(int index = 0; index <MAX_SIZE; index++)
		{
			if(pattCount[index]!=textCount[index])
				return false;	
		}
		return true;		
	}
	
	public static void search(String patt,String text) {
		int pattLength = patt.length();
		int textLength = text.length();
		
		int[] pattCount = new int[MAX_SIZE];
		int[] textCount = new int[MAX_SIZE];
		
		for (int index = 0; index < pattLength; index++) {
			pattCount[patt.charAt(index)]++;
			textCount[text.charAt(index)]++;
		}
		for (int index = pattLength; index < textLength; index++) {
			if(checkAnagram(pattCount, textCount))
				System.out.println("Found At : " + (index-pattLength));
			
			textCount[text.charAt(index)]++;
			textCount[text.charAt(index-pattLength)]--;
		}
		if(checkAnagram(pattCount, textCount))
			System.out.println("Found At : " + (textLength-pattLength));
	}
	
	public static void main(String[] agrs) throws IOException
	{
		//Scanner in = new Scanner(System.in);
//		String line = "The white tiger was Bigger then the Stronger";
//		String words[] = line.split(" ");
		BufferedReader br = new BufferedReader(new FileReader("src/files/Anagram4SubAnagram.txt"));
		String text = "";
		String patt ="";
		
		try {
			text = br.readLine();
			patt= br.readLine();
			
		} catch (NumberFormatException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" TEXT : " + text);
		System.out.println(" PATT : " + patt);
		search(patt, text);
		
		br.close();
			
	}
}
