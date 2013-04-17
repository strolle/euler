package se.strolle.euler.problems.p089;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Roman {

    private static Map<Integer, String> values0 = new HashMap<Integer, String>();
    private static Map<Integer, String> values1 = new HashMap<Integer, String>();
    private static Map<Integer, String> values2 = new HashMap<Integer, String>();
    private static Map<Integer, String> values3 = new HashMap<Integer, String>();

    private static Map<String, Integer> letterValues = new HashMap<String, Integer>();

    private static List<Map<Integer, String>> valueList = new ArrayList<Map<Integer, String>>();

    public static void main(String args[]) throws Exception {
        long start = System.currentTimeMillis();
        initValues();

        int cnt = 0;
        BufferedReader br = new BufferedReader(new FileReader("/Users/stefantrolle/Documents/workspace/euler/src/se/strolle/euler/problems/p089/roman.txt"));
        try {
            String line = "";
            while (line != null) {
                line = br.readLine();

                if (line != null) {
                    line = line.trim();
                    String goodRoman = createRoman(parseRoman(line));
                    cnt += (line.length() - goodRoman.length());
                }
            }
        } finally {
            br.close();
        }
        long stop = System.currentTimeMillis();

        System.out.println("result: " + cnt);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static void initValues() {
        values0.put(0, "");
        values0.put(1, "I");
        values0.put(2, "II");
        values0.put(3, "III");
        values0.put(4, "IV");
        values0.put(5, "V");
        values0.put(6, "VI");
        values0.put(7, "VII");
        values0.put(8, "VIII");
        values0.put(9, "IX");

        values1.put(0, "");
        values1.put(1, "X");
        values1.put(2, "XX");
        values1.put(3, "XXX");
        values1.put(4, "XL");
        values1.put(5, "L");
        values1.put(6, "LX");
        values1.put(7, "LXX");
        values1.put(8, "LXXX");
        values1.put(9, "XC");

        values2.put(0, "");
        values2.put(1, "C");
        values2.put(2, "CC");
        values2.put(3, "CCC");
        values2.put(4, "CD");
        values2.put(5, "D");
        values2.put(6, "DC");
        values2.put(7, "DCC");
        values2.put(8, "DCCC");
        values2.put(9, "CM");

        values3.put(0, "");
        values3.put(1, "M");
        values3.put(2, "MM");
        values3.put(3, "MMM");
        values3.put(4, "MMMM");
        values3.put(5, "MMMMM");
        values3.put(6, "MMMMMM");
        values3.put(7, "MMMMMMM");
        values3.put(8, "MMMMMMMM");
        values3.put(9, "MMMMMMMMM");

        valueList.add(values0);
        valueList.add(values1);
        valueList.add(values2);
        valueList.add(values3);

        letterValues.put("I", 1);
        letterValues.put("V", 5);
        letterValues.put("X", 10);
        letterValues.put("L", 50);
        letterValues.put("C", 100);
        letterValues.put("D", 500);
        letterValues.put("M", 1000);
    }

    private static String createRoman(int number) {
        String out = "";
        int tmp = number;
        int pos = 0;
        while (tmp > 0) {
            int num = tmp % 10;
            out = valueList.get(pos).get(num) + out;
            tmp /= 10;
            pos++;
        }
        return out;
    }

    private static int parseRoman(String romanNumber) {
        int number = 0;
        char[] data = romanNumber.toCharArray();

        int highestUsed = 0;
        for (int i = data.length - 1; i >= 0; i--) {
            int val = letterValues.get("" + data[i]);
            if (val >= highestUsed) {
                number += val;
                highestUsed = val;
            } else
                number -= val;
        }

        return number;
    }
}
