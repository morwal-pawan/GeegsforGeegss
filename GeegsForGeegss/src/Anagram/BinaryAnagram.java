package Anagram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Check if binary representations of two numbers are anagram
public class BinaryAnagram {

static final int MAX_SIZE =2; 
	
	public static boolean checkAnagram(int[] numberCount1 ,int[] numberCount2) {
		for(int index = 0; index <MAX_SIZE; index++)
		{
			if(numberCount1[index]!=numberCount2[index])
				return false;	
		}
		return true;		
	}
	
	public static boolean checkNumberAnagram(int number1,int number2) {
		
		int [] numberCount1 = new int[MAX_SIZE];
		int [] numberCount2 = new int[MAX_SIZE];
		
		while(number1>0 ||number2>0)
		{
			numberCount1[number1%2]++;
			numberCount2[number2%2]++;
			number1= number1/2;
			number2 = number2/2;
			
		}
		if(checkAnagram(numberCount1, numberCount2))
			return true;
		return false;
	}
	public static void main(String[] agrs) throws IOException
	{
		//Scanner in = new Scanner(System.in);
//		String line = "The white tiger was Bigger then the Stronger";
//		String words[] = line.split(" ");
		BufferedReader br = new BufferedReader(new FileReader("src/files/BinaryAnagram.txt"));
		int number1 = 0 ;
		int number2 = 0;
		
		try {
			number1 = Integer.valueOf(br.readLine());
			number2= Integer.valueOf(br.readLine());
			
		} catch (NumberFormatException e) {
			System.out.println(" Values Must be Integer ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" numerb1 : " + number1);
		System.out.println(" numerb2 : " + number2);
		System.out.println(" Answer " +checkNumberAnagram(number1,number2));
		
		br.close();
			
	}
}
