package se.strolle.euler.problems.p022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameScore {

	public static void main(String[] args) throws Exception {
		long result = 0;
		int charVal = 'a' - 1;

		List<String> input = readInput();
		Collections.sort(input);

		for (int i = 0; i < input.size(); i++) {
			long individualResult = 0;
			char[] name = input.get(i).toCharArray();
			for (int j=0; j < name.length; j++){
				individualResult += (name[j]-charVal);
			}
			individualResult*=(i+1);
			result+=individualResult;
			System.out.println(i + ": " + input.get(i) + " - " + individualResult);
		}

		System.out.println("Result: " + result);

		System.exit(0);
	}

	static List<String> readInput() throws Exception {
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"C:/programming/workspace/euler/src/se/strolle/euler/problems/p022/names.txt")));

		List<String> out = new ArrayList<String>();
		String line = "";
		while ((line = buf.readLine()) != null) {
			String[] lineSplit = line.substring(1, line.length() - 1).toLowerCase().split(
					"\",\"");
			for (String name : lineSplit) {
				out.add(name);
			}
		}
		return out;
	}

}
