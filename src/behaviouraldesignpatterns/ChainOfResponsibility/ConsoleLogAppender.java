package behaviouraldesignpatterns.ChainOfResponsibility;

public class ConsoleLogAppender extends Logger {
	
	public ConsoleLogAppender(int level) {
		this.level = level;
	}

	@Override
	public void displayLogInfo(String msg) {
		System.out.println("Console Log -> " + msg);
	}

}
