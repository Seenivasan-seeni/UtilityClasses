package structuraldesignpatterns.ProxyDesignPattern;

public class ProxyInternetAccess implements OfficeInternetAccess {

	private RealInternetAccess realInternetAccess;

	private String empName;

	public ProxyInternetAccess(String empName) {
		this.empName = empName;
	}

	@Override
	public void provideInternetAccess() {
		if (getRole(empName) > 4) {
			System.out.println("Calling from ProxyInternetAccess to RealInternetAccess Object...");
			realInternetAccess = new RealInternetAccess(empName);// Calling the Real Internet Access object by some
																	// condition by the ProxyInternet Object
			realInternetAccess.provideInternetAccess();
		}
	}

	private int getRole(String empName) {
		return 9;
	}

}
