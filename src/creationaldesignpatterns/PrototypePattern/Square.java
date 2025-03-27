package creationaldesignpatterns.PrototypePattern;

public class Square implements Shape, Cloneable {
	
	private String colour;
	
	Square(String colour){
		this.colour = colour;
	}

	@Override
	public Shape clone() {
		// TODO Auto-generated method stub
		return new Square(this.colour);
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing square with the colour of " + colour);
	}

}
