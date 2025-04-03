package structuraldesignpatterns.DecoratorDesignPattern;

public class CheeseDecorator extends PizzaDecorator {

	public CheeseDecorator(Pizza pizza) {
		super(pizza);
	}
	
	public String bake() {
		return pizza.bake() + addCheese();
	}
	
	private String addCheese() {
		return " Cheese";
	}

}
