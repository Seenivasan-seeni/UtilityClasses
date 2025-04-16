package structuraldesignpatterns.ProxyDesignPattern;

public class MainClient {

	public static void main(String[] args) {
		OfficeInternetAccess access = new ProxyInternetAccess("Seeni");
		access.provideInternetAccess();
	}

}
