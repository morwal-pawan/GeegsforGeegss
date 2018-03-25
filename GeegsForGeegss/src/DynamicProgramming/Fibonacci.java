package DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fibonacci {

	public Fibonacci() {};
	
	private static long fiboo[] = new long[10001];
	
	public static long getFibo(int number) {
		if(number <=1)
			return number;
		return getFibo(number-1) + getFibo(number-2);
	}
	
	public static long getFibonacciRecur(int number) {
		if(number == 0) return 0;
		if(number == 1) return 1;
		if( fiboo[number] != 0) return fiboo[number];
		else return fiboo[number] = getFibonacci(number-1) + getFibonacci(number-2);
	}
	
	public static long getFibonacci(int number) {
		fiboo[0] = 0;
		fiboo[1] = 1;
		for(int index = 2; index <=number; index++)
			fiboo[index] = fiboo[index - 1] + fiboo[index - 2];
		return fiboo[number];
		
	}
	public static void main(String[] agrs) throws IOException
	{
		//Scanner in = new Scanner(System.in);
	//	String line = "The white tiger was Bigger then the Stronger";
	//	String words[] = line.split(" ");
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		int number = 0;
		
		
		try {
			number = Integer.valueOf(br.readLine());
		
			
		} catch (NumberFormatException e) {
			System.out.println("Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Number : " + number);
		
		
		System.out.println("Result By getFibonacci :" + getFibonacci(number));
		System.out.println("Result By getFibonacciRecur :" + getFibonacciRecur(number));
		System.out.println("Result By  getFibo:" + getFibo(number));
		
		
		br.close();
			
}
}
