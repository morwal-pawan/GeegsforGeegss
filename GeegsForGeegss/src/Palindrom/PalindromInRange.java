package Palindrom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PalindromInRange {

//	Count of Palindromic substrings in an Index range
	
	public static boolean palindorm(int number) {
		int rev_number=0;
		for(int index = number; index >0; index /=10)
			rev_number = rev_number*10 + index%10;
		return (rev_number==number);
	}
	
	public static void countpalindorm(int min, int max) {
		int count_Palindrom = 0;
		for(int index = min; index<=max; index++ )
			if(palindorm(index))
			{
				count_Palindrom++;
				System.out.print(" "+index+" ");
			}
				System.out.println();
				System.out.println("Total Number of Palindrom " + count_Palindrom);
	}
	public static void main(String[] agrs) throws IOException
	{
//		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new FileReader("src/files/PalindromInRange.txt"));
		int min = 0 ;
		int max  = 0;
		
		try {
			min = Integer.valueOf(br.readLine());
			max = Integer.valueOf(br.readLine());
			
		} catch (NumberFormatException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
//		str2= str1;
		System.out.println(" min  : " + min);
		System.out.println(" max : " + max);
		countpalindorm(min, max);
		br.close();
			
	}
}
