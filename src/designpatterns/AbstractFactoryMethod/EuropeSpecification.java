package designpatterns.AbstractFactoryMethod;

public class EuropeSpecification implements CarSpecification {

	@Override
	public void display() {
		System.out.println("EuropeSpecification - display()...");
	}

}
