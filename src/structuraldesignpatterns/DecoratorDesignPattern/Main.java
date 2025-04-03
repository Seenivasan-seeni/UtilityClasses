package structuraldesignpatterns.DecoratorDesignPattern;

public class Main {

	public static void main(String[] args) {
		Pizza pizza = new JalepenoDecorator(new CheeseDecorator(new BasePizza()));
		System.out.println(pizza.bake());
	}
}
