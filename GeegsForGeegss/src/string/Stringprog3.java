package string;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Stringprog3 {
	
	private static final int ASC_II=256;
	 int charFreq[] = new int[ASC_II];
	
	public  void charCountFreq(String str) 
	{
		int length = str.length();
		for(int index=0; index<length; index++)
			charFreq[str.charAt(index)]++;
		
	}
	
	public  char  countSecondMax(String str) 
	{
		int length = str.length();
		int firstMax=0;
		int secondMax=0;
		for(int index=0; index<length; index++)
		{
			if(charFreq[str.charAt(firstMax)] < charFreq[str.charAt(index)])
			{
				secondMax = firstMax;
				firstMax = index;
				
			}
				
			else if(charFreq[str.charAt(index)] > charFreq[str.charAt(secondMax)] && 
						charFreq[str.charAt(index)] != charFreq[str.charAt(firstMax)])
			{
				secondMax = index;
				
				
			}
				
		}
		
		return str.charAt(secondMax);
	}
	
	public static  void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt")); 
		String str = br .readLine();
		System.out.println("INPT: "+ str);
		Stringprog3 solu = new Stringprog3();
		solu.charCountFreq(str);
		System.out.println("Second Max occured : "+ solu.countSecondMax(str));
		br.close();
	}
}
 