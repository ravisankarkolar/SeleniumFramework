package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	static Logger  loger= LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Logging");
		loger.info("info message");
		loger.error("Error");
		loger.warn("warning");
		
		

	}

}
