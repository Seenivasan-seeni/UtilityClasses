package structuraldesignpatterns.AdapterDesignPattern;

public class Client {
	
	public static void main(String[] args) {
		Printer printer = new PrinterImpl();
		printer.print();
	}

}
