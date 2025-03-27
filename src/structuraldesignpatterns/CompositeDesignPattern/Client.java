package structuraldesignpatterns.CompositeDesignPattern;

public class Client {

	// Composite Design pattern is a tree like data structure to print the common
	// methods(showPrice()) recursively.

	public static void main(String[] args) {
		Leaf hardDrive = new Leaf(2000, "HDD");
		Leaf mouse = new Leaf(1000, "mouse");
		Leaf monitor = new Leaf(700, "monitor");
		Leaf ram = new Leaf(9000, "RAM");
		Leaf cpu = new Leaf(8000, "CPU");

		Composite periPheral = new Composite("PeriPheral");
		Composite cabinet = new Composite("Cabinet");
		Composite motherBoard = new Composite("MotherBoard");
		Composite computer = new Composite("Computer");

		motherBoard.addComponent(ram);
		motherBoard.addComponent(cpu);

		cabinet.addComponent(hardDrive);
		cabinet.addComponent(motherBoard);
		periPheral.addComponent(mouse);
		periPheral.addComponent(monitor);

		computer.addComponent(cabinet);
		computer.addComponent(periPheral);

		computer.showPrice();
	}
}
