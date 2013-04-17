package se.strolle.euler.problems.p001;

public class Multiples {
	public static void main(String args[]) {
		int cnt = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				cnt += i;
		}
		System.out.println("result: " + cnt);

		System.exit(0);
	}
}
