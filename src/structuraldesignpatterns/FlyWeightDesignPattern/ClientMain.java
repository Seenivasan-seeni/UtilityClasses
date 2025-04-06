package structuraldesignpatterns.FlyWeightDesignPattern;

public class ClientMain {

	public static void main(String[] args) {
		//Shape Colours
		String[] colours = { "Red", "Green", "Orange" };

		for (int i = 0; i < 100; i++) {
			System.out.println("Colour number is colours[" + i % colours.length + "]");
			String colour = colours[i % colours.length];
			Circle circle = (Circle) ShapeFactory.getCircle(colour);
			circle.draw(i * 10, i * 20);
		}

	}

}
