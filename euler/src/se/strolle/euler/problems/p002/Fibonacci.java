package se.strolle.euler.problems.p002;

public class Fibonacci {

	public static void main(String[] args) {

		int MAX_VAL = 4000000;
		long cnt = 0;
		int fibVal1 = 0;
		int fibVal2 = 1;

		while (fibVal2 <= MAX_VAL) {
			int newFib = fibVal1 + fibVal2;
			if (newFib <= MAX_VAL && newFib % 2 == 0) {
				cnt += newFib;
			}
			fibVal1 = fibVal2;
			fibVal2 = newFib;
		}

		System.out.println("Result: " + cnt);

		System.exit(0);
	}

}
