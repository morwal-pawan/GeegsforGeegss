package DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestCommomSubseq {

	// if can`t possible to get the result
	private static int lcs[][];
	private static String result = "";
	private static int max = 0;
	
	public static int lcs(String str1,int length1,String str2,int length2) {
		
		if(length1 == 0 || length2 == 0) return 0; 
		if(str1.charAt(length1-1)==str2.charAt(length2-1))
			return lcs(str1, length1-1, str2, length2-1) + 1;
		else return Math.max(lcs(str1, length1-1, str2, length2),lcs(str1, length1, str2, length2-1) );
		
	}
	public static int getLcs(String str1,String str2) {
		
		int length1 = str1.length();
		int length2 = str2.length();
		return lcs(str1, length1, str2, length2);
	}
	
	public static int LcsTop(String str1,int length1,String str2,int length2)
	{
		if(length1 == 0 || length2 ==0) return 0;
		if(lcs[length1][length2] !=0) return lcs[length1][length2];
		if(str1.charAt(length1-1) == str2.charAt(length2-1))	
			return lcs[length1][length2] = LcsTop(str1, length1-1, str2, length2-1) + 1;
		else  return lcs[length1][length2] = Math.max(LcsTop(str1, length1-1, str2, length2), LcsTop(str1, length1, str2, length2-1));	
	}
	
	public static int getLcsTop(String str1,String str2) {
		
		int length1 = str1.length();
		int length2 = str2.length();
		lcs = new int[length1+1][length2+1];
		return LcsTop(str1, length1, str2, length2);
	}
	
	
	public static int LcsBottom(String str1,String str2)
	{
		int length1 = str1.length();
		int length2 = str2.length();
		int [][]lcs = new int[length1+1][length2+1];
		for(int index = 0; index <=length1; index++ ) {
			for (int inner = 0; inner <= length2; inner++) {
				if(inner == 0 || index == 0)
					lcs[index][inner] = 0;
				else if(str1.charAt(index-1) == str2.charAt(inner-1))
					lcs[index][inner] = lcs[index-1][inner-1] + 1;
				else 
					lcs[index][inner] = Math.max(lcs[index-1][inner], lcs[index][inner-1]);
			}
		}
		
		
		return lcs[length1][length2];
	}
	

	
	
	
	public static void main(String[] agrs) throws IOException
	{
		//Scanner in = new Scanner(System.in);
//		String line = "The white tiger was Bigger then the Stronger";
//		String words[] = line.split(" ");
		BufferedReader br = new BufferedReader(new FileReader("src/files/LongestCommomSubseq.txt"));
		String str1 = "" ;
		String str2 = "";
		
		try {
			str1 = br.readLine();
			str2= br.readLine();
			
		} catch (Exception e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
//		str2= str1;
		System.out.println(" String1  : " + str1);
		System.out.println(" String2 : " + str2);
		System.out.println("Result By LcsBottom  " +LcsBottom(str1, str2));
		System.out.println("Result By getLcsTop " +getLcsTop(str1, str2));
		System.out.println("Result By getLcs " +getLcs(str1, str2));
		
		br.close();
			
	}
}
