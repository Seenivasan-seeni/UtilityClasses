package structuraldesignpatterns.CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

	String name;
	List<Component> components = new ArrayList<>();

	public Composite(String name) {
		super();
		this.name = name;
	}

	void addComponent(Component leaf) {
		components.add(leaf);
	}

	@Override
	public void showPrice() {
		System.out.println("Composite name: " + name);
		for (Component component : components) {
			component.showPrice();
		}
	}

}
