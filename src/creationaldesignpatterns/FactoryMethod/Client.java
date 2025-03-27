package creationaldesignpatterns.FactoryMethod;

public class Client {

	private VehicleFactory vehicleFactory;

	Client(VehicleFactory vehicleFactory) {
		this.vehicleFactory = vehicleFactory;
	}

	private void log(String msg) {
		System.out.println("[LOG] -> " + msg);
	}

	private boolean validateFactory() {
		if (vehicleFactory == null) {
			log("Invalid Vehicle...");
			return false;
		}
		return true;
	}

	public Vehicle getVehicle(String colour) {
		if (!validateFactory()) {
			return null;
		}
		log("Creating vehicle object -> " + vehicleFactory.getClass().getName());
		Vehicle vehicle = vehicleFactory.createVehicle();
		vehicle.configure(colour);
		log("Vehicle created with " + colour);
		return vehicle;
	}

}
