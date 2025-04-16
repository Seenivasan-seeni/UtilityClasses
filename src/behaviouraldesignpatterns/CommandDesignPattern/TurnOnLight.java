package behaviouraldesignpatterns.CommandDesignPattern;

public class TurnOnLight implements Command {
	
	private Light light;
	
	public TurnOnLight(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.turnOn();
	}

}
