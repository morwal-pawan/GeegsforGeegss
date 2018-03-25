package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringProg9 {

	public static int worldCount(String str) {
		 
		 
		 int wc=0;
		 boolean state=false;
		 int length = str.length();
		 String words[] = str.split("\t");
		 for(int i=0 ; i<words.length;i++)
			 System.out.println(words[i]);
		 
		 for(int index=0; index<length; index++)
		 {
//			System.out.println(" Values : "+ str.charAt(index));
			 if(str.charAt(index) =='\n' || str.charAt(index) ==' ' || str.charAt(index) ==',' ||str.charAt(index) =='\t')
			 {
				 state=true;
				// System.out.println(" Values : "+ str.charAt(index));
			 }
			 else if(state)
			 {
				 wc++;
				 state=false;
			 }
		 }
			 
		
		return wc;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str = "";
		
		try {
			str = br.readLine();
			
		} catch (NumberFormatException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		// str = "One two       three\nfour\tfive\n ";
		System.out.println("INPUT: " + str);
		
		System.out.println("The Answer is : " + worldCount(str));
		br.close();
	}
}
