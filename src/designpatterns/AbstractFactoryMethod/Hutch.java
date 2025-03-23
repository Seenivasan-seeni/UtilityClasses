package designpatterns.AbstractFactoryMethod;

public class Hutch implements Car{

	@Override
	public void assemble() {
		System.out.println("Hutch - assemble()....");
	}

}
