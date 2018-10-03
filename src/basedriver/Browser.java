package basedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	static WebDriver driver;
	public static WebDriver startBrowser(String broswername,String url) {
		if(broswername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\practice_selenium_Framework\\Lib\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
			}
		else if(broswername.equalsIgnoreCase("firefox")){
		     System.setProperty("webdriver.gecko.driver", "E:\\practice_selenium_Framework\\Lib\\geckodriver.exe");
		     driver=new FirefoxDriver(); 
	  }
	  else if(broswername.equalsIgnoreCase("ie")){
		  System.setProperty("webdriver.ie.driver", "E:\\practice_selenium_Framework\\Lib\\IEDriverServer.exe");
		  driver = new InternetExplorerDriver();
		  }
	 driver.get(url);
	 driver.manage().window().maximize();
	 return driver;
		
	}
	public static WebDriver getdriver() {
		return driver;
	}
	public static void closebrowser() {
		driver.quit();
	}

}
