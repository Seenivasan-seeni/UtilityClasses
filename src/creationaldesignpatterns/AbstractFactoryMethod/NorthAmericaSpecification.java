package creationaldesignpatterns.AbstractFactoryMethod;

public class NorthAmericaSpecification implements CarSpecification {

	@Override
	public void display() {
		System.out.println("NorthAmericaSpecification - display()...");
	}

}
