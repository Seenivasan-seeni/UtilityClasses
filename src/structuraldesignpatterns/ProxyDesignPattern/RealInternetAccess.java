package structuraldesignpatterns.ProxyDesignPattern;

public class RealInternetAccess implements OfficeInternetAccess {
	
	private String empName;
	
	public RealInternetAccess(String empName) {
		this.empName = empName;
	}

	@Override
	public void provideInternetAccess() {
		System.out.println("RealInternetAccess - empName " + empName);
	}
	
	

}
