package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringProg25 {

	static int[] countFreq(String str) {
		int count[] = new int[256];
		int length = str.length();
		for (int index = 0; index < length; index++) {
			count[str.charAt(index)]++;
		}
		return count;
	}

	static String removeDirtyChar(String str, String dirtyStr) {

		int length = str.length();
		int count[] = countFreq(dirtyStr);
		String result = "";
		for (int index = 0; index < length;) {
			if (count[str.charAt(index)] == 0) {
				result += str.charAt(index);
			}
			index++;

		}
		return result;
	}

	public static void main(String[] agrs) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str = "";
		String dirtyStr = "";

		try {
			str = br.readLine();
			dirtyStr = br.readLine();

		} catch (NumberFormatException | IOException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" String        : " + str);
		System.out.println(" Dirty  String : " + dirtyStr);

		System.out.println(" After Remove DirtyCharacter : " + removeDirtyChar(str, dirtyStr));

		br.close();

	}
}
