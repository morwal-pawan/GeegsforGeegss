package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringProg24 {

	static long fact[] = new long[100];
	
	static long factorial(int number)
	{
		fact[0]=fact[1]=1;
		
		if(number<0)
			return 0;
		else if(fact[ number]!=0)
			return fact[number];
		else {
			for (int index = 2; index <= number; index++) {
				fact[index]= index*fact[index-1];
			}
		}
		
		return fact[number];
		
	}
	
	static long re_factorial(int number)
	{
		
		if(number==0 || number==1) return 1;
		else if(fact[number]!=0) return fact[number];
		else {
			fact[number]= re_factorial(number-1)*number;
		}
		return fact[number];
		
	}
	static int[] countFreq(String str) {
		int count[] = new int[256];
		int length = str.length();
		for (int index = 0; index < length; index++) {
			count[str.charAt(index)]++;
		}
		return count;
	}
	
	static long countDistinctPermutations(String str) {
		
		long result=0;
		int length = str.length();
		int count[] = countFreq(str);
		long fact=1;
		for (int index = 0; index < count.length; index++) {
			if(count[index]!=0)
				fact*=re_factorial(count[index]);
		}
		result = re_factorial(length)/fact;
		return result;
	}
	public static void main(String[] agrs) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		int  number = 0;
		String str="";

		try {
			str= br.readLine();
		} catch (NumberFormatException | IOException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" INPUT : " + str);
		number = str.length();
		System.out.println(" Factorial of " + number +"  " + factorial(number));
		System.out.println(" Recursivr Factorial of " + number +"  " + re_factorial(number));
		System.out.println(" Number of String  "   + countDistinctPermutations(str));

		br.close();

	}
}
