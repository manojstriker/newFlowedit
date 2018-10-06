package pageobject.MyServices.marketingAutomation.home;

import java.util.List;
import org.openqa.selenium.WebElement;

import ActionDriver.Sync;
import ActionDriver.UTF;
import utilities.Log4j;
import utilities.XmlReader;

public class HomeComponent {
	
	XmlReader readData;
	public HomeComponent(String filename,String className) throws Exception{
      UTF.callLog4j(className);
	  readData=new XmlReader(filename);
		//Browser.getdriver();
		
	}
     
      public static void clickhomebutton() {
    	   Sync.procesWait(1600);
    	   UTF.clickelement("partialLinkText", "Home");	 
      }
      
       public static void clickDashBord() {
    	   UTF.clickelement("partialLinkText", "Dashboard");
    	   //Log4j.infoLog("clicking the dashbord");
       }
       public static void clickProjectSetUp() {
    	   UTF.clickelement("partialLinkText", "Project");
       }
       public static void clickChat() {
    	   Sync.visabilityofElementLocated("partialLinkText", "Chat", 30);
    	   UTF.clickelement("partialLinkText", "Chat");
    	   UTF.switchtoDefaletwindow();
       }
      public static void clickReports() {
    	  Sync.visabilityofElementLocated("partialLinkText", "Chat", 30);
    	  UTF.clickelement("partialLinkText", "Reports");
      }
      public static void clickProfile() {
    	  Sync.visabilityofElementLocated("partialLinkText", "Chat", 30);
    	  UTF.clickelement("partialLinkText", "Profile");
      }
      
       
}
