package creationaldesignpatterns.FactoryMethod;

public class TwoWheeler extends Vehicle {
	
	String colour;
	
	@Override
	public void printVehicle(){
		System.out.println("Inside Concrete class - TwoWheeler - printVehicle - colour " + colour);
	}

	@Override
	void configure(String colour) {
		this.colour = colour;
	}

}
