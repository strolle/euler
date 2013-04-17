package se.strolle.euler.problems.p006;

public class CalculatePowers {

	final static int MAX_NUM = 100;

	public static void main(String[] args) {
		long sum = 0;
		long squareSumFactor = 0L;

		for (int i = 1; i <= 100; i++) {
			sum += i;
			squareSumFactor += i * i;
			System.out.println("squareSumFactor " + i + ": " + squareSumFactor);
		}
		sum = sum * sum;

		long diff = sum - squareSumFactor;
		System.out.println("squareSumFactor: " + squareSumFactor);
		System.out.println("sum: " + sum);
		System.out.println("diff: " + diff);
		System.exit(0);
	}
}
