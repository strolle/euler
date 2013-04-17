package se.strolle.euler.problems.p020;

import java.math.BigInteger;

public class Factorial  {
	static int FACTORIAL = 100;

	public static void main(String[] args) {
		BigInteger val = BigInteger.valueOf(FACTORIAL);
		for(int i = FACTORIAL; i > 0; i--){
			val = val.multiply(BigInteger.valueOf(i));
		}
		
		long result=0;
		char[] resultArr = val.toString().toCharArray();
		int charVal = '0';
		for (char character : resultArr) {
			result += (character - charVal);
		}
		System.out.println("Result: " + result);
		System.exit(0);
	}
}
