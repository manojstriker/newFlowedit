package pageobject.MyServices.marketingAutomation.Marketing;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.UTF;
import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class EmailTemplatesComponeat {
	public static	XmlReader readData;
	public static DataSheet datssheet;
	public EmailTemplatesComponeat(String filename,String className) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
	      }
	public EmailTemplatesComponeat(String xmlfilename,String className,String excelFile) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(xmlfilename);
		  datssheet=new DataSheet(excelFile);
		  }
	public EmailTemplatesComponeat(String className) throws Exception {
		  UTF.callLog4j(className);
	      }
    public void Marketing() {
		  UTF.clickelement("xpath", "//*[text()='Marketing']");
		  Log4j.infoLog("click the Marketing ");
        }
  
    public void emailTemplates(){
	      UTF.clickelement("xpath", "//*[text()='Email Templates']");
	   if(UTF.findElement("xpath", "//*[@class='smarttable-head']").getText().equals("Email Templates")) {
		  Log4j.infoLog("Email Templates is click ");
		  }
	 else{
		   Log4j.infoLog("email Template click  but text not present");
	       }
	      }
    
    
    public void emaileTemplate(String datasheetname) throws Exception {
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
    
    public void emialTemplate_View(String emailTemplatename) {
    	UTF.clickelement("xpath", "//*[text()='"+emailTemplatename+"']/following::td[1]/a");
    	Log4j.infoLog("emailTempalte ViewClick");
    }
    public void emialTemplate_View_close() {
    	UTF.SwitchToFrameByWebElement("id", "myid");
    	UTF.javaScriptscrooldown150();
    	UTF.clickelement("xpath", ".//*[@id='kyc-view']/following::button[1]");
    	Log4j.infoLog("close the email template");
    }
    
   public void deleteEmailTemplate (String emailTemplatename) {
	   UTF.clickelement("xpath", "//*[text()='"+emailTemplatename+"']/following::td[1]/a");
	   Log4j.infoLog("clcik deletebutton the email template");
	   UTF.clickelement("xpath", "//*[@class='jconfirm-buttons']/button[1]");
	   Log4j.infoLog("click the confrom button to delete email template");
   }
    
    
    
}

