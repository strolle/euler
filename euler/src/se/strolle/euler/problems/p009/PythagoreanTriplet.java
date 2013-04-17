package se.strolle.euler.problems.p009;

public class PythagoreanTriplet {

	public static void main(String[] args) {

		for (int i = 1; i < 1000; i++) {
			for (int j = i + 1; j < 1000; j++) {
				int k = 1000 - i - j;
				int sum = i + j + k;
				if (sum > 1000)
					break;
				int leftHand = i * i + j * j;
				int rightHand = k * k;
				if (leftHand == rightHand) {
					System.out.println("Result: " + i + " : " + j + " : " + k);
					System.out.println("Result: " + (i * j * k));
					System.exit(0);
				}

			}
		}

		System.exit(0);
	}
}
