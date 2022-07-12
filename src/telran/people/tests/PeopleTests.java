package telran.people.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.people.Employee;
import telran.people.Person;
import telran.people.SalesPerson;
import telran.people.WageEmployee;

class PeopleTests {

	@Test
	void personTest() {
		long id = 123456789;
		int birthYear = 1990;
		String email = "john@gmail.com";
		Person person1 = new Person(id, birthYear, email);
		assertEquals(id, person1.getId());
		assertEquals(birthYear, person1.getBirthYear());
		assertEquals(email, person1.getEmail());
		String email1 = "johnny@gmail.com";
		person1.setEmail(email1);
		assertEquals(email1, person1.getEmail());
	}
	
	@Test
	void employeeTest() {
		long id = 135698574;
		int birthYear = 1991;
		String email = "john@gmail.com";
		int basicSalary = 5000;
		Employee employee1 = new Employee(id, birthYear, email, basicSalary);
		assertEquals(basicSalary, employee1.computePay());
		String email1 = "johnny@gmail.com";
		int basicSalary1 = 6000;
		employee1.setBasicSalary(basicSalary1);
		employee1.setEmail(email1);
		assertEquals(basicSalary1, employee1.computePay());
		assertEquals(email1, employee1.getEmail());
	}
	
	@Test
	void wageEmployeeTest() {
		long id = 245652574;
		int birthYear = 1985;
		String email = "john@gmail.com";
		int basicSalary = 6000;
		int wage = 20;
		int hours = 100;
		WageEmployee wageEmployee1 = new WageEmployee(id, birthYear, email, basicSalary, wage, hours);
		assertEquals(8000, wageEmployee1.computePay());
	}
	
	@Test
	void salesPersonTest() {
		long id = 945852314;
		int birthYear = 1994;
		String email = "john@gmail.com";
		int basicSalary = 8000;
		int sales = 5000;
		int percentPay = 20;
		SalesPerson salesPerson1 = new SalesPerson(id, birthYear, email, basicSalary, sales, percentPay);
		assertEquals(9000, salesPerson1.computePay());
	}
	
}
