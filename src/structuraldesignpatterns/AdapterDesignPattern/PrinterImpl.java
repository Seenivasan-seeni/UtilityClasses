package structuraldesignpatterns.AdapterDesignPattern;

public class PrinterImpl implements Printer {
	
	LegacyPrinter legacyPrinter = new LegacyPrinter();

	@Override
	public void print() {
		System.out.println("Inside PrinterImpl - print()... ");
		legacyPrinter.printDocument();
	}

}
