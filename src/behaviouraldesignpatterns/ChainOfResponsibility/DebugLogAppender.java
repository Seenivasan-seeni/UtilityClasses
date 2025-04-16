package behaviouraldesignpatterns.ChainOfResponsibility;

public class DebugLogAppender extends Logger {
	
	public DebugLogAppender(int level) {
		this.level = level;
	}

	@Override
	public void displayLogInfo(String msg) {
		System.out.println("Debug Log -> " + msg);
	}

}
