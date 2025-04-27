package main;

import java.util.PriorityQueue;

public class PriorityQueueMain {

	public static void main(String[] args) {
		/*
		 * By default, if follows the rule of min heap type. Min heap means root element
		 * value should be small when compared to its left and right child elements
		 * otherwise the values will be swapped.
		 * 
		 * Comparator.reverseOrder() - If we pass the mentioned args in the
		 * PriorityQueue constructor then it will form the data in the format of
		 * Max-Heap Pattern
		 */
		PriorityQueue<Employee> priorityQueue = new PriorityQueue<>();
		
		Employee emp1 = new Employee("Seeni1", 29, "JAVA", "India", 70000);
		Employee emp2 = new Employee("Seeni2", 28, "JAVA", "India", 50000);
		Employee emp3 = new Employee("Seeni3", 27, "JAVA", "India", 60000);
		Employee emp4 = new Employee("Seeni4", 30, "JAVA", "India", 20000);
		Employee emp5 = new Employee("Seeni5", 26, "JAVA", "India", 35000);
		

		priorityQueue.add(emp1);
		priorityQueue.add(emp2);
		priorityQueue.add(emp3);
		priorityQueue.add(emp4);
		priorityQueue.add(emp5);

		System.out.println(priorityQueue);
		/*
		 * priorityQueue.poll() - It will return and remove the first/parent data from
		 * the queue and then again restructure the data based on the respective pattern
		 */

		System.out.println(priorityQueue.poll());
		System.out.println(priorityQueue);
	}

}
