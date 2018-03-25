package string;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BufferedReaderDemo {

	public static void main(String []agrs) throws IOException{
		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter characters, press 'q' to quit.");
		do {
			c = (char)br.read();
			System.out.println(c);
		}while(c!='q');
		System.exit(0);
	}
}




