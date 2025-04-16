package behaviouraldesignpatterns.ChainOfResponsibility;

public class ErrorLogAppender extends Logger {

	public ErrorLogAppender(int level) {
		this.level = level;
	}

	@Override
	public void displayLogInfo(String msg) {
		System.out.println("Error Log -> " + msg);
	}

}
