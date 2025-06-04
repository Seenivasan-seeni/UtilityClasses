package dsa;

class Address1 {
	String city;

	Address1(String city) {
		this.city = city;
	}

	public Object clone() {
		return new Address1(this.city);

	}
}

class Student1 implements Cloneable {
	String name;
	Address1 address;

	Student1(String name, Address1 address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * Below defined both types of deepcopy will work
	 */
	public Object clone() throws CloneNotSupportedException {
		Student1 clonedPerson = (Student1) super.clone();
		clonedPerson.address = (Address1) clonedPerson.address.clone();
		
//		clonedPerson.address = (Address1)  new Address1(this.address.city);
		return clonedPerson;
	}
}

public class DeepCopy {

	public static void main(String[] args) throws CloneNotSupportedException {

		Address1 address = new Address1("US");
		Student1 student1 = new Student1("Seeni", address);
		Student1 student2 = (Student1) student1.clone();

		System.out.println(student1.address.city);
		System.out.println(student2.address.city);

		student1.address.city = "India";

		System.out.println(student1.address.city);
		System.out.println(student2.address.city);

	}
}
