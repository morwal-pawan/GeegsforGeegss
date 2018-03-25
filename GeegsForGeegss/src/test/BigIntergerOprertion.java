package test;

import java.math.BigInteger;

public class BigIntergerOprertion {

	
	public static void main(String[] args) {
		BigInteger bigInt = new BigInteger("3");
		System.out.println(bigInt.add(new BigInteger("10")));
		System.out.println(bigInt.subtract(new BigInteger("10")));
//		System.out.println(bigInt.multiply(new BigInteger("10")));
//		System.out.println(bigInt.divide(new BigInteger("15")));
//		System.out.println(bigInt.doubleValue());
//		System.out.println(bigInt.longValue());
//		System.out.println(bigInt.intValue());
//		System.out.println(bigInt.floatValue());
//		System.out.println(bigInt.compareTo(new BigInteger("60")));
//		System.out.println(bigInt.negate());
//		System.out.println(bigInt.isProbablePrime(2));
//		System.out.println(bigInt.min(BigInteger.valueOf(70)));
//		System.out.println(bigInt.max(BigInteger.valueOf(15)));
//		System.out.println(bigInt.not());
//		System.out.println(bigInt.mod(BigInteger.valueOf(60)));
//		System.out.println(bigInt.remainder(BigInteger.valueOf(7)));
//		System.out.println(bigInt.modInverse(BigInteger.valueOf(10)));
//		System.out.println(bigInt.and(BigInteger.valueOf(0)));
//		System.out.println(bigInt.or(BigInteger.valueOf(65)));
//		System.out.println(bigInt.xor(BigInteger.valueOf(15)));
//		System.out.println(bigInt.pow(2));
//		System.out.println(bigInt.modPow(BigInteger.valueOf(2), BigInteger.valueOf(10)));
//		System.out.println(bigInt.shiftLeft(1));
//		System.out.println(bigInt.shiftRight(1));
//		byte[] big = bigInt.toByteArray();
//		for (int i = 0; i < big.length; i++) {
//			System.out.print(big[i]+" ");
//		}
		System.out.println(bigInt.toString());
		System.out.println(bigInt.toString(2));

	}
	

}
