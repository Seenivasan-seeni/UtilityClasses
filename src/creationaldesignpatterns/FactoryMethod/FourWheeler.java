package creationaldesignpatterns.FactoryMethod;

public class FourWheeler extends Vehicle {
	
	String colour;
	
	@Override
	public void printVehicle(){
		System.out.println("Inside Concrete class - FourWheeler - printVehicle - colour " + colour);
	}
	
	@Override
	void configure(String colour) {
		this.colour = colour;
	}

}
