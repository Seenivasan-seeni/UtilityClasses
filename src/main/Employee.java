package main;

public class Employee implements Comparable<Employee> {

	private String empName;
	private int age;
	private String domain;
	private String country;
	private double salary;

	public String getEmpName() {
		return empName;
	}

	public int getAge() {
		return age;
	}

	public String getDomain() {
		return domain;
	}

	public String getCountry() {
		return country;
	}

	public double getSalary() {
		return salary;
	}

	public Employee(String empName, int age, String domain, String country, double salary) {
		super();
		this.empName = empName;
		this.age = age;
		this.domain = domain;
		this.country = country;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", age=" + age + ", domain=" + domain + ", country=" + country
				+ ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.age > o.age ? 1 : -1;
	}

}
