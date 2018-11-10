package pageobject.MyServices.marketingAutomation.Marketing;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.UTF;
import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class VirtualNumbersComponeat {
	public static	XmlReader readData;
	public static DataSheet datssheet;
	public VirtualNumbersComponeat(String filename,String className) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
	      }
	public VirtualNumbersComponeat(String xmlfilename,String className,String excelFile) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(xmlfilename);
		  datssheet=new DataSheet(excelFile);
		  }
	public VirtualNumbersComponeat(String className) throws Exception {
		  UTF.callLog4j(className);
	      }
    public void Marketing() {
		  UTF.clickelement("xpath", "//*[text()='Marketing']");
		  Log4j.infoLog("click the Marketing ");
        }
  
    public void VirtualNumbers(){
	       UTF.clickelement("xpath", "//*[text()='Virtual Numbers']");
	    if(UTF.findElement("xpath", "//*[@class='smarttable-head']").getText().equals("Virtual Numbers")) {
		  Log4j.infoLog("LandingPages Templates is click ");
		  }
	else  {
		   Log4j.infoLog("LandingPages Template click  but text not present");
	      }
	      }
    
    
    public void VirtualNumbersTemplatefeatures(String datasheetname) throws Exception {
          String currentplanTablefeatures=readData.getdata(datasheetname, "currentplanTablefeatures");
          List<WebElement>currentplanTablefeaturess_webelement=UTF.findelements("xpath", "//*[@class='table smart-table']/thead/tr/th");
          ArrayList<String>currentplanTablearry=new ArrayList<String>();
    	  for(int i=0;i<currentplanTablefeaturess_webelement.size();i++) {
    	  currentplanTablearry.add(currentplanTablefeaturess_webelement.get(i).getText().trim());
    	  }
    	String[] currentplanTablefeaturesArry=currentplanTablefeatures.split("/");
		    for(int i=0;i<currentplanTablefeaturesArry.length;i++) {
		    	if(currentplanTablearry.contains(currentplanTablefeaturesArry[i])) {
		    	Log4j.infoLog(currentplanTablefeaturesArry[i]+"---- feture is present in table");
		    	}
		   else {
		    	Log4j.errorLogLog(currentplanTablefeaturesArry[i]+"-----some  feture is present in table");
		    	}
    		    }
    	        }
    
      public void VirtualNumbersTemplate_View(String virtualnumbe) {
    	UTF.clickelement("xpath", "//*[text()='"+virtualnumbe+"']/following::td[1]/a");
    	Log4j.infoLog("LandingPageName ViewClick");
        }
       public void emialTemplate_View_close() {
    	UTF.SwitchToFrameByWebElement("id", "myid");
    	UTF.javaScriptscrooldown150();
    	UTF.clickelement("xpath", ".//*[@id='kyc-view']/following::button[1]");
    	Log4j.infoLog("close the LandingPageName view");
      }
    
   public void deleteLandingPageNameTemplate (String LandingPageName) {
	   UTF.clickelement("xpath", "//*[text()='"+LandingPageName+"']/following::td[1]/a");
	   Log4j.infoLog("clcik deletebutton the LandingPageName template");
	   UTF.clickelement("xpath", "//*[@class='jconfirm-buttons']/button[1]");
	   Log4j.infoLog("click the confrom button to delete LandingPageName template");
   }
}
