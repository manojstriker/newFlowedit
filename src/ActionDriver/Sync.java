package ActionDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Sync extends UTF {
	 
	  public static void  implicitwait(int timesec) {
		  driver.manage().timeouts().implicitlyWait(timesec, TimeUnit.SECONDS);
	  }
	  public static void procesWait(int milleseconds) {
		  try {
			Thread.sleep(milleseconds);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	  }
	  public static void visabilityofElementLocated(String attributeType, String attributeValue,int timesec){
	      WebDriverWait wit=new WebDriverWait(driver, timesec);
		  wit.until(ExpectedConditions.visibilityOfElementLocated(locator(attributeType,attributeValue)));
	    }
	  public static void presenceofElementLocated(String attributeType, String attributeValue,int timesec){
			WebDriverWait wit=new WebDriverWait(driver, timesec);
			wit.until(ExpectedConditions.presenceOfElementLocated(locator(attributeType, attributeValue)));
	    }
	  public static void elementToBeClickable(String attributeType, String attributeValue,int timesec){
		    WebDriverWait wit=new WebDriverWait(driver, timesec);
		    wit.until(ExpectedConditions.elementToBeClickable(locator(attributeType, attributeValue)));
		}
	  public static boolean elementToBeSelected(String attributeType, String attributeValue,int timesec){
			WebDriverWait wit=new WebDriverWait(driver, timesec);
			return wit.until(ExpectedConditions.elementToBeSelected(locator(attributeType, attributeValue)));
		}
	  public static boolean invisibilityOfElementLocated(String attributeType, String attributeValue,int timesec){
			WebDriverWait wit=new WebDriverWait(driver, timesec);
			return wit.until(ExpectedConditions.invisibilityOfElementLocated(locator(attributeType, attributeValue)));
		}
	  public static boolean invisibilityOfElementWithText(String attributeType, String attributeValue,int timesec,String text){
			WebDriverWait wit=new WebDriverWait(driver, timesec);
			return wit.until(ExpectedConditions.invisibilityOfElementWithText(locator(attributeType, attributeValue), text));
		}
	  public static boolean textToBePresentInElementLocated(String attributeType, String attributeValue,int timesec,String text){
			WebDriverWait wit=new WebDriverWait(driver, timesec);
			return wit.until(ExpectedConditions.textToBePresentInElementLocated(locator(attributeType, attributeValue), text));
		}
	  public static WebDriver frameToBeAvailableAndSwitchToitlocator(String attributeType, String attributeValue,int timesec){
	    	WebDriverWait wit=new WebDriverWait(driver, timesec);
	    	return	wit.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(findElement(attributeType, attributeValue)));
	    }
}
