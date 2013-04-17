package se.strolle.euler.problems.p012;

public class Triangle {
	final static int TO_FIND = 501;

	public static void main(String[] args) {
		long time=System.currentTimeMillis();
		
		long number = 0;
		long maxVal = 0;
		long test = 0;
		int i = 1;
		while (maxVal < TO_FIND) {
			test += i;

			long val = count(test);
			if (val > maxVal) {
				System.out.println(i + " - " + test + " - " + val);
				maxVal = val;
				number = test;
			}

			i++;
		}

		System.out.println("Result: " + number);
		System.out.println("Time: " + (System.currentTimeMillis()-time)+"ms");

		System.exit(0);
	}

	public static long count(long numberToTest) {
		long count = 1;
		long i = 2;
		long result = 1;
		while (numberToTest > 1) {
			count = 1;
			while (numberToTest % i == 0) {
				numberToTest = numberToTest / i;
				count++;
			}
			result = result * count;
			i++;
		}
		return result;
	}
}
