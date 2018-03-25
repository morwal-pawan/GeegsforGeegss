package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

public class StringProg12 {

	static final int ASCII_SIZE=256;
	public static char  maxRepeating(String str) {
		 int max=0;
		 int countChar=1;
		 int maxCharIndex=0;
		 int length = str.length();
		 int countSize[] = new int[ASCII_SIZE];
		 for(int index=1;index <length; index++)
		 {
//			 System.out.println("char : "+str.charAt(index));
			
			 if(str.charAt(index-1)==str.charAt(index)&&index < length-1)
			 {
				 countChar++; 
//				 System.out.println("MAX : "+max + " count : "+countChar);
			 } 
			 
			 else {
				 if(max <countChar)
				 {
//					 System.out.println("MAX : "+max + " count : "+countChar);
					 max=countChar;
					 maxCharIndex=index-1;
					 countChar=0;
					 countSize[str.charAt(index-1)]=max;
					 
				 }
					
			 }
		 }
		for(int index=0; index <length;index++)
		{
			if(countSize[str.charAt(index)]!=0)
			System.out.println(str.charAt(index) + " : " + countSize[str.charAt(index)]);
			countSize[str.charAt(index)]=0;
		}
			
		return str.charAt(maxCharIndex);
	}
	public static void main(String[] agrs) throws IOException {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str="";
		try {
			str = br.readLine();
		} catch (InputMismatchException e) {
			System.out.println("Error : " + e);
		}
		System.out.println("INPUT : " + str);
		System.out.println("THe MAx consecutive Repeating Characte is : " + maxRepeating(str));
		br.close();
	}
	
}
