package telran.people;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import telran.people.comparators.EmployeeSalaryComparator;
import telran.people.comparators.PersonAgeComparator;

public class CompanyArray implements ICompany {
protected  Employee[] employees = new Employee[0];
private class CompanyIterator implements Iterator<Employee> {
int currentInd = 0;
	@Override
	public boolean hasNext() {
		
		return currentInd < employees.length;
	}

	@Override
	public Employee next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return employees[currentInd++];
	}
	
}
	@Override
	public boolean addEmployee(Employee empl) {
		if (getEmployee(empl.getId()) != null) {
			return false;
		}
		employees = Arrays.copyOf(employees, employees.length + 1);
		employees[employees.length - 1] = empl;
		
		return true;
	}

	@Override
	public Employee removeEmployee(long id) {
		int index = getEmployeeIndex(id);
		if(index < 0) {
			return null;
		}
		Employee res = employees[index];
		Employee[] tmp = new Employee[employees.length - 1];
		System.arraycopy(employees, 0, tmp, 0, index);
		System.arraycopy(employees, index+1, tmp, index, tmp.length - index);
		employees = tmp;
		
		return res;
	}

	@Override
	public Employee getEmployee(long id) {
		int index = getEmployeeIndex(id);
		
		return index < 0 ? null : employees[index];
	}

	protected int getEmployeeIndex(long id) {
		for(int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public long computeSalaryBudget() {
		long res = 0;
		for(int i = 0; i < employees.length; i++) {
			res += employees[i].computePay();
		}
		return res;
	}

	@Override
	public Employee[] getAllEmployees() {
		Employee[]res = Arrays.copyOf(employees, employees.length);
		Arrays.sort(res);
		return res;
	}

	@Override
	public Employee[] sortEmployeesByAge() {
		Employee[] res = Arrays.copyOf(employees, employees.length);
		Arrays.sort(res, (p1, p2) -> {
			return Integer.compare(p2.getBirthYear(), p1.getBirthYear());
		});
		return res;
	}

	@Override
	public Employee[] sortEmployeesBySalary() {
		Employee[] res = Arrays.copyOf(employees, employees.length);
		Arrays.sort(res, (o1, o2) -> {
			return Integer.compare(o1.computePay(), o2.computePay());
		});
		return res;
	}

	@Override
	public Employee[] findEmployees(Predicate<Employee> predicate) {
		Employee[] res = new Employee[employees.length];
		int ind = 0;
		
		for (int i = 0; i < employees.length; i++) {
			if (predicate.test(employees[i])) {
				res[ind++] = employees[i];
				
			}
			
		}
		return Arrays.copyOf(res, ind);
	}

	@Override
	public Iterator<Employee> iterator() {
		
		return new CompanyIterator();
	}

}
