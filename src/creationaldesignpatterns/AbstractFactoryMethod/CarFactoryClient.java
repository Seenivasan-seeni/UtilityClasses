package creationaldesignpatterns.AbstractFactoryMethod;

public class CarFactoryClient {

	public static void main(String[] args) {
		CarFactory europeCarFactory = new EuropeCarFactory();
		Car hutchCar = europeCarFactory.createCar();
		CarSpecification europeSpecification = europeCarFactory.createSpecification();
		
		hutchCar.assemble();
		europeSpecification.display();
	}
}
