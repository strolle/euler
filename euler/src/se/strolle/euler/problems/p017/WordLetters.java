package se.strolle.euler.problems.p017;


public class WordLetters {
	static int MAX_VALUE = 1000;
	static String[] singleDigit = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static String[] teens = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] tens = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static String and = "and";
	static String hundred = "hundred";

	public static void main(String[] args) {
		long result = 0;
		
		for (int i = 1; i <= MAX_VALUE; i++){
			String word = generateWord(i);
			System.out.println(word);
			result+=word.length();
		}
		System.out.println("Result: " + result);
		System.exit(0);
	}
	
	static String generateWord(int value){
		if (value==1000)
			return "onethousand";
		String word = "";
		int level = 0;
		if(value %100 <20 && value%100 >10){
			level=2;
			word=teens[(value%100) - 10];
			value/=100;
		}
		while(value>0){
			if (level==0){
				word=singleDigit[value%10];
			}
			else if (level==1){
				word=tens[value%10]+word;
			}
			else if (level==2){
				if (word.isEmpty())
					word=singleDigit[value%10]+hundred+word;
				else
					word=singleDigit[value%10]+hundred+and+word;
			}
			level++;
			value/=10;
		}
		return word;
	}
}
