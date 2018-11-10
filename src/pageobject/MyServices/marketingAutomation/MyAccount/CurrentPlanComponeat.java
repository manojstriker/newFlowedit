package pageobject.MyServices.marketingAutomation.MyAccount;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.UTF;
import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class CurrentPlanComponeat {

		public static	XmlReader readData;
		public static DataSheet datssheet;
		public CurrentPlanComponeat(String filename,String className) throws Exception {
			  UTF.callLog4j(className);
			  readData=new XmlReader(filename);
		      }
		public CurrentPlanComponeat(String xmlfilename,String className,String excelFile) throws Exception {
			  UTF.callLog4j(className);
			  readData=new XmlReader(xmlfilename);
			  datssheet=new DataSheet(excelFile);
			  }
		public CurrentPlanComponeat(String className) throws Exception {
			  UTF.callLog4j(className);
		      }
	    public void MyAccount() {
			  UTF.clickelement("xpath", "//*[text()='My Account']");
			  Log4j.infoLog("click the Myaccount ");
	          }
	    
       public void CurrentPlan() {
    	   UTF.clickelement("xpath", "//*[text()='Current Plan']");
    	   Log4j.infoLog("click the current plan  ");
       }
	   public void Mouv() {
		 UTF.javaScriptScroolhorizontally("xpath","//*[text()='Actions']");
	     }
		
		
	    public void current_data_verifying(String datasheetname) throws Exception {
	    	String currentplanTablefeatures=readData.getdata(datasheetname, "currentplanTablefeatures");
	    	String currentplanData=readData.getdata(datasheetname, "currentplanData");
			int count=0;
	    	LinkedHashMap<String,String> linkedhashmap=new LinkedHashMap<String,String>();
	    	List<WebElement>currentplanTablefeaturess_webelement=UTF.findelements("xpath", "//*[@class='table smart-table']/thead/tr/th");
	 	    ArrayList<String>currentplanTablearry=new ArrayList<String>();
	 	    for(int i=0;i<currentplanTablefeaturess_webelement.size();i++) {
	 	    	currentplanTablearry.add(currentplanTablefeaturess_webelement.get(i).getText().trim());
	 		List<WebElement>currentplaninformation=UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td");
	 		for(int j=count;j<currentplaninformation.size();) {
	 			linkedhashmap.put(currentplanTablefeaturess_webelement.get(i).getText().trim(), currentplaninformation.get(j).getText().trim());
	 	    count++;
	 		break;
	 		}
	 		}
	 	    
	 	    int sum=0;
	 	    String[] currentplanTablefeaturesArry=currentplanTablefeatures.split("/");
		    for(int i=0;i<currentplanTablefeaturesArry.length;i++) {
		    	if(linkedhashmap.keySet().contains(currentplanTablefeaturesArry[i])) {
		    	Log4j.infoLog(currentplanTablefeaturesArry[i]+"---- feture is present in table");
		    	}
		   else {
		    	Log4j.errorLogLog(currentplanTablefeaturesArry[i]+"-----some  feture is present in table");
		    	}
		    String[] currentplansArry=currentplanData.split("/");
		    for(int j=sum;j<currentplansArry.length;) {
		     if(linkedhashmap.values().contains(currentplansArry[j])) {
		        Log4j.infoLog(currentplansArry[j]+"---- data is present in table");
		        }
		   else{
			    Log4j.errorLogLog(currentplansArry[j]+"-----some  data is present in table");
			    }
		         sum++;
		    	 break;
		     }
		     }
		     }
	  
	    
	   public void Action_numberDetiles(String dataSheetName) throws Exception {
		   String company=readData.getdata(dataSheetName, "company");
		   String planname=readData.getdata(dataSheetName, "planname");
		   
		 List<WebElement>companyname=UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td[2]");
		 for(int i=0;i<companyname.size();i++) {
		    	if( companyname.get(i).getText().trim().equals(company)) {
		    		 List<WebElement>PlanName=UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td[3]");
		    		 for(int j=0;i<PlanName.size();j++) {
		    			 if(PlanName.get(j).getText().trim().equals(planname)) {
		    				 UTF.clickelement("xpath", "//td[text()='"+planname+"']/following::td[11]/a");
		    				 
		    			 }
		    			 else {
		    				 Log4j.infoLog("*********");
		    			 }
		    	          }
		    		     }
		    	 else {
					 Log4j.infoLog("***************");
				 }
	       }
		
	   }
	   
	  
	
}
