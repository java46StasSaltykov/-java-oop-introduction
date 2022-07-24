package telran.text;

import java.util.Arrays;

public class Strings { 
	/**
	 * 
	 * @param dates - array of strings containing dates in the format D/M/YYYY
	 * D day of month without leading 0 (3)
	 * M month number (1 - 12)
	 * YYYY year (1980)
	 * @return array sorted by dates
	 * use only class String and interface Comparator
	 */
	public static String[] sortStringsAsDates(String[] dates) {
		String[] res = Arrays.copyOf(dates, dates.length);
		Arrays.sort(res, new datesComparator());
		System.out.println(Arrays.toString(res));
		return res;
	}

}