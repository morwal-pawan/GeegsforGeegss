package string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
public class StringProg4 {

	static final int ASCII_SIZE=256;
	int charFreq[]=new int[ASCII_SIZE];
	
	public  void charCountFreq(String str)
	{	

		int length = str.length();
		
		for(int i=0; i<length; i++)
			charFreq[str.charAt(i)]++;
		
		
	}
	public char findKnonRepeat(String str,int k) 
	{
		int length = str.length();
		int count=0;
		int index=0;
		for(; index<length&&count<k; index++)
		{
//			System.out.println("In Loop : " + charFreq[str.charAt(index)] + " " + str.charAt(index) +
//					" count " + count + " k " + k );
			if( charFreq[str.charAt(index)]==1)
				count++;	
		}
		if(count==k)
			return str.charAt(index-1);
		else {
			System.out.println("Dont Exist such type of Charater ");
			System.exit(0);
		}
		return 0;
		
	}
	
	public static void main(String[] agrs) throws IOException
	{
//		for taking the input for the system 
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		for reading from the files
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
//		int k = br.read();
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
		 
		StringProg4 solu = new StringProg4();
		solu.charCountFreq(str);
		System.out.println("Max number of time occured charater is : " +solu.findKnonRepeat(str,k));
		br.close();
	}
	
}
