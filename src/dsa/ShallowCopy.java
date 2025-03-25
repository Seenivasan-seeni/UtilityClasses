package dsa;

class Address {
	String city;

	Address(String city) {
		this.city = city;
	}
}

class Student implements Cloneable {
	String name;
	Address address;

	Student(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone(); // For non primitive objects, it will reference that variable. If one object is
								// changed then it will reflect the another object.
	}
}

public class ShallowCopy {

	public static void main(String[] args) throws CloneNotSupportedException {

		Address address = new Address("abc address");

		Student student1 = new Student("Seeni", address);
		Student student2 = (Student) student1.clone();

		System.out.println(student1.address.city);
		System.out.println(student2.address.city);

		student2.address.city = "India";

		System.out.println(student1.address.city);
		System.out.println(student2.address.city);

	}

}
