package serverUtils;

public class Logger {

	public enum LogType {
		ERROR,
		WARNING,
		MESSAGE
	}
	
	public static void log(LogType messageType, String message) {
		System.out.println(messageType.toString() + ": " + message);
	}
}
