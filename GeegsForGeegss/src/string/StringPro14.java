package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StringPro14 {

	static final int MAX_SIZE=26;
	public static String getKey(String word) {
		
		boolean[] visited = new boolean[MAX_SIZE];
		Arrays.fill(visited,false);
		int length = word.length();
		String key = "";
		for (int index = 0; index < length; index++) {
			if('a'<= word.charAt(index) && word.charAt(index) <='z')
				visited[word.charAt(index)-'a']=true;
			
			 else if('A'<= word.charAt(index) && word.charAt(index) <='Z')
			visited[word.charAt(index)-'A']=true;
		}
		
		for (int index = 0; index < visited.length; index++) {
			if(visited[index])
				key+= (char)('a' + index) ;
		}
		
		return key;
	}
	
	public static void wordsWithSameCharSet(String[] words)
	{
		HashMap<String, ArrayList<Integer>> hash = new HashMap<String, ArrayList<Integer>>();
		String key = "";
		for (int index = 0; index < words.length; index++) {
			key = getKey(words[index]);
			
			if(hash.containsKey(key))
			{
				ArrayList<Integer> arrList = hash.get(key);
				arrList.add(index);
				hash.put(key, arrList);
			}
			else 
			{
				ArrayList<Integer> new_arrList = new ArrayList<Integer>();
				new_arrList.add(index);
				hash.put(key, new_arrList);
			}
		}
		
		for(Entry<String, ArrayList<Integer>> it : hash.entrySet())
		{
			ArrayList<Integer> word_list = it.getValue();
			for(Integer index : word_list)
			{
				System.out.print(" "+  words[index] + " ");
			}
			System.out.println();
		}	
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
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
//      for (String word : words) {
//    	  System.out.println(" INPUT : " + word);
//		}
		System.out.println(" The Answer is : ");
		wordsWithSameCharSet(words);
		br.close();
	}
	
}