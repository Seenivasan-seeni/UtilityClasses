package creationaldesignpatterns.AbstractFactoryMethod;

public class EuropeCarFactory implements CarFactory {

	@Override
	public Car createCar() {
		return new Hutch();
	}

	@Override
	public CarSpecification createSpecification() {
		return new EuropeSpecification();
	}
	

}
