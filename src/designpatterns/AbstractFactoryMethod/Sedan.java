package designpatterns.AbstractFactoryMethod;

public class Sedan implements Car{

	@Override
	public void assemble() {
		System.out.println("Sedan - Assemble()...");
	}

}
