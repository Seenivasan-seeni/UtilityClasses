package structuraldesignpatterns.FlyWeightDesignPattern;

import java.util.HashMap;

public class ShapeFactory {

	static HashMap<String, Shape> shapeMap = new HashMap<String, Shape>();

	public static Shape getCircle(String colour) {
		Shape circle = (Circle) shapeMap.get(colour);

		if (circle == null) {
			circle = new Circle(colour);
			shapeMap.put(colour, circle);
			System.out.println("Creating a new " + colour + " circle.");
		}
		return circle; 
	}

}
