package creationaldesignpatterns.FactoryMethod;

public class TwoWheelerFactory implements VehicleFactory {

	public Vehicle createVehicle() {
		return new TwoWheeler();
	}

}
