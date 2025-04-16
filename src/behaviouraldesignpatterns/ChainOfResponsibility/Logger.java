package behaviouraldesignpatterns.ChainOfResponsibility;

public abstract class Logger {

	protected static int CONSOLE_INFO = 1;

	protected static int DEBUG_INFO = 3;

	protected static int ERROR_INFO = 2;

	protected int level;
	
	protected Logger nextLogger;
	
	public void setNextLogger(Logger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void writeLog(int level, String msg) {
		if (this.level <= level) {
			displayLogInfo(msg);
		}
		if(nextLogger != null) {
			nextLogger.writeLog(level, msg);
		}
	}

	public abstract void displayLogInfo(String msg);

}
