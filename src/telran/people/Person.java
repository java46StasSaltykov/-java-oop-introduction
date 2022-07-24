package telran.people;

import java.util.regex.Pattern;

public class Person implements Comparable<Person>{
	private long id;
	private int birthYear;
	private String email;

	public Person(long id, int birthYear, String email) {
		this.id = id;
		this.birthYear = birthYear;
		setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+.-]+@[a-z]+(\\.[a-z]+)$";
		Pattern p = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		if (email == null || p.matcher(email).matches()) {
			this.email = email;
		} else {
			throw new IllegalArgumentException(String.format("The given email doesn't match the email pattern."));
		}
	}

	public long getId() {
		return id;
	}

	public int getBirthYear() {
		return birthYear;
	}

	@Override
	public int compareTo(Person o) {
		return Long.compare(this.id, o.id);
	}

}
