package ActionDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import basedriver.Browser;
import utilities.Log4j;
import utilities.PropertiesReusabuls;
    public class UTF extends Browser {
	static WebDriver driver=Browser.getdriver();
	
	  public static WebElement findElement(String attributeType, String attributeValue ) 
	  {
			return	driver.findElement(locator(attributeType,attributeValue));
		
	  }
	  public static List<WebElement> findelements(String attributeType, String attributeValue) {
		
			return	driver.findElements(locator(attributeType,attributeValue));
		
	}
	  public static By locator(String attributeType, String attributeValue){
		if(attributeType.equalsIgnoreCase("id")) 
	    {
	      return By.id(attributeValue);
	    }
		else if(attributeType.equalsIgnoreCase("name")) {
			return By.name(attributeValue);
		}
		else if(attributeType.equalsIgnoreCase("className")) {
			return By.className(attributeValue);
		}
		else if(attributeType.equalsIgnoreCase("xpath")) {
			return By.xpath(attributeValue);
		}
		else if(attributeType.equalsIgnoreCase("cssSelector")) {
			return By.cssSelector(attributeValue);
		}
		else if(attributeType.equalsIgnoreCase("partialLinkText")) {
			return By.partialLinkText(attributeValue);
		}
		else if(attributeType.equalsIgnoreCase("linkText")) {
			return By.linkText(attributeValue);
		}
		else if(attributeType.equalsIgnoreCase("tagName")) {
			return By.tagName(attributeValue);
		}
		
		return null;
        }
	  public static void inputText(String attributeType,String attributeValue,String data) {
		findElement(attributeType, attributeValue).clear();
		findElement(attributeType, attributeValue).sendKeys(data);
		}
	  public static void clickinputText(String attributeType,String attributeValue,String data) {
		  findElement(attributeType, attributeValue).sendKeys(data);
		  
	  }
	  public static void cleardata(String attributeType,String attributeValue,String data) {
		findElement(attributeType, attributeValue).clear();
		}
	  public static String getText(String attributeType,String attributeValue) {
		WebElement we=findElement(attributeType, attributeValue);
		return we.getText();
	 }
	  public static String getTagName(String attributeType,String attributeValue) {
			WebElement we=findElement(attributeType, attributeValue);
			return we.getTagName();
		 }
	  public static String getTitle()  {
	      String text = driver.getTitle();
	      return text;
	    }
	  public static String getpageSource() {
		 return driver.getPageSource();
	  }
//*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*//
	
	  public static void selectByVisibleText(String attributeType,String attributeValue,String text) {
		Select select=new Select(findElement(attributeType, attributeValue));
		select.selectByVisibleText(text);
	   }
	  public static void selectByValue(String attributeType,String attributeValue,String value) {
		 Select select=new Select(findElement(attributeType, attributeValue));
		 select.selectByValue(value);
	   }
	  public static void selectByIndex(String attributeType,String attributeValue,int index) {
		 Select select=new Select(findElement(attributeType, attributeValue));
		 select.selectByIndex(index);
	  }
	  public static void deselectByVisibleText(String attributeType,String attributeValue,String text) {
			Select select=new Select(findElement(attributeType, attributeValue));
			select.deselectByVisibleText(text);
		   }
	  public static void deselectByValue(String attributeType,String attributeValue,String value) {
			 Select select=new Select(findElement(attributeType, attributeValue));
			 select.deselectByValue(value);
		 }
	  public static void deselectByIndex(String attributeType,String attributeValue,int index) {
			 Select select=new Select(findElement(attributeType, attributeValue));
			 select.deselectByIndex(index);
		 }
	  public static List<WebElement>  getOptions(String attributeType,String attributeValue) {
		   Select select=new Select(findElement(attributeType, attributeValue));
		   return select.getOptions();
		  }
	  public static boolean isMultiple(String attributeType,String attributeValue) {
		 Select select=new Select(findElement(attributeType, attributeValue));
		 return select.isMultiple();
		 }
	  public static void deselectAll(String attributeType,String attributeValue) {
		 Select select=new Select(findElement(attributeType, attributeValue));
		  select.deselectAll();
	   }
	  public static List<WebElement> getAllSelectedOptions(String attributeType,String attributeValue) {
		 
		  Select select=new Select(findElement(attributeType, attributeValue));
		 return select.getAllSelectedOptions();
		
	   }
	  public static WebElement getFirstSelectedOption(String attributeType,String attributeValue) {
		 Select select=new Select(findElement(attributeType, attributeValue));
	     return select.getFirstSelectedOption();
	   } 
 
//*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*//
	  
	  public static  void mouseover(String attributeType,String attributeValue) {
		  Actions action=new Actions(driver);
		  WebElement element=findElement(attributeType, attributeValue);
		  action.moveToElement(element).build().perform();
	  }
	  public static  void mouseoversendData(String attributeType,String attributeValue,String data) {
		  Actions action=new Actions(driver);
		  WebElement element=findElement(attributeType, attributeValue);
		  action.moveToElement(element).sendKeys(data).build().perform();
	  }
	  public static void rightClickOnElement(String attributeType,String attributeValue) {
		  Actions action=new Actions(driver);
		  WebElement element=findElement(attributeType, attributeValue);
		  action.contextClick(element).build().perform();
	  }
	  public static void rightClick() {
		  Actions action=new Actions(driver);
		  action.contextClick().build().perform();
	  }
	  public static void clickelement(String attributeType,String attributeValue) {
		  Actions action=new Actions(driver);
		  WebElement element=findElement(attributeType, attributeValue);
		  action.click(element).build().perform();
	  }
	  public static void clickEneter() {
		  Actions action=new Actions(driver);
		  action.sendKeys(Keys.ENTER).build().perform();
		  
	  }
	  public static void doubleclick(String attributeType,String attributeValue) {
		  Actions action=new Actions(driver);
		  action.doubleClick(findElement(attributeType,attributeValue)).build().perform();
	  }
	  public static void takeScrenShort(String filepath) {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File(filepath+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  }
	  
//*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*//
	  
	  public static void SwitchFrameByindex(int index) {
		  driver.switchTo().frame(index);
	  }
	  public static void SwitchToFrameByWebElement(String attributeType,String attributeValue) {
		   WebElement element=findElement(attributeType, attributeValue);
		   driver.switchTo().frame(element);
	  }
	  public static void SwitchToFrameByName(String name) {
		  driver.switchTo().frame(name);
	  }
	  public static void SwitchToDefaltFrame() {
		  driver.switchTo().defaultContent();
	  }
	  public static int totalFrmaes() {
          List<WebElement> elements=driver.findElements(By.tagName("frame"));	
          int count=elements.size();
          return count;
	  }
	  public static  void getfaremenameoOrId() {
		  List<WebElement> elements=driver.findElements(By.tagName("frame"));
		  System.out.println("No.Of frames "+elements.size());
		  for(WebElement frames:elements) {
			  System.out.println("frmae id"+frames.getAttribute("id"));
			  System.out.println("frame Name"+frames.getAttribute("name"));
			  
		  }
		  }
	 
//**<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
	  
	  public static String getCurrentWindow() {
		  String window=driver.getWindowHandle();
		  return  window;
	  }
	  public static Set<String> getWindowhandiles(){
		  Set<String> windos=driver.getWindowHandles();
		  return windos;
	  }
	  public static void SwitchtoSecondWindow() { 
		  Iterator iterator=getWindowhandiles().iterator();
		  while(iterator.hasNext()) {
			  String secondwindow=(String) iterator.next();
			  System.out.println("second window is"+secondwindow);
			  if(!secondwindow.equalsIgnoreCase(getCurrentWindow())) {
				  driver.switchTo().window(secondwindow);
			  }
		    }
		
	       }
	  public static void switchtowindowName(String WindowName) {
			 driver.switchTo().window(WindowName) ;
		 }
       public static void switchtoDefaletwindow() {
    	   driver.switchTo().defaultContent();
       }
//**<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>**//
	  public static void alertAcept() {
		  Alert alert=driver.switchTo().alert();
		  alert.accept();
	  }
	  public static void alertDismiss() {
		  Alert alert=driver.switchTo().alert();
		  alert.dismiss();
	  }
	  public static String getTextFromAlert() {
		  Alert alert=driver.switchTo().alert();
		  String data=alert.getText();
		  return data;
	  }
	  public static void sendDataToAlert(String data) {
		  Alert alert=driver.switchTo().alert();
		  alert.sendKeys(data); 
	  }
	  
//**<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<><<>><<<>><><><>><><<><><>//  
	  public static void javaScriptscrooldown150() {
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("window.scrollBy(0.150)");
	    	
	    }
	
	  public static void  javaScriptclick(String attributeType, String attributeValue) {
       WebElement element =findElement(attributeType,attributeValue);
       JavascriptExecutor executor = (JavascriptExecutor)driver;
       executor.executeScript("arguments[0].click();", element);
	  }
	  /*
	  public static void javaScriptSchroolDown(findElement(String attributeType, String attributeValue ) ) {
		  JavaScriptException js = (JavaScriptException)driver;
		  js.executeScript("history.go(0)");
	  }
	  */
	  
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
	  public static void callLog4j(String className) throws Exception {
		  PropertiesReusabuls properies=new PropertiesReusabuls(System.getProperty("user.dir")+"//src//utilities//Log4j.properties");
		  System.out.println(properies.getProperty("log4j.appender.FILE.File"));
		  properies.setProperty("log4j.appender.FILE.File", ".//src//TestLogs//"+className+".log");
		  Log4j log=new Log4j();
	  }
	  }


