package structuraldesignpatterns.DecoratorDesignPattern;

public class BasePizza implements Pizza {

	@Override
	public String bake() {
		return "Basepizza";
	}

}
