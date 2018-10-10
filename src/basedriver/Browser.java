package basedriver;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import utilities.PropertiesReusabuls;

public class Browser {
	static WebDriver driver;
	
	public static WebDriver startBrowser() throws IOException {
		PropertiesReusabuls properies=new PropertiesReusabuls(System.getProperty("user.dir")+"//src//Configurations//config.properties");
				//System.getProperty("user.dir")+"\\src\\Configurations\\config.properties");
		String browser=properies.getProperty("Browser");
		String url=properies.getProperty("URL");
		return startBrowser(browser, url);
	}
	public static WebDriver startBrowser(String broswername,String url) {
		
			if(broswername.equalsIgnoreCase("Chrome"))
			{
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//lib//chromedriver.exe");
			     DesiredCapabilities cap=new DesiredCapabilities().chrome();
				 cap.setJavascriptEnabled(true);
				 driver=new ChromeDriver(cap);
			}
			else if(broswername.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//lib//geckodriver.exe");
				driver=new FirefoxDriver();
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
