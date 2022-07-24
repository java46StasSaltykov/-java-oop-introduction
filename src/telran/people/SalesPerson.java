package telran.people;

public class SalesPerson extends Employee {
	private int sales;
	private int percentPay;

	public SalesPerson(long id, int birthYear, String email, int basicSalary, int sales, int percentPay) {
		super(id, birthYear, email, basicSalary);
		setSales(sales);
		setPercentPay(percentPay);
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public void setPercentPay(int percentPay) {
		if (percentPay > 0 && percentPay < 100) {
			this.percentPay = percentPay;
		} else {
			throw new IllegalArgumentException(String.format("Percent must be in range 0-100"));
		}
	}

	@Override
	public int computePay() {
		return super.computePay() + sales * percentPay / 100;
	}

}
