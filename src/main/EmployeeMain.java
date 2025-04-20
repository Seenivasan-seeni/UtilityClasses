package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Seeni", 26, "JAVA", "INDIA", 85000);
		Employee employee2 = new Employee("Kumar", 27, "AUTOMATION TESTING", "US", 70000);
		Employee employee3 = new Employee("Raj", 31, "MANUAL TESTING", "AUSTRALIA", 120000);
		Employee employee4 = new Employee("Hari", 24, "HTML", "INDIA", 30000);
		Employee employee5 = new Employee("Kathir", 26, "JAVA", "CANADA", 87000);

		List<Employee> empList = new ArrayList<>();
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		empList.add(employee4);
		empList.add(employee5);

//		Map<Object, Employee> groupBycountry = empList.stream()
//				.collect(Collectors.groupingBy(emp -> emp.getCountry(), Collectors.collectingAndThen(
//						Collectors.minBy(Comparator.comparingDouble(a -> a.getSalary())), Optional::get)));

		Map<Object, Set<Employee>> groupBycountry = empList.stream()
				.collect(Collectors.groupingBy(emp -> emp.getCountry(),
						Collectors.collectingAndThen(Collectors.toList(),
								list -> list.stream().sorted(Comparator.comparingDouble(emp -> emp.getSalary()))
										.collect(Collectors.toSet()))));

		groupBycountry.forEach((country, empSal) -> System.out.println(country + " : " + empSal));
		System.out.println(groupBycountry);
	}

}
