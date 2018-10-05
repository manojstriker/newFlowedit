package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j {
	static Logger log;
	public Log4j() {
		log=Logger.getLogger(Log4j.class);
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\utilities\\Log4j.properties");
	   }
	public static void infoLog(String message){
		log.info(message);
	}
    public static void errorLogLog(String message){
    	log.error(message);
    	
    }
   
    
    public static void main(String[] args) {
		//Log4j log=new Log4j();
		//log.infoLog("SSSSSSSSSSSSS");
	}
	
}
