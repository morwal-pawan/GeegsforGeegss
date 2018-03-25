package bitManuplation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//https://www.geeksforgeeks.org/find-the-element-that-appears-once

public class FindElements {
	
	public static int getSingle(int[] B)
	{
		    int ones = 0;
		    int twos = 0;
		    int not_threes;
		    int x;

		    for (int i = 0; i < 10; i++) {
		        x = B[i];
		        twos =twos | ones & x;
		        ones = ones^ x;
		        not_threes = ~(ones & twos);
		        ones &= not_threes;
		        twos &= not_threes;
		    }
		return ones;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner in = new Scanner(new File("src/files/FindElements.txt"));
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        System.out.println("Answer : " + getSingle(arr));


        in.close();
    }
	
}
