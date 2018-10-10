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
		
    public static void clickFlowEdit() {
      HomeComponent.clickhomebutton();
      Sync.procesWait(2000);
      HomeComponent.clickProjectSetUp();
      Sync.procesWait(2000);
     // galaxy-topslide
      
      UTF.clickelement("xpath", "/html/body/div[4]/div/table/tbody/tr/td[6]/a[1]");
      
      }
    public static void clickOn_ProjectManagement_upperbord() {
    	clickFlowEdit();
    	Sync.procesWait(3000);
    	UTF.clickelement("id", "flow_name,append_values_2,MARKETING_PROJECT_MANAGEMENT");
    	Log4j.infoLog("click on the ProjectManagement_upperbord");
    	
    }
    public static void clickOn_ProjectManagement_delete() {
    	Sync.procesWait(3000);
    	UTF.clickelement("xpath", ".//*[@id='1']/div/button[1]");
    	Sync.procesWait(2000);
    	UTF.clickelement("partialLinkText", "Yes");
    	Log4j.infoLog("delete ProjectManagement" );
    }
	public static void clickOn_projuctManagement_lowerbord() {
		Sync.procesWait(3000);
		UTF.clickelement("xpath", "//*[contains(@title, 'Project Management')]");
		Log4j.infoLog("clickOn_projuctManagement_lowerbord");
	}
    public static void ClickOn__userprivilleges_Upperbord() {
    	Sync.procesWait(3000);
    	UTF.clickelement("id", "append_values_2,append_values_12,MARKETING_USER_ROLES");
    	Log4j.infoLog("ClickOn__userprivilleges_Upperbord");
    }
    public static void ClickOn__userprivilleges_lowerbord() {
    	Sync.procesWait(3000);
    	UTF.clickelement("xpath", ".//*[@id='1' ]/div");
    	Log4j.infoLog("ClickOn__userprivilleges_lowerbord");
    }
    
   
	
     public static void ClickOn_userPrivilleges_Editoption() {
    	 Sync.procesWait(3000);
    	 //List<WebElement> elements=UTF.findelements("xpath", ".//*[@id='MARKETING_USER_ROLES']");
    	// UTF.mouseover("xpath", "//*[contains(@title, 'edit')]");
    	UTF.clickelement("xpath", ".//*[@id='MARKETING_USER_ROLES' and  @type='button']");
    	 Sync.procesWait(3000);
    	//String s=UTF.findElement("cssSelector", ".side-frame-head").getText();
       // System.out.println(s);
    	Log4j.infoLog("ClickOn_userPrivilleges_Editoption");
     }
     public static void clickOn_USERS_Upperbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("id", "append_values_2,append_values_13,MARKETING_USERS");
    	 Log4j.infoLog("clickon_USERS_Upperbord");

     }
     public static void clickOn_User_Lowerbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", ".//*[@id='2' ]/div");
    	 Log4j.infoLog("clickOn_User_Lowerbord");
     }
     public static void clickOn_CXO_Upperbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("id", "append_values_13,append_values_19,MARKETING_CXO");
    	 Log4j.infoLog("clickOn_CXO_Upperbord");
     }
    
    public static void clickOn_CXO_Lowerbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", "//*[contains(@title, 'CXO')]");
    	 Log4j.infoLog("clickOn_CXO_Lowerbord");
    	 }

    public static void clickOn_CXO_Editoption() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", ".//*[@id='MARKETING_CXO' and @type='button']");
    	 Log4j.infoLog("clickOn_CXO_Editoption");
    	
    }
    public static void clickOn_Manager_Upperbord() {
   	 Sync.procesWait(3000);
   	 UTF.clickelement("id", "append_values_13,append_values_20,MARKETING_USER_MANAGER");
   	 Log4j.infoLog("clickOn_Manager_Upperbord");
    }
   
   public static void clickOn_Manager_Lowerbord() {
   	 Sync.procesWait(3000);
   	 UTF.clickelement("xpath", "//*[contains(@title, 'Manager')]");
   	 Log4j.infoLog("clickOn_Manager_Lowerbord");
   	 }

   public static void clickOn_Manager_Editoption() {
   	 Sync.procesWait(3000);
   	 UTF.clickelement("xpath", ".//*[@id='MARKETING_USER_MANAGER' and @type='button']");
   	 Log4j.infoLog("clickOn_Manager_Editoption");
   	
   }
   public static void clickOn_MARKETING_PROJECT_SETTINGS_Upperbord() {
		Sync.procesWait(3000);
		 UTF.clickelement("id", "append_values_2,append_values_14,MARKETING_PROJECT_SETTINGS");
		Log4j.infoLog("clickOn_MARKETING_PROJECT_SETTINGS_Upperbord");
	}
   public static void ClickOn_MARKETING_PROJECT_SETTINGSs_Lowerbord() {
   	Sync.procesWait(3000);
    UTF.clickelement("xpath", "//*[contains(@title, 'Template Settings')]");
  	 Log4j.infoLog("ClickOn_MARKETING_PROJECT_SETTINGSs_Lowerbord");
   }
}
