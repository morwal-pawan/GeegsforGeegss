package DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindMinInsertion {

	private static int LcsBottom(String str1,String str2)
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
	
	public static int getMinInsertion(String str) {
		
		int length = str.length();
//		StringBuffer str_buff = new StringBuffer(str);
//		String rev_str = str_buff.reverse().toString();
//		
//		return (length - LcsBottom(str, rev_str));
		return (length - LcsBottom(str, reverString(str)));
		
		
	}
	private static String reverString(String str) {
		String rev = "";
		for (int index = str.length()-1; index >= 0; index--) {
			rev+=str.charAt(index);
		}
		return rev;
	}
	public static void main(String[] agrs) throws IOException
	{
		//Scanner in = new Scanner(System.in);
//		String line = "The white tiger was Bigger then the Stronger";
//		String words[] = line.split(" ");
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
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
		
		System.out.println(" Answer " + getMinInsertion(str1));
		
		br.close();
			
	}
}
