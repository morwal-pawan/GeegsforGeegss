package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringProg20 {

	public static String comman(String str1,String str2) {
		
		int length1 = str1.length();
		int length2 = str2.length();
		int countStr1[] = new int[256];
		int countStr2[] = new int[256];
		String result = "";
		String temp ="";
		if(length1 >length2)
			length2=length1;
		
		for(int index =0; index <length2; index++)
		{
			if(index<length1)
				countStr1[str1.charAt(index)]++;
			
			countStr2[str2.charAt(index)]++;
		}
		for(int index=0; index<256; index++)
		{
			if(countStr1[index]!=0&&countStr2[index]!=0)
			{
				int min = Math.min(countStr1[index], countStr2[index]);
				char ch = (char)index;
				for(int i=0; i< min; i++)
					temp+=ch;
				
				result+=temp;
				temp="";
			}
			
			
		}
		return result;	
	}
	
	
public static void main(String[] agrs) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str1 = "";
		String str2 = "";
		
		try {
			str1 = br.readLine();
			str2  = br.readLine();
			
		} catch (NumberFormatException | IOException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" INPUT : " + str1);
		System.out.println(" INPUT : " + str2);
		
		System.out.println(" eventNumberSubString : " + comman(str1,str2));
		br.close();
		
	}
}
