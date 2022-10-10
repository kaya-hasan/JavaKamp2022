package Odev3.core.logging;

public class DatabaseLogger implements Logger{

	@Override
	public void log(String data) {
		System.out.println(data + "Database ile loglandi");
		
	}

}
