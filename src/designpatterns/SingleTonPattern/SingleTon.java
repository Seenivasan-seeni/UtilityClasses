package designpatterns.SingleTonPattern;

public class SingleTon {
	
	private static SingleTon singleTon = null;
	
	private SingleTon() {
		
	}
	
	public static SingleTon getInstance() {
		if(singleTon == null) {
			synchronized (singleTon) {
				singleTon = new SingleTon();
				System.out.println("Object created...");
			}
			return singleTon;
		}
		return null;
	}

}
