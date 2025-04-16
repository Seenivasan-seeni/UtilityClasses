package behaviouraldesignpatterns.CommandDesignPattern;

public class Main {

	public static void main(String[] args) {
		Light light = new Light();

		Command lightOn = new TurnOnLight(light);
		Command lightOff = new TurnOffLight(light);

		RemoteControl control = new RemoteControl();

		control.setCommand(lightOn);
		control.pressButton();

		control.setCommand(lightOff);
		control.pressButton();
		
//		ExecutorService executor = Executors.newFixedThreadPool(2);
//		executor.execute(() -> System.out.println("abc"));
	}

}
