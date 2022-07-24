package telran.people;

public class Employee extends Person {
	private int basicSalary;
	private static int minBirthYear = 1950;
	private static int maxBirthYear = 2000;
	private static int minSalary = 100;
	
	public static int getMinBirthYear() {
		return minBirthYear;
	}

	public static void setMinBirthYear(int minBirthYear) {
		Employee.minBirthYear = minBirthYear;
	}

	public static int getMaxBirthYear() {
		return maxBirthYear;
	}

	public static void setMaxBirthYear(int maxBirthYear) {
		Employee.maxBirthYear = maxBirthYear;
	}

	public Employee(long id, int birthYear, String email, int basicSalary) {
		super(id, birthYear, email);
		if (birthYear < minBirthYear || birthYear > maxBirthYear) {
			throw new IllegalArgumentException(String.format("%d  - Wrong birth year, " + 
					"should be in range [%d - %d]", birthYear, minBirthYear, maxBirthYear));
		}
		setBasicSalary(basicSalary);
	}

	public void setBasicSalary(int basicSalary) {
		if (basicSalary >= minSalary) {
			this.basicSalary = basicSalary;
		} else {
			throw new IllegalArgumentException(String.format("Salary must be greater than %d", minSalary));
		}
	}

	public int computePay() {
		return basicSalary;
	}

}
