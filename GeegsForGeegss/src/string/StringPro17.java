package string;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPro17 {

	public static int eventNumberSubString(String str) {
		
		int even_count =0;
		int length = str.length();
		int temp=0;
		for(int index =0; index <length; index++)
		{
			temp = str.charAt(index)-'0';
			
			if(temp%2==0)
				even_count+=(index + 1);
		}
		
		return even_count;
	}
	
	public static int oddNumberSubString(String str) {
		
		int odd_count =0;
		int length = str.length();
		int temp=0;
		for(int index =0; index <length; index++)
		{
			temp = str.charAt(index)-'0';
			
			if(temp%2==1)
				odd_count+=(index + 1);
		}
		
		return odd_count;
	}
	public static void main(String[] agrs) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str = "";
		
		try {
			str = br.readLine();
			
		} catch (NumberFormatException | IOException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" INPUT : " + str);
		
		System.out.println(" eventNumberSubString : " + eventNumberSubString(str));
		System.out.println(" oddNumberSubString : " + oddNumberSubString(str));
		
		br.close();
		
	}
}
