package structuraldesignpatterns.BridgeDesignPattern;

public class HDProcessor extends VideoProcessor {

	@Override
	void process() {
		System.out.println("Playing HD video....");
	}

}
