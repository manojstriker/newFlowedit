package pageobject.MyServices.marketingAutomation.MyAccount;

import ActionDriver.UTF;
import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class ActiveUsers_componeat {
	public static	XmlReader readData;
	public static DataSheet datssheet;
	public ActiveUsers_componeat(String filename,String className) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
	      }
	public ActiveUsers_componeat(String xmlfilename,String className,String excelFile) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(xmlfilename);
		  datssheet=new DataSheet(excelFile);
		  }
	public ActiveUsers_componeat(String className) throws Exception {
		  UTF.callLog4j(className);
	      }
    public void MyAccount() {
		  UTF.clickelement("xpath", "//*[text()='My Account']");
		  Log4j.infoLog("click the Myaccount ");
          }
    
   public void click_ActiveUsers() {
	   UTF.clickelement("xpath", "//*[text()='Active Users']");
	   Log4j.infoLog("click_ActiveUsers");
      }
}
