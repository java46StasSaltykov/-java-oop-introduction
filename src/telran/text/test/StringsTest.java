package telran.text.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.text.Strings;

class StringsTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testSortStringsAsDates() {
		String[] dates = {
			"14/4/1992", "1/6/1961", "19/8/1962", "27/9/2017", "12/3/1992", "13/4/1992"
		};
		String[] expected = {
			"1/6/1961", "19/8/1962", "12/3/1992", "13/4/1992", "14/4/1992", "27/9/2017"
		};
		
		assertArrayEquals(expected, Strings.sortStringsAsDates(dates));
	}

}
