package Palindrom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Given a string, find the longest substring which is palindrome

public class ContiguseLcs {

	private static void printLcs(String str,int start,int last) {
		System.out.print("Longest palindrome substring is: ");
		System.out.println(str.substring(start, last+1) + "\nLength " +(last-start+1));
	}
	
	
	public static void longestContiguseSubPalindrom(String str) {
		int start = 0;
		int maxLength = 1;
		int length = str.length();
		int low ,high;		
		for (int index = 1; index < length; index++) {
			
			low = index-1;
			high = index;
			while((low >=0 && high<length)&& (str.charAt(low)==str.charAt(high)) )
			{
				if(high - low +1 >maxLength)
					{
						start = low;
						maxLength = high -low + 1;
					}
				low--;
				high++;
			}
			low = index-1;
			high = index+1;
			while((low >=0 && high<length)&& (str.charAt(low)==str.charAt(high)) )
			{
				if(high - low +1 >maxLength)
					{
						start = low;
						maxLength = high -low + 1;
					}
				low--;
				high++;
			}
		}
		printLcs(str, start, start+maxLength-1);
		
	}public static void main(String[] agrs) throws IOException
	{
//		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new FileReader("src/files/ContiguseLcs.txt"));
		String str1 = "" ;
		
		
		try {
			str1 = br.readLine();
		
			
		} catch (NumberFormatException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
//		str2= str1;
		System.out.println(" String1  : " + str1);
		longestContiguseSubPalindrom(str1);
		
		br.close();
			
	}
}
