package creationaldesignpatterns.PrototypePattern;

public class ShapeClient {
	
	private Shape shapePrototype;
	
	public ShapeClient(Shape shapePrototype) {
		// TODO Auto-generated constructor stub
		this.shapePrototype = shapePrototype;
	}
	
	public Shape createShape() {
		return shapePrototype.clone();
	}

}
