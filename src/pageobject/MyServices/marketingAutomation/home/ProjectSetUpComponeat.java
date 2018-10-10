package pageobject.MyServices.marketingAutomation.home;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.Sync;
import ActionDriver.UTF;
import utilities.ExcelReusables;
import utilities.Log4j;
import utilities.XmlReader;

public class ProjectSetUpComponeat {
	 public static	XmlReader readData;
	 
	 public ProjectSetUpComponeat (String filename,String className) throws Exception{
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
		  }
	 public ProjectSetUpComponeat (String className) throws Exception{
		  UTF.callLog4j(className);
		 }
	 
	 
	 public static void projectSetUp_smart_table_features() throws Exception {
		 String data=readData.getdata("smarttableFeature", "Features");
		 String[]  indexNames=data.split(",");
		 HashMap<String, Integer> hashmap = new  HashMap<String, Integer> ();
		 HomeComponent.clickhomebutton();
		 HomeComponent.clickProjectSetUp();
		 Sync.procesWait(2000);
		 //String featuresnames= UTF.findElement("cssSelector", ".table.smart-table").getText();
		//System.out.println(featuresnames);
	   //String xpath=UTF.findElement("xpath", "html/body/div[4]/div/table/thead/tr/th");
		 String beforexpath="html/body/div[4]/div/table/thead/tr/th[*]";
		 String affterxpath="]";
		List<WebElement> colum=UTF.findelements("xpath", "html/body/div[4]/div/table/thead/tr[1]/th[*]");
		for(int i=1;i<colum.size();i++) {
		//	String Xpaths =beforexpath+i+affterxpath;
			String columnames=colum.get(i).getText();
			//Log4j.infoLog(columnames);
		   hashmap.put(columnames, i);
		}
			for(int j=0;j<indexNames.length;j++) {
				//System.out.println(datas.);
				if(hashmap.containsKey(indexNames[j])) {
					System.out.println(indexNames[j]+"values exsit in application");
					
				}
			}
			
			//*[@id="3"]/div
			//*[@id="3"]/div/span[1]/img
			//*[@id="2"]/div/span[1]/img
			//*[@id="2"]/div/span[2]
			//*[@id="2 "]/div/span[1]/img cont
			//*[@id="2 "]/div cont
			//*[@id="3 "]/div/span[1]/img
			//*[@id="3 "]/div/span[1]/img sov
			//*[@id="1 "]/div/span[1]/img
			
		}
		
		 
	 public static void  plusbuttonIn_projucts() {
		   HomeComponent.clickhomebutton();
		   HomeComponent.clickProjectSetUp();
		   Sync.procesWait(2000); 
		   boolean disply=UTF.findElement("className", "smart-add").isDisplayed();
		   if(disply ) {
			   UTF.clickelement("className", "smart-add");
			   Log4j.infoLog("plusebutton is  working  and click on it");
			    }
		   else {
			   Log4j.infoLog("verifying_plusebutton is not working ");
		   }
	     }
	  
	public static void addcategory() {
        plusbuttonIn_projucts();
        Sync.procesWait(2000);
		
			//UTF.clickelement("cssSelector", ".modal-content");
			//Sync.procesWait(2000);
        UTF.selectByVisibleText("id", "company_id", "striker");
        Log4j.infoLog("select the company name");
		//UTF.selectByValue("id", "company_id", "125");
			//UTF.selectByValue("id", "category_type", "Traffic~Marketing Manager~59");
        Sync.procesWait(2000);
     
         UTF.inputText("xpath", "//*[@id='ProjectSetUp']/div[3]/input", "manoj");
        Log4j.infoLog("Category Name is entere");
         Sync.procesWait(2000);
         UTF.clickelement("id", "desigsubmit");
         Log4j.infoLog("click the submit");
			
		
		  
	  }
	public static void closebutton_addcategory_option() {
		addcategory();
		UTF.clickelement("className", "close");
		Sync.procesWait(2000);
		boolean category= UTF.findElement("cssSelector", ".modal-content").isDisplayed();
		if(category) {
			Log4j.infoLog("addcategory is displayed");
		}
		else {
			Log4j.infoLog("close the addcategory option");
		}
		//UTF.findElement("className", "close").click();
	}
	public static void addcategory_option_names() throws Exception {
		String optionsNames=readData.getdata("AddCatrgoty_optionNames", "Features");
		String[] split=optionsNames.split("/");
		addcategory();
		Sync.procesWait(2000);
		List<WebElement> option=UTF.findelements("xpath", ".//*[@id='ProjectSetUp']/div[*]/label");
		for(int i=0;i<option.size();i++) {
		for(String s1:split) {
			if(s1.equals(option.get(i).getText())) {
				Log4j.infoLog(option.get(i).getText()+" display on screen");
			 }	
			}
		
		}
		}
	public static void configCallFlowbutton_addcategory_option() {
		addcategory();
		boolean displayed=UTF.findElement("id", "desigsubmit").isDisplayed();	
		boolean enable=UTF.findElement("id", "desigsubmit").isEnabled();  
		if(displayed && enable) {
			Log4j.infoLog("configCallFlowbutton is working");
		}
		else {
			Log4j.infoLog("configCallFlowbutton is  Not working");
		}
	}
		
	public static void projuctSetUpCreation() {
		 HomeComponent.clickhomebutton();
		 Sync.procesWait(2000);
		 HomeComponent.clickProfile();
		 Sync.procesWait(2000);
		// UTF.clickelement("partialLinkText", "Flow Edit");
		 UTF.mouseover("xpath", "/html/body/div[4]/div/table/tbody/tr/td[6]/a[1]");
		//UTF.clickelement("xpath", " /html/body/div[4]/div/table/tbody/tr/td[6]/a[1]");
		Log4j.infoLog("click the flow edit");
	}
		
		
		
		

	
	

	 
}
