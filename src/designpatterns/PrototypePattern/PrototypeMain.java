package designpatterns.PrototypePattern;

public class PrototypeMain {

	public static void main(String[] args) {

		//Prototype design pattern
		
		Shape circlePrototype = new Square("Red");

		ShapeClient shapeClient = new ShapeClient(circlePrototype);

		Shape circleShape = shapeClient.createShape();

		circleShape.draw();

	}

}
