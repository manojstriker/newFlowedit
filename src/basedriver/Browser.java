package basedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	static WebDriver driver;
	public static WebDriver startBrowser(String broswername,String url) {
		
			if(broswername.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Lib//chromedriver.exe");
				driver=new InternetExplorerDriver();
			}
			else if(broswername.equalsIgnoreCase(" Firefox"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Lib//geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if (broswername.equalsIgnoreCase("Chrome")){
				 System.setProperty("webdriver.chrom.driver", System.getProperty("user.dir")+"//lib//chromedriver.exe");
			      driver=new ChromeDriver();
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
