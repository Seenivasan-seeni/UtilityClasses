package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee1 {
	private String name;
	private int salary;
	private String dept;

	public Employee1(String name, int salary, String dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}

public class HighestSalaryByDept {

	public static void main(String[] args) {

		Employee1 emp1 = new Employee1("Seeni", 1000, "EEE");
		Employee1 emp2 = new Employee1("Arun", 6000, "ECE");
		Employee1 emp3 = new Employee1("Senthil", 7000, "CS");
		Employee1 emp4 = new Employee1("Kumar", 1500, "EEE");
		Employee1 emp5 = new Employee1("Venkat", 10000, "CS");
		Employee1 emp6 = new Employee1("Prem", 3000, "ECE");
		Employee1 emp7 = new Employee1("Ram", 1300, "EEE");

		List<Employee1> empList = new ArrayList<Employee1>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		empList.add(emp6);
		empList.add(emp7);
		
		Map<String, Employee1> empHighSal = empList.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDept(), Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(emp -> emp.getSalary())), Optional::get)));

		empHighSal.entrySet().forEach(
				r -> System.out.println(r.getKey() + ":" + r.getValue().getName() + ":" + r.getValue().getSalary()));

	}

}
