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
		 String[]  datas=data.split(",");
		 HashMap<String, Integer> hashmap = new  HashMap<String, Integer> ();
		 HomeComponent.clickhomebutton();
		 HomeComponent.clickProjectSetUp();
		 Sync.procesWait(2000);
		//String featuresnames= UTF.findElement("cssSelector", ".table.smart-table").getText();
		//System.out.println(featuresnames);
	  //String xpath=UTF.findElement("xpath", "html/body/div[4]/div/table/thead/tr/th");
		String beforexpath="html/body/div[4]/div/table/thead/tr/th[";
		String affterxpath="]";
		List<WebElement> colum=UTF.findelements("xpath", "html/body/div[4]/div/table/thead/tr/th");
		for(int i=1;i<colum.size();i++) {
			String Xpaths =beforexpath+i+affterxpath;
			String columnames=UTF.findElement("xpath", Xpaths).getText();
			//Log4j.infoLog(columnames);
		   hashmap.put(columnames, i);
			
			for(int j=0;j<datas.length;j++) {
				//System.out.println(datas.);
				if(hashmap.containsKey(data.charAt(i))) {
					System.out.println("eqlual");
					
				}
			}
			
			
		}
		
		 }
	 public static void  plusbuttonIn_projucts() {
		   HomeComponent.clickhomebutton();
		   HomeComponent.clickProjectSetUp();
		   Sync.procesWait(1600); 
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
		boolean category= UTF.findElement("cssSelector", ".modal-content").isDisplayed();
		if(category) {
			Log4j.infoLog("addcategory is displayed");
		}
		else {
			Log4j.infoLog("addcategory is Not displayed");
		}
		  
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
		
		
		
		
		
		

	
	

	 
}
