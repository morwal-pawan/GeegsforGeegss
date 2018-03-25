package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringProg7 {

	public static int CountSamePostionChar(String str) {
		int count = 0;
		int length = str.length();
		for (int index = 0; index < length; index++) {
			if ((str.charAt(index) - 'a' == index) || (str.charAt(index) - 'A' == index))
				count++;
		}
		return count;

	}
	public static  void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt")); 
		String str ="";
		try {
			str = br.readLine();
			
		}catch(NumberFormatException e){
			System.out.println("k Value must INT type " );
			System.out.println("but k value is " +e.getMessage() );
			System.exit(0);
		}
		
		System.out.println("INPUT: "+ str );
//		StringProg7 solu = new StringProg7();
		System.out.println("The Answer is : " + CountSamePostionChar(str) );
		br.close();
	}
}
