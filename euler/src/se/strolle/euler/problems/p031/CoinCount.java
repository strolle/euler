package se.strolle.euler.problems.p031;

import java.util.ArrayList;
import java.util.List;

public class CoinCount {
    // private static final int MAX_VAL = 200;
    private static final int MAX_VAL = 200;

    private static int count = 0;

    public static void main(String[] args) throws Exception {

        List<Integer> coinList = new ArrayList<Integer>();
        coinList.add(1);
        coinList.add(2);
        coinList.add(5);
        coinList.add(10);
        coinList.add(20);
        coinList.add(50);
        coinList.add(100);
        coinList.add(200);

        calculateCoin(MAX_VAL, coinList);

        System.err.println(count);
    }

    private static void calculateCoin(int valLeft, List<Integer> coinList) {
        List<Integer> localCoinList = new ArrayList<Integer>();
        localCoinList.addAll(coinList);

        int currentCoin = localCoinList.remove(0);
        while (valLeft >= 0) {
            if (valLeft == 0) {
                count++;
            }
            else if (localCoinList.size() > 0) {
                calculateCoin(valLeft, localCoinList);
            }
            valLeft -= currentCoin;
        }
    }

}
