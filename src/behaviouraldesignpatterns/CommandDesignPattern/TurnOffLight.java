package behaviouraldesignpatterns.CommandDesignPattern;

public class TurnOffLight implements Command{

	private Light light;

	public TurnOffLight(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.turnOff();
	}

}
