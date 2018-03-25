package DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IsPalindrom {

	static final int ASCII_SIZE = 256; 

public static boolean IsPalinDrom(String str) {
		
		int length = str.length();
		int left_Index = 0;
		int right_index = length - 1;
		while(left_Index <= right_index)
		{
			if(str.charAt(left_Index)!=str.charAt(right_index))
				return false;
			left_Index++;
			right_index--;
		}
		return true;
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
		
		System.out.println("Result By IsPalinDrom :" + IsPalinDrom(str));
		
		
		br.close();
			
}
	
}
