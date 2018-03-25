package bitManuplation;

public class SetBits {

	public static int setBit(int number , int position) {
		int mask = 1<<position;
		return number | mask;
	} 
	
	public static int clearBit(int number ,int position) {
		int mask = 1<<position;
		return number & ~mask;
	}
	
	public static int flipBit(int number, int position) {
		int mask = 1<<position;
		return number^mask;
	}
	
	public static boolean isBitSet(int number, int position) {
		int shifted = number>>position;
		return (shifted & 1)!= 1;
	}
	
	public static int modifyBit(int number,int position,int state) {
		int mask = 1<<position;
		return (number & ~mask) | (-state & mask );
	}
	
	public static boolean IsEven(int number) {
		return (number & 1) == 0;
	}
	
	public static boolean isOdd(int number) {
		return (number & 1) == 1;
	}
	
	public static int dividedBy2(int number) {
		return number>>1;
	}
	
	public static int multlplyBy2(int number) {
		return number<<1;
	}
	
	public static int dividedByPowerOf2(int number, int k) {
		return number>>k;
	}
	
	public static int multlplyByPowerOf2(int number, int k) {
		return number<<k;
	}
	
	public static boolean isPowerOf2(int number) {
		return (number & number-1) == 0;
	}
	
}
