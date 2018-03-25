package string;

public class PrintNumber {

	public static void printNumber(int number) {
		boolean state = false;
		for (int index = 1; index < number; index++) {
			if(!state)
				System.out.print(" "+index);
			if(!state&&index==10)
			{
				state = true;
				System.out.println();
			}
				
			if(state)
				System.out.print(" "+ (number-index-1));
		}
	}
	public static void main(String[] args) {
		printNumber(20);
	}
	
}
