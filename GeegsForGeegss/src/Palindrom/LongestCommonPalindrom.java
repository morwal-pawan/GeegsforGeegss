package Palindrom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestCommonPalindrom {
	
//	using dynamic  programming
	
	public static int longestPalindrom(String str)
	{
		int length = str.length();
		int palindrom [][] = new int[length][length];
		int max =1;
		int left_po;
		int right_po;
		for (int index = 0; index < length; index++) {
			palindrom[index][index] = 1;
		}
		for(int index = 1; index < length; index++)
		{
			int first = 0;
			for(int last = index; last <length; last++,first++)
			{
				if(str.charAt(first)==str.charAt(last))
						palindrom[first][last] = palindrom[first + 1][last - 1] + 2; 
				else palindrom[first][last] = Math.max(palindrom[first][last-1], palindrom[first+1][last]);
				if(palindrom[first][last] >max)
				{
					max = palindrom[first][last];
					left_po = first;
					right_po = last;
					System.out.println(" palindrom :"+ str.substring(left_po, right_po+1) + " length :" +palindrom[first][last]);
				}
			}
		}
		return palindrom[0][length-1];
	}
	
//	using recursion
	public static int longestPalindromRec(String str1,String str2,int length1,int length2) {
		if(length1 == 0 || length2 ==0) return 1;
		else if(str1.charAt(length1)==str2.charAt(length2))
			return longestPalindromRec(str1, str2, length1-1, length2-1) + 1;
		else return Math.max(longestPalindromRec(str1, str2, length1-1, length2), longestPalindromRec(str1, str2, length1, length2-1));
	}
	
	
	public static int palindrom(String str1,String str2) {
		int length1 = str1.length()-1;
		int length2 = str2.length()-1;
		return longestPalindromRec(str1, str2, length1, length2);
	}
	public static void main(String[] agrs) throws IOException
	{
//		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str1 = "" ;
		String str2 = "";
		
		try {
			str1 = br.readLine();
			str2= br.readLine();
			
		} catch (NumberFormatException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
//		str2= str1;
		System.out.println(" String1  : " + str1);
		System.out.println(" String2 : " + str2);
		System.out.println(" Answer " +palindrom(str1, str2));
		System.out.println(" Answer " +longestPalindrom(str1));
		
		br.close();
			
	}
}
