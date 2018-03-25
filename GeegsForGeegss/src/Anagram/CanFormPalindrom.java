package Anagram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//can String form Palindrome
public class CanFormPalindrom {

		static final int ASCII_SIZE = 256; 
		private static int[] countFreq(String str)
		{
			int count[] = new int[ASCII_SIZE];
			int length = str.length();
			
			for(int index = 0; index <length;  index++)
				count[str.charAt(index)]++;
			
			return count;
		}
		
		public static boolean canFormPalindrom(String str) {
			
			int count[] = countFreq(str);
			int result = 0;
			for(int index =0;  index<ASCII_SIZE; index++ )
			{
				result+=count[index]%2;
			}
			if(result == 0 || result == 1)
				return true;
			else
			return false;
			
		}
		
		public static void main(String[] agrs) throws IOException
		{
			//Scanner in = new Scanner(System.in);
//			String line = "The white tiger was Bigger then the Stronger";
//			String words[] = line.split(" ");
			BufferedReader br = new BufferedReader(new FileReader("src/files/canFormAnagram.txt"));
			String str = "";
			
			
			try {
				str = br.readLine();
			
				
			} catch (NumberFormatException e) {
				System.out.println(" Values Must be Strings ");
				System.out.println("but   " + e.getMessage());
				System.exit(0);
			}
			System.out.println(" String : " + str);
			
			System.out.println("Result :" + canFormPalindrom(str));
			
			br.close();
				
		}
}
