package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringProg23 {

	static int isVovel(char ch) {
		if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
			return 1;
		else
			return 0;
	}

	static int countVovels(String str) {
		int length = str.length();
		int count = 0;
		for (int index = 0; index < length; index++) {
			char ch = str.charAt(index);
			count += isVovel(Character.toUpperCase(ch));
		}
		return count;
	}

	static int RecurCountVovels(String str, int n) {
		
		if (n == 1)
			return isVovel(Character.toUpperCase(str.charAt(n - 1)));
		int count = RecurCountVovels(str, n - 1) + isVovel(Character.toUpperCase(str.charAt(n - 1)));
		return count;
	}

	public static void main(String[] agrs) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str1 = "";

		try {
			str1 = br.readLine();

		} catch (NumberFormatException | IOException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" INPUT : " + str1);

		System.out.println(" Number of Vovels : " + countVovels(str1));
		System.out.println(" Number of Vovels : " + RecurCountVovels(str1, str1.length()));
		br.close();

	}
}
