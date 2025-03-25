package designpatterns.PrototypePattern;

public class Circle implements Shape {
	
	private String colour ;
	
	Circle(String colour){
		this.colour = colour;
	}

	@Override
	public Shape clone() {
		return new Circle(colour);//like a deep copy
	}

	@Override
	public void draw() {
		System.out.println("Drawing circle and its colour is " + colour);
	}

}
