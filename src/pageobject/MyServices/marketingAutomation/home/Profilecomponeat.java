package pageobject.MyServices.marketingAutomation.home;

import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.Sync;
import ActionDriver.UTF;
import utilities.XmlReader;

public class Profilecomponeat {
	
	XmlReader readData;
	 public Profilecomponeat (String filename,String className) throws Exception{
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
		 }
	 public Profilecomponeat (String className) throws Exception{
		  UTF.callLog4j(className);
		 }
	 public static void verifying_profilefileuploading() {
		   HomeComponent.clickProfile();
		   UTF.clickelement("partialLinkText", "Upload KYC Documents");
		  UTF.clickelement("xpath", "//*[@id='userfile3']/following::div[1]");
		  Sync.procesWait(1600);
		   UTF.clickEneter();
		 // UTF.clickinputText("xpath", "//*[@id='userfile1']/following::div[1]","/home/striker/SamplePNGImage_100kbmb.png");
	
	   }
}
