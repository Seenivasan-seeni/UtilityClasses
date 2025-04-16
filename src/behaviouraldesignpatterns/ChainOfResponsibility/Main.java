package behaviouraldesignpatterns.ChainOfResponsibility;

public class Main {
	
	private static Logger doChaining() {
		Logger consoleLogger = new ConsoleLogAppender(Logger.CONSOLE_INFO);
		
		Logger debugLogger = new DebugLogAppender(Logger.DEBUG_INFO);
		consoleLogger.setNextLogger(debugLogger);
		
		Logger errorLogger =  new ErrorLogAppender(Logger.ERROR_INFO);
		debugLogger.setNextLogger(errorLogger);
		
		return consoleLogger;
	}

	public static void main(String[] args) {
		
		Logger logger = doChaining();
		
		logger.writeLog(Logger.CONSOLE_INFO, "Enter the sequence of values....");
		System.out.println();
		logger.writeLog(Logger.ERROR_INFO, "This was the error now debugging is completed....");
		System.out.println();
		logger.writeLog(Logger.DEBUG_INFO, "An error is occured now....");
		
	}
}
