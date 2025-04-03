package structuraldesignpatterns.DecoratorDesignPattern;

public class JalepenoDecorator extends PizzaDecorator {

	public JalepenoDecorator(Pizza pizza) {
		super(pizza);
	}
	
	public String bake() {
		return pizza.bake() + addJalepeno();
	}
	
	private String addJalepeno() {
		return " Jalepeno";
	}

}
