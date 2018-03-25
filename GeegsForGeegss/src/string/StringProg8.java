package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringProg8 {
	static final int ASCII_SIZE = 256;
	static int strCount1[] = new int[ASCII_SIZE];
	static int strCount2[] = new int[ASCII_SIZE];

	public static String KthAnagram(String str1, String str2, int k) {

		int length1 = str1.length();
		int length2 = str2.length();
		int count = 0;
		if (length1 != length2)
			return "NO";

		for (int index = 0; index < length1; index++)
			strCount1[str1.charAt(index)]++;

		for (int index = 0; index < length2; index++)
			strCount2[str2.charAt(index)]++;

		for (int index = 0; index < ASCII_SIZE && count <= k; index++)
			if (strCount1[index] > strCount2[index]) {

				count = count + Math.abs(strCount1[index] - strCount2[index]);

			}
		if (count <= k)
			return "YES";
		else
			return "NO";

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str1 = "";
		String str2 = "";
		int k = 0;
		try {
			str1 = br.readLine();
			str2 = br.readLine();
			k = Integer.valueOf(br.readLine());

		} catch (NumberFormatException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}

		System.out.println("INPUT: " + str1 + "\nINPUT: " + str2);
		System.out.println("The Answer is : " + KthAnagram(str1, str2, k));
		br.close();
	}
}
