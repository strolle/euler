package se.strolle.euler.problems.p004;

public class Palindrome {

	public static void main(String[] args) {
		int maxNum = 0;
		for (int i = 999; i >= 100; i--) {
			if (i * 999 < maxNum)
				break;
			for (int j = 999; j >= 100; j--) {
				int num = i * j;
				if (num < maxNum)
					break;
				if (isPalindrome(num)) {
					maxNum = num;
				}
			}
		}
		System.out.println("Result: " + maxNum);

		System.exit(0);
	}

	private static boolean isPalindrome(int number) {
		String numString = "" + number;
		for (int i = 0; i < numString.length() / 2; i++) {
			if (numString.charAt(i) != numString.charAt(numString.length() - 1
					- i))
				return false;
		}
		return true;
	}
}
