package se.strolle.euler.problems.p024;

import java.util.Arrays;
import java.util.List;

public class LexioPermutation {
	static List<String> list = Arrays.asList("0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9");

	public static final int TARGET = 1000000;

	public static void main(String args[]) {
		int cnt = 0;
		String res = "";
		int originalSize = list.size();
		for (int posInString = 0; posInString < originalSize; posInString++) {
			int letterValue = calculateFactorial(originalSize - posInString - 1);
			for (int posInArray = 1; posInArray <= list.size(); posInArray++) {
				int newCnt = cnt + posInArray * letterValue;
				if (newCnt >= TARGET) {
					res += list.remove(posInArray - 1);
					cnt += (posInArray - 1) * letterValue;
					break;
				}
			}
		}

		System.err.println("res: " + res);
		System.exit(0);
	}

	private static int calculateFactorial(int num) {
		int res = 1;
		for (int i = 1; i <= num; i++)
			res *= i;
		return res;
	}
}
