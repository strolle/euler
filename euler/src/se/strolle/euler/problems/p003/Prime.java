package se.strolle.euler.problems.p003;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import se.strolle.euler.util.PrimeUtil;

public class Prime {

    public static void main(String[] args) {
        long NUM_TO_FACTOR = 600851475143L;

        List<Long> factors = new LinkedList<Long>();
        long currentTest = 2;
        while (currentTest <= NUM_TO_FACTOR / 2) {
            if (NUM_TO_FACTOR % currentTest == 0) {
                NUM_TO_FACTOR /= currentTest;
                factors.add(currentTest);
            }
            currentTest = nextPrime(currentTest);
        }

        System.out.println("Result: " + NUM_TO_FACTOR);
        System.out.println("All: " + Arrays.toString(factors.toArray()));

        System.exit(0);
    }

    private static long nextPrime(long input) {
        if (input % 2 == 0)
            input++;
        while (!PrimeUtil.isPrime(input)) {
            input += 2;
        }
        return input;
    }

}
