package creationaldesignpatterns.FactoryMethod;

public class Main {

	public static void main(String[] args) {
		VehicleFactory fourWheelerFactoryType = new TwoWheelerFactory();
		Client twoWheelerClient = new Client(fourWheelerFactoryType);
		Vehicle vehicle = twoWheelerClient.getVehicle("RED");
		vehicle.printVehicle();
	}
}
