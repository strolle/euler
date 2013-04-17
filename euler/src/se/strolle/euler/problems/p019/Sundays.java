package se.strolle.euler.problems.p019;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Sundays {

	public static void main(String[] args) {
		long result = 0;
		
		//ugly solution
		
		for (int year = 1901; year <= 2000; year++) {
		    for (int month = 0; month < 12; month++) {
		        if ((new GregorianCalendar(year, month, 1)).get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
		        	result++;
		        }
		    }
		}		System.out.println("Result: " + result);
		
		System.exit(0);
	}

}
