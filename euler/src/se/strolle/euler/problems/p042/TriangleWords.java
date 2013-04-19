package se.strolle.euler.problems.p042;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import se.strolle.euler.util.FileUtil;

public class TriangleWords {
    static final int LETTER_ASCII_POS = 'A' - 1;

    static int topTriangle = 0;
    static int topTriangleValue = 0;
    static Map<Integer, Boolean> triangleMap = new HashMap<Integer, Boolean>();

    public static void main(String[] args) throws IOException {
        List<String> words = init();
        long start = System.currentTimeMillis();

        int cnt = 0;
        for (String word : words) {
            int wordValue = getWordValue(word);
            if (isTriangle(wordValue))
                cnt++;
        }

        long stop = System.currentTimeMillis();

        System.out.println("\nresult: " + cnt);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);

    }

    private static boolean isTriangle(int wordValue) {
        while (topTriangleValue < wordValue) {
            topTriangle++;
            topTriangleValue = topTriangle * (topTriangle + 1) / 2;
            triangleMap.put(topTriangleValue, true);
        }

        if (triangleMap.containsKey(wordValue))
            return true;
        return false;
    }

    private static int getWordValue(String word) {
        int value = 0;
        for (int i = 0; i < word.length(); i++) {
            value += word.charAt(i) - LETTER_ASCII_POS;
        }
        return value;
    }

    private static List<String> init() throws IOException {
        List<String> words = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(
                FileUtil.getFile("/se/strolle/euler/problems/p042/words.txt")));

        try {
            String line = "";
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                while (tokenizer.hasMoreElements()) {
                    String token = tokenizer.nextToken();
                    words.add(token.substring(1, token.length() - 1));
                }
            }
            return words;
        } finally {
            br.close();
        }

    }
}
