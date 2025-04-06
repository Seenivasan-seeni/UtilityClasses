package structuraldesignpatterns.FlyWeightDesignPattern;

public class Circle implements Shape {

	private String colour;// Intrinsic state. During the object creation time only the values are assigned
							// and can't able to change. So this is called intrinsic state.

	Circle(String colour) {
		this.colour = colour;
	}

	// int x and int y are extrinsic state. That values will be changed by the
	// client dynamically
	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing circle with " + colour + " colour and its dimensions are x = " + x + " y = " + y);
	}

}
