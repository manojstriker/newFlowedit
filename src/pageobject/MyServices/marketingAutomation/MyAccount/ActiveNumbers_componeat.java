package pageobject.MyServices.marketingAutomation.MyAccount;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.UTF;
import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class ActiveNumbers_componeat {
	public static	XmlReader readData;
	public static DataSheet datssheet;
	public ActiveNumbers_componeat(String filename,String className) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
	      }
	public ActiveNumbers_componeat(String xmlfilename,String className,String excelFile) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(xmlfilename);
		  datssheet=new DataSheet(excelFile);
		  }
	public ActiveNumbers_componeat(String className) throws Exception {
		  UTF.callLog4j(className);
	      }
    public void MyAccount() {
		  UTF.clickelement("xpath", "//*[text()='My Account']");
		  Log4j.infoLog("click the Myaccount ");
          }
    
   public void click_ActiveNumbers() {
	   UTF.clickelement("xpath", "//*[text()='Active Numbers']");
	   Log4j.infoLog("click_ActiveNumbers");
      }
   public void ActiveNumbersDetails_verifying(String datasheetname) throws Exception {
   	String ActiveNumbersDetailsfeatures=readData.getdata(datasheetname, "currentplanTablefeatures");
   	String ActiveNumbersDetailsData=readData.getdata(datasheetname, "currentplanData");
		int count=0;
   	LinkedHashMap<String,String> linkedhashmap=new LinkedHashMap<String,String>();
   	List<WebElement>ActiveNumbersDetailsfeatures_webelement=UTF.findelements("xpath", "//*[@class='table smart-table']/thead/tr/th");
	    ArrayList<String>ActiveNumbersDetailsTablearry=new ArrayList<String>();
	    for(int i=0;i<ActiveNumbersDetailsfeatures_webelement.size();i++) {
	    	ActiveNumbersDetailsTablearry.add(ActiveNumbersDetailsfeatures_webelement.get(i).getText().trim());
		List<WebElement>ActiveNumbersData=UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td");
		for(int j=count;j<ActiveNumbersData.size();) {
			linkedhashmap.put(ActiveNumbersDetailsfeatures_webelement.get(i).getText().trim(), ActiveNumbersData.get(j).getText().trim());
	    count++;
		break;
		}
		}
	    
	    int sum=0;
	    String[] ActiveNumbersDetailsfeaturesArry=ActiveNumbersDetailsfeatures.split("/");
	    for(int i=0;i<ActiveNumbersDetailsfeaturesArry.length;i++) {
	    	if(linkedhashmap.keySet().contains(ActiveNumbersDetailsfeaturesArry[i])) {
	    	Log4j.infoLog(ActiveNumbersDetailsfeaturesArry[i]+"---- feture is present in table");
	    	}
	   else {
	    	Log4j.errorLogLog(ActiveNumbersDetailsfeaturesArry[i]+"-----some  feture is present in table");
	    	}
	    String[] ActiveNumbersDetailsDataArry=ActiveNumbersDetailsData.split("/");
	    for(int j=sum;j<ActiveNumbersDetailsDataArry.length;) {
	     if(linkedhashmap.values().contains(ActiveNumbersDetailsDataArry[j])) {
	        Log4j.infoLog(ActiveNumbersDetailsDataArry[j]+"---- data is present in table");
	        }
	   else{
		    Log4j.errorLogLog(ActiveNumbersDetailsDataArry[j]+"-----some  data is present in table");
		    }
	         sum++;
	    	 break;
	     }
	     }
	     }
}
