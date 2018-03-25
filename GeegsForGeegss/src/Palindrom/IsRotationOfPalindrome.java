package Palindrom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IsRotationOfPalindrome {
	
	public static boolean longestPalindrom(String str)
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
					
					if(max == length/2)
					{
						System.out.println(" palindrom :"+ str.substring(left_po, right_po+1) + " length :" +palindrom[first][last] );
						return true;
					}
						
				}
			}
		}
		return false;
	}
	public static boolean isRotationOfPalindrome(String str) {
		
		String str1 = str+str;
		if(longestPalindrom(str1))
			return true;
		return false;
	}
	public static void main(String[] agrs) throws IOException
	{
		//Scanner in = new Scanner(System.in);
	//	String line = "The white tiger was Bigger then the Stronger";
	//	String words[] = line.split(" ");
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str = "";
		
		
		try {
			str = br.readLine();
		
			
		} catch (NumberFormatException e) {
			System.out.println("Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println("String : " + str);
		
		System.out.println("Result By IsPalinDrom :" + isRotationOfPalindrome(str));
		
		
		br.close();
			
}

}
