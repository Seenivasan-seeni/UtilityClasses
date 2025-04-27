package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();

		Student student1 = new Student(1, "A", "A");
		Student student2 = new Student(4, "B", "B");
		Student student3 = new Student(5, "C", "C");
		Student student4 = new Student(2, "D", "D");
		Student student5 = new Student(3, "E", "E");

		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);

		/*
		 * By using the comparator we can able to compare two Objects. No need to
		 * implement the comparator interface in the model class level. But for the
		 * Comparable class, We need to <b>implement</b> the Comparable interface in the
		 * model class level. Comparable will work only with the current
		 * object(<b>this</b> object) and the target object (<b>that</b> object).
		 */
		Comparator<Student> stuComparator = (o1, o2) -> o1.getId() > o2.getId() ? 1 : -1;
		Collections.sort(students, stuComparator);

		System.out.println(students);
	}

}
