package telran.people.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.people.*;

class PersonEmployeeTests {

	private static final long ID = 123;
	private static final int BIRTH_YEAR = 2000;
	private static final String EMAIL = "vasya@gmail.com";
	private static final String ANOTHER_EMAIL = "vasya@telran.com";
	private static final int BASIC_SALARY = 1000;
	private static final int SALES = 50;
	private static final int PERCENT_PAY = 50;
	private static final int WAGE = 200;
	private static final int HOURS = 5;
	private static final int WAGE_EMPLOYEE_SALARY = 2000;
	private static final int SALES_PERSON_SALARY = 1025;
	private static final int ANOTHER_BASIC_SALARY = 10000;
	private static final int ANOTHER_SALES = 500;
	private static final int ANOTHER_PERCENT_PAY = 10;
	private static final int ANOTHER_WAGE = 300;
	private static final int ANOTHER_HOURS = 20;
	private static final int ANOTHER_WAGE_EMPLOYEE_SALARY = 7000;
	private static final int ANOTHER_SALES_PERSON_SALARY = 1050;

	@Test
	void personTest() {
		Person person = new Person(ID, BIRTH_YEAR, EMAIL);
		// Person constructor and getters test
		assertEquals(ID, person.getId());
		assertEquals(BIRTH_YEAR, person.getBirthYear());
		assertEquals(EMAIL, person.getEmail());
		/***************************************/
		// Person setter test
		person.setEmail(ANOTHER_EMAIL);
		assertEquals(ANOTHER_EMAIL, person.getEmail());
	}

	@Test
	void employeeTest() {
		Employee empl = new Employee(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY);
		// Employee constructor test
		assertEquals(ID, empl.getId());
		assertEquals(BIRTH_YEAR, empl.getBirthYear());
		assertEquals(EMAIL, empl.getEmail());
		/******************************************************/
		// Employee computePay test
		assertEquals(BASIC_SALARY, empl.computePay());
		/***********************************************************/
		// Employee setter test
		empl.setBasicSalary(ANOTHER_BASIC_SALARY);
		assertEquals(ANOTHER_BASIC_SALARY, empl.computePay());
	}

	@Test
	void wageEmployeeTest() {
		WageEmployee wageEmpl = new WageEmployee(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY, WAGE, HOURS);
		// WageEmployee constructor test
		assertEquals(ID, wageEmpl.getId());
		assertEquals(BIRTH_YEAR, wageEmpl.getBirthYear());
		assertEquals(EMAIL, wageEmpl.getEmail());
		/**********************************************/
		// WageEmployee computePay test
		assertEquals(WAGE_EMPLOYEE_SALARY, wageEmpl.computePay());
		/***********************************************************/
		// WageEmployee setters test
		wageEmpl.setHours(ANOTHER_HOURS);
		wageEmpl.setWage(ANOTHER_WAGE);
		assertEquals(ANOTHER_WAGE_EMPLOYEE_SALARY, wageEmpl.computePay());
	}

	@Test
	void salesPersonTest() {
		SalesPerson salesPerson = new SalesPerson(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY, SALES, PERCENT_PAY);
		// SalesPerson constructor
		assertEquals(ID, salesPerson.getId());
		assertEquals(BIRTH_YEAR, salesPerson.getBirthYear());
		assertEquals(EMAIL, salesPerson.getEmail());
		/**********************************************/
		// SalesPerson computePay test
		assertEquals(SALES_PERSON_SALARY, salesPerson.computePay());
		/***********************************************************/
		// SalesPerson setters test
		salesPerson.setSales(ANOTHER_SALES);
		salesPerson.setPercentPay(ANOTHER_PERCENT_PAY);
		assertEquals(ANOTHER_SALES_PERSON_SALARY, salesPerson.computePay());
	}
	
	@Test
	void wrongBirthYearTest() {
		boolean flException = false;
		try {
			new SalesPerson(123, 2018, "sp@.com", 1000, 100, 50);
			fail("Should be thrown exception");
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(flException);
		try {
			new Employee(100, 1913, ANOTHER_EMAIL, BASIC_SALARY);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	void emailTest() {
		try {
			new Employee(120, 1978, "empl@gmail.com", 1000);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		try {
			new Person(120, 1978, "emplgmail.com");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			new SalesPerson(120, 1978, "emplgmail@com", 1000, 100, 10);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			new WageEmployee(120, 1978, "@emplgmailcom", 1000, 10, 10);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void salaryTest() {
		try {
			new Employee(120, 1978, "empl@gmail.com", 10);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void percentTest() {
		try {
			new SalesPerson(120, 1978, "empl@gmail.com", 1000, 100, 120);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}





