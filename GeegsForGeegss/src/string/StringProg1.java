package string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
public class StringProg1 {

	static final int ASCII_SIZE=256;
	int charFreq[]=new int[ASCII_SIZE];
	
	public  void charCountFreq(String str)
	{	

		int length = str.length();
		
		for(int i=0; i<length; i++)
			charFreq[str.charAt(i)]++;
		
		
	}
	public char findMax(String str) 
	{
		int length = str.length();
		int max=0;
		for(int i=0; i<length; i++)
		{
			if( charFreq[str.charAt(max)]< charFreq[str.charAt(i)])
				max=i;	
		}
		
		return str.charAt(max);
	}
	
	public static void main(String[] agrs) throws IOException
	{
//		for taking the input for the system 
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		for reading from the files
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str = br.readLine();
		StringProg1 solu = new StringProg1();
		solu.charCountFreq(str);
		System.out.println("Max number of time occured charater is : " +solu.findMax(str));
		br.close();
	}
	
}
