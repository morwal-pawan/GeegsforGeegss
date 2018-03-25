package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Stringprog6 {

	public char decripString(String str, int k) {

		String result = "";
		String temp = "";
		int freq = 0;
		int length = str.length();
		for (int index = 0; index < length;) {
			freq = 0;
			temp = "";

			while (index < length && ('a' <= str.charAt(index) && 'z' >= str.charAt(index))) {
				temp += str.charAt(index);
				index++;
			}
			while (index < length && ('0' <= str.charAt(index) && '9' >= str.charAt(index))) {
				freq = freq * 10 + (str.charAt(index) - '0');
				index++;
			}

			for (int i = 0; i < freq; i++) {
				result += temp;
			}

			if (freq == 0)
				result += temp;
		}
		System.out.println("Decripted String is " + result);
		try {
			return result.charAt(k - 1);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("The K value is Greater than Decripted Strin");
			System.out.println("Length of Decripted String : " + result.length() + " \nK Value is : " + k);
			System.exit(0);
		}

		return 0;
	}
	
	public static  void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt")); 
		String str ="";
		int k =0;
		
		try {
			str = br.readLine();
			k=Integer.valueOf(br.readLine());
			
		}catch(NumberFormatException e){
			System.out.println("k Value must INT type " );
			System.out.println("but k value is " +e.getMessage() );
			System.exit(0);
		}
		
		System.out.println("INPT: "+ str + " K : " + k);
		Stringprog6 solu = new Stringprog6();
		System.out.println("The Answer is : " + solu.decripString(str, k) );
		br.close();
	}
}
