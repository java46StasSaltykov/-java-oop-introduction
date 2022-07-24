package telran.text;

import java.util.Comparator;

public class datesComparator implements Comparator <String>{

	@Override
	public int compare(String s1, String s2) {
		int year1 = Integer.parseInt(s1.substring(s1.lastIndexOf("/")+1));
		int year2 = Integer.parseInt(s2.substring(s2.lastIndexOf("/")+1));
		int month1 = Integer.parseInt(s1.substring(s1.indexOf("/")+1, s1.lastIndexOf("/")));
		int month2 = Integer.parseInt(s2.substring(s2.indexOf("/")+1, s2.lastIndexOf("/")));
		int day1 = Integer.parseInt(s1.substring(0, s1.indexOf("/")));
		int day2 = Integer.parseInt(s2.substring(0, s2.indexOf("/")));
		if (year1 != year2) {
			return Integer.compare(year1, year2);
		} else if (year1 == year2 && month1 != month2) {
			return Integer.compare(month1, month2);
		} else if (year1 == year2 && month1 == month2 && day1 != day2) {
			return Integer.compare(day1, day2);
		}
		return 0;
	}

}
