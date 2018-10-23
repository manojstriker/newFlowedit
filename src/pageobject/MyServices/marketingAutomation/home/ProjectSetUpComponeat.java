package pageobject.MyServices.marketingAutomation.home;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.common.base.Utf8;

import ActionDriver.Sync;
import ActionDriver.UTF;

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
	  
	public static  void addcategory() {
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
	public  void configCallFlowbutton_addcategory_option() {
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
		
    public  void clickFlowEdit() {
      HomeComponent.clickhomebutton();
      Sync.procesWait(2000);
      HomeComponent.clickProjectSetUp();
      Sync.procesWait(2000);
      UTF.clickelement("xpath", "html/body/div[3]/div/table/tbody/tr/td[6]/a[1]");
      Log4j.infoLog(" clickFlowEdit buttion");
     List<WebElement> projects= UTF.findelements("CSSSelector", ".galaxy-slide.scrollbar.gxyleft_450px");
   
     for(WebElement projectsText: projects) {
    	 if( projectsText.getText().equals("Contacts")) {
    		 Log4j.infoLog(" FlowEdit buttion managers working as per excepet ");
    	}
     }
    
      }
    public   void clickOn_ProjectManagement_upperbord() {
    	Sync.procesWait(4000);
    	UTF.clickelement("id", "flow_name,append_values_2,MARKETING_PROJECT_MANAGEMENT");
    	Log4j.infoLog("click on the ProjectManagement_upperbord");
    	
    }
    
    
    
    public static void delete_ProjectManagement() {
    	 Sync.procesWait(3000);
	   	 UTF.clickelement("xpath", "//li[@title='Project Management']");
	     Sync.procesWait(2000);
	     UTF.clickelement("xpath", ".//*[@id='MARKETING_PROJECT_MANAGEMENT']/following::button[1]");
    	 Log4j.infoLog("delete button clicked ");
	   	 Sync.procesWait(3000);
	   	 UTF.clickelement("partialLinkText", "Yes");
  	     Log4j.infoLog("delete ProjectManagement" );
  	    
    }
	public  void clickOn_projuctManagement_lowerbord() {
		Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Project Management')]", 40);
		UTF.clickelement("xpath", "//*[contains(@title, 'Project Management')]");
		Log4j.infoLog("clickOn_projuctManagement_lowerbord");
	}
    public  void clickOn__userprivilleges_Upperbord() {
    	Sync.elementToBeClickable("id", "append_values_2,append_values_12,MARKETING_USER_ROLES", 40);
    	UTF.clickelement("id", "append_values_2,append_values_12,MARKETING_USER_ROLES");
    	Log4j.infoLog("ClickOn__userprivilleges_Upperbord");
    }
    public  void clickOn__userprivilleges_lowerbord() {
    	Sync.elementToBeClickable("xpath", ".//*[@id='1' and contains(@title, 'User Privilleges')]/div", 40);  	
    	
    	//UTF.clickelement("id","MARKETING_USER_ROLES");
    	UTF.clickelement("xpath", ".//*[@id='1' and contains(@title, 'User Privilleges')]/div");
    	Log4j.infoLog("ClickOn__userprivilleges_lowerbord");
    }
    
   
	
     public  void clickOn_userPrivilleges_Editoption() {
    	Sync.elementToBeClickable("xpath", ".//*[@id='MARKETING_USER_ROLES' and  @type='button']", 40);  	         
    	UTF.clickelement("xpath", ".//*[@id='MARKETING_USER_ROLES' and  @type='button']");
    	Log4j.infoLog("ClickOn_userPrivilleges_Editoption");
     }
     public  void clickOn_USERS_Upperbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("id", "append_values_2,append_values_13,MARKETING_USERS");
    	 Log4j.infoLog("clickon_USERS_Upperbord");

     }
     public  void clickOn_USER_Lowerbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", "//*[contains(@title, 'Users')]");
    	 Log4j.infoLog("clickOn_User_Lowerbord");
     }
     public void delete_USER() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", ".//*[@id='MARKETING_USERS']/following::button[1]");
    	 Log4j.infoLog("delete button clicked ");
	   	 Sync.procesWait(3000);
	   	 UTF.clickelement("partialLinkText", "Yes");
  	     Log4j.infoLog("delete user" );
     }
     
     public  void clickOn_CXO_Upperbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("id", "append_values_13,append_values_19,MARKETING_CXO");
    	 Log4j.infoLog("clickOn_CXO_Upperbord");
     }
    
    public  void clickOn_CXO_Lowerbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", "//*[contains(@title, 'CXO')]");
    	 Log4j.infoLog("clickOn_CXO_Lowerbord");
    	 }

    public  void clickOn_CXO_Editoption() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", ".//*[@id='MARKETING_CXO' and @type='button']");
    	 Log4j.infoLog("clickOn_CXO_Editoption");
    	
    }
    public void delete_CXO() {
    	 Sync.procesWait(3000);
   	     UTF.clickelement("xpath", "//*[contains(@title, 'CXO')]");
    	 UTF.clickelement("xpath", ".//*[@id='MARKETING_CXO']/following::button[2]");
   	     Log4j.infoLog("delete button clicked ");
   	   	 Sync.procesWait(3000);
   	   	 UTF.clickelement("partialLinkText", "Yes");
     	 Log4j.infoLog("delete_CXO" );
    }
    public  void clickOn_Manager_Upperbord() {
   	 Sync.procesWait(3000);
   	 UTF.clickelement("id", "append_values_13,append_values_20,MARKETING_USER_MANAGER");
   	 Log4j.infoLog("clickOn_Manager_Upperbord");
    }
   
   public  void clickOn_Manager_Lowerbord() {
   	 Sync.procesWait(4000);
   	 UTF.clickelement("xpath", "//li[@title='Manager']");
   	 Log4j.infoLog("clickOn_Manager_Lowerbord");
   	 }

   public  void clickOn_Manager_Editoption()  {
	 Sync.procesWait(3000);
   	 UTF.clickelement("xpath", ".//*[@id='MARKETING_USER_MANAGER' and @type='button']");
   	 Log4j.infoLog("clickOn_Manager_Editoption");
   	 Sync.procesWait(2000);
    }
   public  void delete_Manager() {
	     Sync.procesWait(3000);
	     UTF.mouseover("xpath", "//li[@title='Manager']");
	     Log4j.infoLog("clickOn_Manager_Lowerbord");
	     Sync.procesWait(4000);    
	     UTF.clickelement("xpath", ".//*[@id='MARKETING_USER_MANAGER']/following::button[2]");
	  // It is usefull for upper menu> UTF.clickelement("xpath", ".//*[@id='MARKETING_USER_MANAGER' and @type='button']");
	     Log4j.infoLog("delete button clicked ");
	   	 Sync.procesWait(3000);
	   	 UTF.clickelement("partialLinkText", "Yes");
  	     Log4j.infoLog("delete_Manager" );
	   
	   }
   
   public  void clickOn_Template_Settings_Upperbord() {
		Sync.procesWait(3000);
		UTF.clickelement("id", "append_values_2,append_values_14,MARKETING_PROJECT_SETTINGS");
		Log4j.infoLog("click On Template_Settings_upper");
	}
     public  void ClickOn_Template_Settings_Lowerbord() {
   	 Sync.procesWait(3000);
     UTF.clickelement("xpath", "//*[contains(@title, 'Template Settings')]");
 	 Log4j.infoLog(" ClickOn_Template_Settings_Lowerbord");
    }
    public void delete_Template_Settings() { 
    	Sync.procesWait(3000);
    	UTF.clickelement("xpath", "//*[contains(@title, 'Template Settings')]");
        Sync.procesWait(4000);    
 	    UTF.clickelement("xpath", ".//*[@id='MARKETING_PROJECT_SETTINGS']/following::button[1]");
 	     Sync.procesWait(2000);
	   	 UTF.clickelement("partialLinkText", "Yes");
 	    Log4j.infoLog(" Detele_Template_Settings");
    }
  // MARKETING_SMS_STORE
     
     
     
      public  void clickOn_SMS_Upperbord() {
		   Sync.procesWait(3000);
	       UTF.clickelement("id", "append_values_14,append_values_24,MARKETING_SMS_STORE");
		   Log4j.infoLog("clickOn_SMS_Upperbord");
	  }
       public  void clickOn_SMS_Lowerbord() {
 	       Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'SMS')]");
	       Log4j.infoLog("ClickOn_SMS_Lowerbord");
        }
       public void delete_SMSStore() {
    	   Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'SMS')]");
           Sync.procesWait(4000);    
   	       UTF.clickelement("xpath", ".//*[@id='MARKETING_SMS_STORE']/following::button[1]");
   	       Sync.procesWait(2000);
	   	   UTF.clickelement("partialLinkText", "Yes");
   	       Log4j.infoLog(" Detele_SMSStore");
      }
       
       
       public void clickOn_MARKETING_SMS_TEMPLETES_Upperbord() {
    	   Sync.procesWait(3000);
	       UTF.clickelement("id", "append_values_24,append_values_31,MARKETING_SMS_TEMPLETES");
		   Log4j.infoLog("clickOn_MARKETING_SMS_TEMPLETES_Upperbord");
    	   
       }
       public  void clickOn_MARKETING_SMS_TEMPLETES_Lowerbord() {
	       Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'SMS Templates')]");
	       Log4j.infoLog("ClickOn_SENDER_NAMES_Lowerbord");
       }
       public  void clickOn_MARKETING_SMS_TEMPLETES_Editoption() {
 	      Sync.procesWait(3000);
   	      UTF.clickelement("xpath", ".//*[@id='MARKETING_SMS_TEMPLETES' and @type='button']");
   	      Log4j.infoLog("clickOn_SENDER_NAMES_Editoption");
   	      Sync.procesWait(2000);
         }
       public void delete_MARKETING_SMS_TEMPLETES() {
    	   Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'SMS Templates')]");
           Sync.procesWait(2000);    
   	       UTF.clickelement("xpath", ".//*[@id='MARKETING_SMS_TEMPLETES']/following::button[2]");
   	       Sync.procesWait(2000);
	   	   UTF.clickelement("partialLinkText", "Yes");
   	       Log4j.infoLog("delete_MARKETING_SMS_TEMPLETES");
      }
       
       public void clickOn_SENDER_NAMES_Upperbord() {
    	   Sync.procesWait(3000);
	       UTF.clickelement("id", "append_values_24,append_values_30,MARKETING_SENDER_NAMES");
		   Log4j.infoLog("SENDER_NAMES_Upperbord");
    	   
       }
       public  void ClickOn_SENDER_NAMES_Lowerbord() {
	       Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'Sender Names')]");
	       Log4j.infoLog("ClickOn_SENDER_NAMES_Lowerbord");
       }
       public  void clickOn_SENDER_NAMES_Editoption() {
 	      Sync.procesWait(3000);
   	      UTF.clickelement("xpath", ".//*[@id='MARKETING_SENDER_NAMES' and @type='button']");
   	      Log4j.infoLog("clickOn_SENDER_NAMES_Editoption");
   	      Sync.procesWait(2000);
         }
       public void delete_SENDER_NAMES() {
    	   Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'Sender Names')]");
           Sync.procesWait(2000);    
   	       UTF.clickelement("xpath", ".//*[@id='MARKETING_SENDER_NAMES']/following::button[2]");
   	       Sync.procesWait(2000);
	   	   UTF.clickelement("partialLinkText", "Yes");
   	       Log4j.infoLog(" Detele_SENDER_NAMES");
      }
       
       
       
       public static void clickOn_Email_Upperbord() {
		   Sync.procesWait(3000);
	       UTF.clickelement("id", "append_values_14,append_values_25,MARKETING_EMAIL_STORE");
		   Log4j.infoLog("clickOn_Email_Upperbord");
	   }
       public static void ClickOn_Email_Lowerbord() {
	       Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'Email')]");
	       Log4j.infoLog("ClickOn_Email_Lowerbord");
       }
       public void dalete_EmailStore() {
    	   Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'Email')]");
           Sync.procesWait(4000);    
    	   UTF.clickelement("xpath", ".//*[@id='MARKETING_EMAIL_STORE']/following::button[1]");
    	   Sync.procesWait(2000);
	   	   UTF.clickelement("partialLinkText", "Yes");
    	   Log4j.infoLog(" EmailStore");
       }
       
       public static void clickOn_MARKETING_EMAIL_SETTINGS_Upperbord() {
	      Sync.procesWait(3000);
          UTF.clickelement("id", "append_values_25,append_values_32,MARKETING_EMAIL_SETTINGS");
	      Log4j.infoLog("clickOn_MARKETING_EMAIL_SETTINGS_Upperbord");
       }
       public  void ClickOn_MARKETING_EMAIL_SETTINGS_Lowerbord() {
          Sync.procesWait(3000);
          UTF.clickelement("xpath", "//*[contains(@title, 'Email Settings')]");
          Log4j.infoLog("ClickOn_MARKETING_EMAIL_SETTINGS_Lowerbord");
        }


       public  void clickOn_MARKETING_EMAIL_SETTINGS_Editoption() throws Exception {
	      Sync.procesWait(3000);
  	      UTF.clickelement("xpath", ".//*[@id='MARKETING_EMAIL_SETTINGS' and @type='button']");
  	      Log4j.infoLog("clickOn_MARKETING_EMAIL_SETTINGS_Editoption");
  	      Sync.procesWait(2000);
        }
       
       public void delete_MARKETING_EMAIL_SETTINGS() {
    	   Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'Email Settings')]");
           Sync.procesWait(2000);    
    	   UTF.clickelement("xpath", ".//*[@id='MARKETING_EMAIL_SETTINGS']/following::button[2]");
    	   Sync.procesWait(2000);
	   	   UTF.clickelement("partialLinkText", "Yes");
    	   Log4j.infoLog("delete_MARKETING_EMAIL_SETTINGS");
    	   
       } 
       
       
       public static void clickOn_Audio_Upperbord() {
	      Sync.procesWait(3000);
          UTF.clickelement("id", "append_values_14,append_values_26,MARKETING_AUDIO_STORE");
	      Log4j.infoLog("clickOn_Audio_Upperbord");
       }
       public static void ClickOn_Audio_Lowerbord() {
          Sync.procesWait(3000);
          UTF.clickelement("xpath", "//*[contains(@title, 'Audio')]");
          Log4j.infoLog("ClickOn_Audio_Lowerbord");
        }


       public static void clickOn_Audio_Editoption() throws Exception {
	      Sync.procesWait(3000);
  	      UTF.clickelement("xpath", ".//*[@id='MARKETING_AUDIO_STORE' and @type='button']");
  	      Log4j.infoLog("clickOn_Audio_Editoption");
  	      Sync.procesWait(2000);
        }
       
       public void delete_AudioStore() {
    	   Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'Audio')]");
           Sync.procesWait(4000);    
    	   UTF.clickelement("xpath", ".//*[@id='MARKETING_AUDIO_STORE']/following::button[2]");
    	   Sync.procesWait(2000);
	   	   UTF.clickelement("partialLinkText", "Yes");
    	   Log4j.infoLog(" EmailStore");
    	  
       }
    public String getpasswordNotification(String passwrod) throws InterruptedException
       {	
    	
    	   if(passwrod!=null) {
    		   Sync.procesWait(3000);
    		   UTF.inputText("id", "password", passwrod);
    		   Thread.sleep(2000);
    		   String password_error_message=UTF.findElement("xpath", ".//*[@id='password']/following::div[3]").getText();
    		   return password_error_message;
    	   }
    	   else
		   return null;
       }
    public void inavalidpasswordvalidation(String datatSet) throws Exception {
    	String password=readData.getdata(datatSet, "lessthen4letters");
    	if(password.length()<5)
    	{	
    	Assert.assertEquals(getpasswordNotification(password),"Please enter at least 5 characters.");
    		Log4j.infoLog(" entered at least 5 characters.");
    	}
    	else {
    		Assert.assertEquals(getpasswordNotification(password),"Should Contain Uppercase,Lowercase,Numeric and Special Character");
        		Log4j.infoLog("get error message Please enter at least 5 characters.");
    	}
    	
    }
    
    
    
    
    
    
      /* public void messagelength()
       {
    	 assert  getpass
 
       }
       public void upperandlowerdig(String datasetname)
       {
    	 assert  getpasswordNotification(data);
       }
       public void errormessagesforManager () {
    	  String username_error_message= UTF.findElement("xpath", ".//*[@id='username']/following::div[4]").getText();
    	  Log4j.infoLog(username_error_message);
    	  String password_error_message=UTF.findElement("xpath", ".//*[@id='password']/following::div[3]").getText();
    	 
    	  String ConfirmPassword_error_message=UTF.findElement("xpath", ".//*[@id='conf_password']/following::div[3]").getText();
    	  
    	  String First_Name_error_message= UTF.findElement("xpath", ".//*[@id='First_Name']/following::div[3]").getText();
    	  
    	  String Last_Name_error_message=UTF.findElement("xpath", ".//*[@id='Last_Name']/following::div[3]").getText();
    	  
    	  String Email_address_error_message=UTF.findElement("xpath", ".//*[@name='Email_ID']/following::div[3]").getText();
    	  
    	  
    	  String Mobile_Number_error_message=UTF.findElement("xpath", ".//*[@id='Mobile_Number']/following::div[3]").getText();
    	  
    	  String Branch_error_message=UTF.findElement("xpath", ".//*[@id='Branch_ID']/following::div[3]").getText();
    	  String Division_error_message=UTF.findElement("xpath", ".//*[@id='Group_ID']/following::div[3]").getText();
    	  String UserRole_error_message=UTF.findElement("xpath", ".//*[@id='Dept_ID']/following::div[3]").getText();
    	  String Reportingto_error_message=UTF.findElement("xpath", ".//*[@id='Reporting_Dept_UserId']/following::div[3]").getText();
       }

  */
       public void clickPlsebuttio() {
    	    Sync.procesWait(2000);
    	    UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
	 	    Log4j.infoLog("switch the frame");
    		UTF.clickelement("xpath", ".//*[@id='action']/img");
	    	Log4j.infoLog("click the pluse button");
	    	}
       
       public void addbranchInManager(String Branchname) {
    	  
    	 Sync.procesWait(2000);
    	 //List<WebElement> totalbrancs=UTF.findelements("xpath", ".//*[@id='Branch_ID']");
    	    
    	    /*for(WebElement totalbrancsnames:totalbrancs) {
    		 Log4j.infoLog(totalbrancsnames.getText());
    		 while(totalbrancsnames.getText().equals(Branchname)) {
    			 Sync.procesWait(2000);
    			 UTF.selectByVisibleText("id", "Branch_ID",Branchname );
    		   
    		 }
    		 }*/
    	
			 UTF.findElement("id", "addDesg").click();
			 Sync.procesWait(2000);
	  	     UTF.inputText("xpath", ".//*[@id='designtn']",Branchname );
	  	     UTF.clickelement("id", "designatins");
	  	     UTF.clickelement("xpath", ".//*[@id='designationadd']/following::button");
	  	     UTF.clickelement("xpath", ".//*[@id='refreshDesg']");
	  	     Sync.procesWait(2000);
			 UTF.selectByVisibleText("id", "Branch_ID",Branchname );
			 Log4j.infoLog("branch is selected");
		 }
    	
       public void addDivisionInmanager(String AddDivisionname) {
    	   UTF.clickelement("id", "addGroup");
    	   Log4j.infoLog("click the  addGroup");
  	       Sync.procesWait(2000);
  	       UTF.inputText("id", "group",AddDivisionname );
  	       Log4j.infoLog("enter the AddDivision ");
  	       UTF.clickelement("id", "groups");
  	       Log4j.infoLog("click the  ADDbuttion");
  	       UTF.clickelement("xpath", ".//*[@id='groupadd']/following::button");
  	       Log4j.infoLog("click the  closebutton");
  	       
  	       UTF.clickelement("xpath", " .//*[@id='refreshGroup']");
  	       Sync.procesWait(2000);
  	       UTF.selectByVisibleText("id", "Group_ID",AddDivisionname );
  	       Log4j.infoLog("select the AddDivision");
    	  
       }
       public void adduserRolesInManager(String AddUserRole,String seleteLevelText,String SelectReportingRole,String AddUserRoles) {
    	 
    	
    	 UTF.clickelement("id", "addUserrole");
  	     Log4j.infoLog("click the addUserrole");
  	     Sync.procesWait(2000);
  	     UTF.inputText("id", "deptname", AddUserRole);
  	     Log4j.infoLog("enter userrole");
  	     Sync.procesWait(2000);
  	     UTF.selectByVisibleText("id", "Dept_Level", seleteLevelText);
  	     Log4j.infoLog("select the level");
  	     Sync.procesWait(2000);
  	     UTF.selectByVisibleText("id", "Reporting_Dept", SelectReportingRole);
  	     Log4j.infoLog("select the ReportingRole");
  	     UTF.clickelement("id", "userroles");
  	     Log4j.infoLog("click the addbutton");
  	     UTF.clickelement("cssSelector", ".close");
  	     Log4j.infoLog("click the close button");
  	     Sync.procesWait(2000);
  	     UTF.clickelement("xpath", ".//*[@id='refreshRole']");
  	     Sync.procesWait(2000);
  	     UTF.selectByVisibleText("id", "Dept_ID", AddUserRoles);
  	     Log4j.infoLog("select the add user role");
    	   
       }
       
       public void managersubmitbuttion() {
    	   Sync.elementToBeClickable("xpath", ".//input[@id='usersubmit']", 40);
    	   UTF.clickelement("xpath", ".//input[@id='usersubmit']");
    	   Log4j.infoLog("click submit buttion");
    	   
    	 //  UTF.SwitchToDefaltFrame();
       }
       
       public void verifyingNOData() {
    	 UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
  	     Sync.procesWait(2000);
  	     Log4j.infoLog("switch the frame");
  	     String message= UTF.findElement("xpath", "//form[@id='dynamic_curd_pagination']/following::div[1]").getText();
  	     Log4j.infoLog(message); 
  	   if(message.equals("NO DATA")) {
  		   Log4j.infoLog("no data is prest on screen");
  		   }
  	  else {
	    	Log4j.infoLog("scren is present edit on it");
	       }
       }

     public  void  addManager_user_fields(String datasetname) throws Exception {
	   
	     String username=readData.getdata(datasetname, "username");
	     String password=readData.getdata(datasetname, "password");
	     String ConfirmPassword=readData.getdata(datasetname, "ConfirmPassword");
	     String FistName=readData.getdata(datasetname, "FistName");
	     String LastName=readData.getdata(datasetname, "LastName");
	 
	     String Emailaddress=readData.getdata(datasetname, "Emailaddress");
	     String Mobilenumber=readData.getdata(datasetname, "Mobilenumber");
	     String ADDBranchName=readData.getdata(datasetname, "ADDBranchName");
	     String AddDivision=readData.getdata(datasetname, "AddDivision");
	     String AddUserRole=readData.getdata(datasetname, "AddUserRole");
	     String AddUserRoles=readData.getdata(datasetname, "AddUserRoles");
	     String seleteLevel=readData.getdata(datasetname, "seleteLevel");
	     String SelectReportingRole=readData.getdata(datasetname, "SelectReportingRole");
	   
	     String Country=readData.getdata(datasetname, "Country");
	     String state=readData.getdata(datasetname, "state");
	     String city=readData.getdata(datasetname, "city");
	     String ContactAddress=readData.getdata(datasetname, "ContactAddress");
	     String PinCode=readData.getdata(datasetname, "PinCode");
	     String JoiningDateMonth=readData.getdata(datasetname, "JoiningDateManth");
	     String JoiningDateyear=readData.getdata(datasetname, "JoiningDateyear");
	     String EmployeeID=readData.getdata(datasetname, "EmployeeID");
	     String DateOfBirthmonth=readData.getdata(datasetname, "DateOfBirthmanth");
	     String DateOfBirthyear=readData.getdata(datasetname, "DateOfBirthyear");
	   
	     
	     
	     
	    
	     Sync.procesWait(2000);
	     UTF.inputText("id", "username", username);
	     Log4j.infoLog("enter the user name");
	     UTF.inputText("id", "password", password);
	     Log4j.infoLog("enter the password");
	     UTF.inputText("id", "conf_password", ConfirmPassword);
	     Log4j.infoLog("enter the confirmpassword");
	     UTF.inputText("id", "First_Name", FistName);
	     Log4j.infoLog("enter the FistName");
	     UTF.inputText("id", "Last_Name", LastName);
	     Log4j.infoLog("enter LastName");
	     UTF.inputText("name", "Email_ID",Emailaddress);
	     Log4j.infoLog("enter Emailaddress");
	     UTF.inputText("id", "Mobile_Number", Mobilenumber);
	     Log4j.infoLog("enter Mobilenumber");
	     UTF.selectByValue("id", "Company_ID","125_striker" );
	     Log4j.infoLog("select the company");
	     
	     addbranchInManager(ADDBranchName);
	     
         
	     
	     addDivisionInmanager(AddDivision);
	     
	     adduserRolesInManager(AddUserRole,seleteLevel,SelectReportingRole,AddUserRoles);
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("id", "Reporting_Dept_UserId", SelectReportingRole);
	     Log4j.infoLog("select the deporting");
	     
	     UTF.selectByValue("id", "countryid", Country);
	     Log4j.infoLog("select the Country");
	     UTF.selectByVisibleText("id", "stateid",state );
	     Log4j.infoLog("select the state");
	     UTF.selectByVisibleText("id", "cityid", city);
	     Log4j.infoLog("select the city");
	     UTF.inputText("id", "Contact_Address", ContactAddress);
	     Log4j.infoLog("select the ContactAddress");
	     UTF.inputText("id", "Pincode", PinCode);
	     Log4j.infoLog("select the PinCode");
	     
	     UTF.clickelement("id", "DOJ");
	     Log4j.infoLog("select Date of join ");
	     
	     UTF.selectByVisibleText("className", "ui-datepicker-month", JoiningDateMonth);
	     Log4j.infoLog("select JoiningDateManth ");
	    
	     UTF.selectByValue("className", "ui-datepicker-year", JoiningDateyear);
	     Log4j.infoLog("select JoiningDateyear ");
	     UTF.clickelement("partialLinkText", "6");
	     Log4j.infoLog("select DAY ");
	     UTF.inputText("id", "Emp_ID", EmployeeID);
	     Log4j.infoLog("EmployeeID ");
	  
	     UTF.clickelement("id", "DOB");
	     Log4j.infoLog("select DateOfBirth ");
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("className", "ui-datepicker-month", DateOfBirthmonth);
	     Log4j.infoLog("select DateOfBirth month ");
	    
	     Sync.procesWait(2000);
	     UTF.selectByValue("className", "ui-datepicker-year", DateOfBirthyear);
	     Log4j.infoLog("select DateOfBirthyear ");
	     UTF.clickelement("partialLinkText", "6");
	     Log4j.infoLog("Day selected ");
	     Sync.procesWait(2000);
	     managersubmitbuttion();
	     
	     /*UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
	     Sync.procesWait(2000);
	     Log4j.infoLog("switch the frame");
	     UTF.clickelement("xpath", ".//*[@id='action']/img");
	     Log4j.infoLog("click the pluse button");
	    
	     Sync.procesWait(2000);
	     UTF.inputText("id", "username", username);
	     Log4j.infoLog("enter the user name");
	     UTF.inputText("id", "password", password);
	     Log4j.infoLog("enter the password");
	     UTF.inputText("id", "conf_password", ConfirmPassword);
	     Log4j.infoLog("enter the confirmpassword");
	     UTF.inputText("id", "First_Name", FistName);
	     Log4j.infoLog("enter the FistName");
	     UTF.inputText("id", "Last_Name", LastName);
	     Log4j.infoLog("enter LastName");
	     UTF.inputText("name", "Email_ID",Emailaddress);
	     Log4j.infoLog("enter Emailaddress");
	     UTF.inputText("id", "Mobile_Number", Mobilenumber);
	     Log4j.infoLog("enter Mobilenumber");
	     UTF.selectByValue("id", "Company_ID","125_striker" );
	     Log4j.infoLog("select the company");
	     UTF.findElement("id", "addDesg").click();
	     Sync.procesWait(2000);
	     UTF.inputText("id", "designtn",ADDBranchName );
	     Log4j.infoLog("enter the ADDBranchName ");
	     UTF.clickelement("xpath", ".//*[@id='designationadd']/following::button");
	     Log4j.infoLog("close the popup branchname ");
	   
	     UTF.clickelement("id", "designatins");
	     UTF.selectByVisibleText("id", "Branch_ID", ADDBranchName);
	     Log4j.infoLog("select the branch  ");
	    
	     Sync.procesWait(2000);
	     UTF.clickelement("id", "addGroup");
	     Log4j.infoLog("click the  addGroup");
	     Sync.procesWait(2000);
	     UTF.inputText("id", "group",AddDivision );
	     Log4j.infoLog("enter the AddDivision ");
	     UTF.clickelement("id", "groups");
	     Log4j.infoLog("click the  ADDbuttion");
	     UTF.clickelement("xpath", ".//*[@id='groupadd']/following::button");
	     Log4j.infoLog("click the  closebutton");
	     UTF.selectByVisibleText("id", "Group_ID",AddDivision );
	     Log4j.infoLog("select the AddDivision");
	     
	     
	     UTF.clickelement("id", "addUserrole");
	     Log4j.infoLog("click the addUserrole");
	     Sync.procesWait(2000);
	     UTF.inputText("id", "deptname", AddUserRole);
	     Log4j.infoLog("enter userrole");
	     Sync.procesWait(2000);
	     UTF.selectByValue("id", "Dept_Level", seleteLevel);
	    
	     Log4j.infoLog("select the level");
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("id", "Reporting_Dept", SelectReportingRole);
	     Log4j.infoLog("select the ReportingRole");
	     UTF.clickelement("id", "userroles");
	     Log4j.infoLog("click the addbutton");
	     UTF.clickelement("cssSelector", ".close");
	     Log4j.infoLog("click the close button");
	     
	     UTF.selectByVisibleText("id", "Dept_ID", AddUserRoles);
	     Log4j.infoLog("select the add user role");
	     
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("id", "Reporting_Dept_UserId", SelectReportingRole);
	     Log4j.infoLog("select the deporting");
	     
	     UTF.selectByValue("id", "countryid", Country);
	     Log4j.infoLog("select the Country");
	     UTF.selectByVisibleText("id", "stateid",state );
	     Log4j.infoLog("select the state");
	     UTF.selectByVisibleText("id", "cityid", city);
	     Log4j.infoLog("select the city");
	     UTF.inputText("id", "Contact_Address", ContactAddress);
	     Log4j.infoLog("select the ContactAddress");
	     UTF.inputText("id", "Pincode", PinCode);
	     Log4j.infoLog("select the PinCode");
	     
	     UTF.clickelement("id", "DOJ");
	     Log4j.infoLog("select Date of join ");
	     
	     UTF.selectByVisibleText("className", "ui-datepicker-month", JoiningDateMonth);
	     Log4j.infoLog("select JoiningDateManth ");
	    
	     UTF.selectByValue("className", "ui-datepicker-year", JoiningDateyear);
	     Log4j.infoLog("select JoiningDateyear ");
	     UTF.clickelement("partialLinkText", "6");
	     Log4j.infoLog("select DAY ");
	     UTF.inputText("id", "Emp_ID", EmployeeID);
	     Log4j.infoLog("EmployeeID ");
	  
	     UTF.clickelement("id", "DOB");
	     Log4j.infoLog("select DateOfBirth ");
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("className", "ui-datepicker-month", DateOfBirthmonth);
	     Log4j.infoLog("select DateOfBirth month ");
	    
	     Sync.procesWait(2000);
	     UTF.selectByValue("className", "ui-datepicker-year", DateOfBirthyear);
	     Log4j.infoLog("select DateOfBirthyear ");
	     UTF.clickelement("partialLinkText", "6");
	     Log4j.infoLog("Day selected ");
	     Sync.procesWait(2000);
	     // clickSave_Save();
	     managersubmitbuttion();
	     // UTF.clickelement("xpath", ".//*[@id='usersubmit']");
	     // UTF.javaScriptclick("xpath", ".//input[@id='usersubmit']");
	     // UTF.doubleclick("xpath",".//input[@id='usersubmit']");
	     //Log4j.infoLog("click submit ");
	     
	     /*UTF.clickelement("xpath", ".//*[@id='adduser']/div[21]/button");
	     Log4j.infoLog("click the cancile ");
	     */
	     
	  
   }

     
     public void edit_flows_settingfor_manger()   {
    	 Sync.procesWait(4000);
    	if( UTF.findElement("id", "MARKETING_USER_MANAGER").getText().equals("Manager")) {
    		clickOn_Manager_Editoption() ;
    	}
    	else {
    		clickOn_ProjectManagement_upperbord();
			clickOn_projuctManagement_lowerbord();
			clickOn_USERS_Upperbord();
			clickOn_USER_Lowerbord();
			clickOn_Manager_Upperbord();
			clickOn_Manager_Lowerbord();
		    clickOn_Manager_Editoption();
    	}
       	
     }
     
     
     
     
     public void clickPlsebuttion() {
  	    Sync.procesWait(2000);
  	    UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
	 	    Log4j.infoLog("switch the frame");
  		UTF.clickelement("xpath", ".//*[@id='action']/img");
	    	Log4j.infoLog("click the pluse button");
	    	}
     
     public void addbranchInCXO(String Branchname) {
  	  
  	 Sync.procesWait(2000);
  	 //List<WebElement> totalbrancs=UTF.findelements("xpath", ".//*[@id='Branch_ID']");
  	    
  	    /*for(WebElement totalbrancsnames:totalbrancs) {
  		 Log4j.infoLog(totalbrancsnames.getText());
  		 while(totalbrancsnames.getText().equals(Branchname)) {
  			 Sync.procesWait(2000);
  			 UTF.selectByVisibleText("id", "Branch_ID",Branchname );
  		   
  		 }
  		 }*/
  	
			 UTF.findElement("id", "addDesg").click();
			 Sync.procesWait(2000);
	  	     UTF.inputText("xpath", ".//*[@id='designtn']",Branchname );
	  	     UTF.clickelement("id", "designatins");
	  	     UTF.clickelement("xpath", ".//*[@id='designationadd']/following::button");
	  	     UTF.clickelement("xpath", ".//*[@id='refreshDesg']");
	  	     Sync.procesWait(2000);
			 UTF.selectByVisibleText("id", "Branch_ID",Branchname );
			 Log4j.infoLog("branch is selected");
		 }
  	
     public void addDivisionInCXO(String AddDivisionname) {
  	   UTF.clickelement("id", "addGroup");
  	   Log4j.infoLog("click the  addGroup");
	       Sync.procesWait(2000);
	       UTF.inputText("id", "group",AddDivisionname );
	       Log4j.infoLog("enter the AddDivision ");
	       UTF.clickelement("id", "groups");
	       Log4j.infoLog("click the  ADDbuttion");
	       UTF.clickelement("xpath", ".//*[@id='groupadd']/following::button");
	       Log4j.infoLog("click the  closebutton");
	       
	       UTF.clickelement("xpath", " .//*[@id='refreshGroup']");
	       Sync.procesWait(2000);
	       UTF.selectByVisibleText("id", "Group_ID",AddDivisionname );
	       Log4j.infoLog("select the AddDivision");
  	  
     }
     public void adduserRolesInCXO(String AddUserRole,String seleteLevelText,String SelectReportingRole,String AddUserRoles) {
  	 
  	
  	 UTF.clickelement("id", "addUserrole");
	     Log4j.infoLog("click the addUserrole");
	     Sync.procesWait(2000);
	     UTF.inputText("id", "deptname", AddUserRole);
	     Log4j.infoLog("enter userrole");
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("id", "Dept_Level", seleteLevelText);
	     Log4j.infoLog("select the level");
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("id", "Reporting_Dept", SelectReportingRole);
	     Log4j.infoLog("select the ReportingRole");
	     UTF.clickelement("id", "userroles");
	     Log4j.infoLog("click the addbutton");
	     UTF.clickelement("cssSelector", ".close");
	     Log4j.infoLog("click the close button");
	     Sync.procesWait(2000);
	     UTF.clickelement("xpath", ".//*[@id='refreshRole']");
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("id", "Dept_ID", AddUserRoles);
	     Log4j.infoLog("select the add user role");
  	   
     }
     
     public void cxoSubmitbuttion() {
  	   Sync.elementToBeClickable("xpath", ".//*[@id='usersubmit']", 40);
  	   UTF.clickelement("xpath", ".//*[@id='usersubmit']");
     }
     
     public void verifyingNODatainCxo
     () {
  	 UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
	     Sync.procesWait(2000);
	     Log4j.infoLog("switch the frame");
	     String message= UTF.findElement("xpath", "//form[@id='dynamic_curd_pagination']/following::div[1]").getText();
	     Log4j.infoLog(message); 
	   if(message.equals("NO DATA")) {
		   Log4j.infoLog("no data is prest on screen");
		   }
	  else {
	    	Log4j.infoLog("scren is present edit on it");
	       }
     }
   
       public void addCXOfields(String datasetname) throws Exception {
    	 String username=readData.getdata(datasetname, "username");
  	     String password=readData.getdata(datasetname, "password");
  	     String ConfirmPassword=readData.getdata(datasetname, "ConfirmPassword");
  	     String FistName=readData.getdata(datasetname, "FistName");
  	     String LastName=readData.getdata(datasetname, "LastName");
  	 
  	     String Emailaddress=readData.getdata(datasetname, "Emailaddress");
  	     String Mobilenumber=readData.getdata(datasetname, "Mobilenumber");
  	     String ADDBranchName=readData.getdata(datasetname, "ADDBranchName");
  	     String AddDivision=readData.getdata(datasetname, "AddDivision");
  	     String AddUserRole=readData.getdata(datasetname, "AddUserRole");
  	     String AddUserRoles=readData.getdata(datasetname, "AddUserRoles");
  	     String seleteLevel=readData.getdata(datasetname, "seleteLevel");
  	     String SelectReportingRole=readData.getdata(datasetname, "SelectReportingRole");
  	   
  	     String Country=readData.getdata(datasetname, "Country");
  	     String state=readData.getdata(datasetname, "state");
  	     String city=readData.getdata(datasetname, "city");
  	     String ContactAddress=readData.getdata(datasetname, "ContactAddress");
  	     String PinCode=readData.getdata(datasetname, "PinCode");
  	     String  JoiningDateMonth=readData.getdata(datasetname, "JoiningDateManth");
  	     String  JoiningDateyear=readData.getdata(datasetname, "JoiningDateyear");
  	     String  EmployeeID=readData.getdata(datasetname, "EmployeeID");
  	     String  DateOfBirthmonth=readData.getdata(datasetname, "DateOfBirthmanth");
  	     String  DateOfBirthyear=readData.getdata(datasetname, "DateOfBirthyear");
  	     
	     UTF.inputText("id", "username", username);
	     Log4j.infoLog("enter the user name");
	     UTF.inputText("id", "password", password);
	     Log4j.infoLog("enter the password");
	     UTF.inputText("id", "conf_password", ConfirmPassword);
	     Log4j.infoLog("enter the confirmpassword");
	     UTF.inputText("id", "First_Name", FistName);
	     Log4j.infoLog("enter the FistName");
	     UTF.inputText("id", "Last_Name", LastName);
	     Log4j.infoLog("enter LastName");
	     UTF.inputText("name", "Email_ID",Emailaddress);
	     Log4j.infoLog("enter Emailaddress");
	     UTF.inputText("id", "Mobile_Number", Mobilenumber);
	     Log4j.infoLog("enter Mobilenumber");
	     UTF.selectByValue("id", "Company_ID","125_striker" );
	     Log4j.infoLog("select the company");
	     
	     addbranchInCXO(ADDBranchName);
	     
         addDivisionInCXO(AddDivision);
	     
	     adduserRolesInCXO(AddUserRole,seleteLevel,SelectReportingRole,AddUserRoles);
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("id", "Reporting_Dept_UserId", SelectReportingRole);
	     Log4j.infoLog("select the deporting");
	     
	     UTF.selectByValue("id", "countryid", Country);
	     Log4j.infoLog("select the Country");
	     UTF.selectByVisibleText("id", "stateid",state );
	     Log4j.infoLog("select the state");
	     UTF.selectByVisibleText("id", "cityid", city);
	     Log4j.infoLog("select the city");
	     UTF.inputText("id", "Contact_Address", ContactAddress);
	     Log4j.infoLog("select the ContactAddress");
	     UTF.inputText("id", "Pincode", PinCode);
	     Log4j.infoLog("select the PinCode");
	     
	     UTF.clickelement("id", "DOJ");
	     Log4j.infoLog("select Date of join ");
	     
	     UTF.selectByVisibleText("className", "ui-datepicker-month", JoiningDateMonth);
	     Log4j.infoLog("select JoiningDateManth ");
	    
	     UTF.selectByValue("className", "ui-datepicker-year", JoiningDateyear);
	     Log4j.infoLog("select JoiningDateyear ");
	     UTF.clickelement("partialLinkText", "6");
	     Log4j.infoLog("select DAY ");
	     UTF.inputText("id", "Emp_ID", EmployeeID);
	     Log4j.infoLog("EmployeeID ");
	  
	     UTF.clickelement("id", "DOB");
	     Log4j.infoLog("select DateOfBirth ");
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("className", "ui-datepicker-month", DateOfBirthmonth);
	     Log4j.infoLog("select DateOfBirth month ");
	    
	     Sync.procesWait(2000);
	     UTF.selectByValue("className", "ui-datepicker-year", DateOfBirthyear);
	     Log4j.infoLog("select DateOfBirthyear ");
	     UTF.clickelement("partialLinkText", "6");
	     Log4j.infoLog("Day selected ");
	     Sync.procesWait(2000);
	     cxoSubmitbuttion();
	   
       }
   
       public void upDate() {
    	   Sync.procesWait(2000);
      	    UTF.clickelement("partialLinkText", "Update");  
      	    Log4j.infoLog("click the update buttion");
       }
       
       
      public void checking_manager_usersRoles() throws Exception {
    	 String username=readData.getdata("Manager", "username");
 	     String FistName=readData.getdata("Manager", "FistName");
 	     String LastName=readData.getdata("Manager", "LastName");
 	     String Fullname=FistName+" "+LastName;
 	     String Emailaddress=readData.getdata("Manager", "Emailaddress");
 	     String Mobilenumber=readData.getdata("Manager", "Mobilenumber");
 	     String AddUserRole=readData.getdata("Manager", "AddUserRole");
 	     String Status=readData.getdata("Manager", "Status");
 	
    	  Map<String,String> hashmap=new HashMap<String,String>();
    	  Sync.procesWait(2000);
    	
   	      
   	      List<WebElement> melements=UTF.findelements("xpath", ".//*[@class='table event-cell-table']/tbody/tr/td/h4");
   	      //.//*[@class='table event-cell-table']/tbody/tr/td/h4
   	      for(int i=1;i<melements.size();i++)
   	      {
   	    	  System.out.println("i vlue is==============="+i);
   	    	if(i==6)
   	    	{
   	    		continue;
   	    	}
   	    	
   	    	//System.out.println(melements.get(i).getText().split(":")[0].trim());
   	    	//System.out.println(melements.get(i).getText().split(":")[1].trim());
   	    	hashmap.put(melements.get(i).getText().split(":")[0].trim(), melements.get(i).getText().split(":")[1].trim());
   	        }
   	   for(String values:hashmap.values()) {
	    		if(values.equals(username)) {
	    			Log4j.infoLog("username==>"+username+":>"+"present and valid");
	    		}
	    		else if(values.equals(Fullname)) {
	    			Log4j.infoLog("Fullname==>"+Fullname+":>"+"present and valid");
	    		}
	    		else if(values.equals(Emailaddress)) {
	    			Log4j.infoLog("Emailaddress==>"+Emailaddress+":>"+"present and valid");
	    		}
	    		else if(values.equals(Mobilenumber)) {
	    			Log4j.infoLog("Mobilenumber==>"+Mobilenumber+":>"+"present and valid");
	    		}
	    		else if(values.equals(AddUserRole)) {
	    			Log4j.infoLog("AddUserRole==>"+AddUserRole+":>"+"present and valid");
	    		}
	    		else if(values.equals(Status)) {
	    			Log4j.infoLog("Status==>"+Status+":>"+"present and valid");
	    		}
	    		
	    	}
   	       Sync.procesWait(2000);
   	    UTF.clickelement("partialLinkText", "Update");  
   	      
   	      
   	  
      }
   
      
    
      
       
       public void clickCancel_marketing_EMAIL_SETTINGS() {
    	   Sync.procesWait(2000);
    	   UTF.clickelement("xpath", ".//*[@id='dynamic_curd_form']//button");
    	   Log4j.infoLog("click the cancel");
    	   
       }
       public void clickSave_Save() {
    	   Sync.procesWait(2000);
    	   UTF.clickelement("id", "addSubmit");
    	   Log4j.infoLog("click the Save");
    	   
       }
       
       public void marketing_EMAIL_SETTINGS_Creating() throws Exception {
    	   Sync.procesWait(2000);
    	   String Company_Name=readData.getdata("emailsettingsform", "Company_Name");
    	   String From =readData.getdata("emailsettingsform", "From");
    	   String  Reply_To=readData.getdata("emailsettingsform", "Reply_To");
    	   String CC=readData.getdata("emailsettingsform", "CC");
    	   String BCC=readData.getdata("emailsettingsform", "BCC");
    	   
    	   clickplusbutton();
    	   UTF.selectByVisibleText("id", "Company_ID", Company_Name);
    	   Log4j.infoLog("select the compnay name");
    	   
    	   UTF.inputText("xpath", ".//*[@id='dynamic_curd_form']/div[2]/input", From);
    	   Log4j.infoLog("enter the from email");
    	  
    	   UTF.inputText("xpath", ".//*[@id='dynamic_curd_form']/div[3]/input", Reply_To);
    	   Log4j.infoLog("enter the To email");
    	   
    	   UTF.inputText("xpath", ".//*[@id='dynamic_curd_form']/div[4]/input", CC);
    	   Log4j.infoLog("enter the CC");
    	   
    	   UTF.inputText("xpath", ".//*[@id='dynamic_curd_form']/div[5]/input", BCC);
    	   Log4j.infoLog("enter the BCC");
    	   clickSave_Save();
       }
       
       
       public void clickplusbutton() {
    	   Sync.procesWait(2000);
    	   UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
    	   Sync.procesWait(2000);
    	   UTF.clickelement("id", "action");
       }
       public void marketing_EMAIL_SETTINGS_Nodataverification() throws Exception {
    	   Sync.procesWait(2000);
    	   UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
           String emailseetingmessage=	UTF.findElement("xpath", "//form[@id='dynamic_curd_form']/following::div[2]").getText();   
    	   Log4j.infoLog("get the message "+emailseetingmessage);
    	   if(emailseetingmessage.equals("No Emails Found")) {
    		   Log4j.infoLog("No Emails Found display");
    		   }
    	   else {
    		   Log4j.infoLog("datata allredy exist");
    	   }
    	   }
    
       
       
       /*
        * sma related functions
        */
       
       public void sms_Sender_Names_noData_verifying() {
    	   
    	  Sync.procesWait(2000);
      	  UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
      	  Log4j.infoLog(" shifting to sms sender name  frame");
      	 String message= UTF.findElement("xpath", "//form[@id='dynamic_curd_form']/following::div[3]").getText();
	     Log4j.infoLog(message); 
	   if(message.equals("NO DATA")) {
		   Log4j.infoLog("no data is prest on screen");
		   }
	  else {
	    	Log4j.infoLog("scren is present edit on it");
	       }
      	  
    	   
       }
       public void clicksave_SmsSendername() {
    	   Sync.procesWait(2000);
    	   UTF.clickelement("id", "addsendername");
    	   Log4j.infoLog("click the save buttion");
       }
       
       public void clickeplusbutton() {
    	   Sync.procesWait(2000);
    	   UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
    	   Sync.procesWait(2000);
    	   UTF.clickelement("id", "action");
    	   Log4j.infoLog("click the plse buttion ");
       }
      public void sms_Sendername_creation(String datasetname) throws Exception {
    	 String  companyname= readData.getdata(datasetname, "Company_Name");
    	 String sendername=readData.getdata(datasetname, "Sender_Name");
    	  
    	 // clickOn_SENDER_NAMES_Editoption();
    	 clickeplusbutton();
    	  Sync.procesWait(2000);
    	  UTF.selectByVisibleText("id", "Company_ID", companyname);
    	  Log4j.infoLog("select the company name");
    	  UTF.inputText("id", "Sender_ID", sendername);
    	  Log4j.infoLog("enter the sender name");
    	  clicksave_SmsSendername();
    	  UTF.SwitchToDefaltFrame();
    	  
      }
       
   /*  public void delete_SmsSendername_creation() {
    	Sync.procesWait(2000);
  	   UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
  	   Sync.procesWait(2000);
  	   UTF.clickelement("partialLinkText", "Delete");
  	   Log4j.infoLog("click the delete buttion");
  	   Sync.procesWait(2000);
  	   
  	   UTF.clickelement("xpath", "//div[@class='jconfirm-buttons']/button[1]");
  	  Log4j.infoLog("click the confirm");
  	  
  	    
  	   UTF.SwitchToDefaltFrame();
     }
     */
     public void delete_smsSender(String datasetname) throws Exception {
    	   String sendername=readData.getdata(datasetname, "Sender_Name");
           Sync.procesWait(2000);
    	   UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
    	   Sync.procesWait(2000);
    	   String sendernamexpath="//h4[contains(text(),'"+sendername.toUpperCase()+"')]/following::td[2]/h4/a";
    	   UTF.clickelement("xpath",sendernamexpath );
    	   UTF.clickelement("xpath", "//div[@class='jconfirm-buttons']/button[1]");
    	   Log4j.infoLog("click the confirm");
    	   UTF.SwitchToDefaltFrame();
    	      }

    	  public void saveSmsTemplate() {
    		  UTF.clickelement("id", "addSubmittemp");
    		  Log4j.infoLog("click on the save buttion");
    	  }
      public void creationSmsTemplate(String datasetname) throws Exception {
    	  String Template_Name=readData.getdata(datasetname, "Template_Name");
    	  String Template=readData.getdata(datasetname, "Template");
    	  String companeyname=readData.getdata(datasetname, "companeyname");
    	  
    	 Sync.procesWait(2000);
    	 UTF.selectByVisibleText("id", "Company_ID", companeyname);
    	 Log4j.infoLog("Enter the company name::");
    	 Sync.procesWait(2000);
    	 UTF.inputText("id", "Template_Name", Template_Name);
    	 Log4j.infoLog("Enter the  TemplateName ::");
    	 Sync.procesWait(2000);
    	 UTF.inputText("id", "Template", Template);
    	 Log4j.infoLog("Enter the  Template  ::");
    	 saveSmsTemplate();
    	 UTF.SwitchToDefaltFrame();
       }
    	
      public void SmsTemplate_deletion(String datasetname ) throws Exception {
    	  //.//h4[contains(text(),' Bday_wish')]/following::td[3]/h4/a[2]
    	  String Template_Name=readData.getdata(datasetname, "Template_Name");
          Sync.procesWait(2000);
   	   UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
   	   Sync.procesWait(2000);
   	   String Template_Namexpath=" .//h4[contains(text(),'"+ Template_Name+"')]/following::td[3]/h4/a[2]";
   	   UTF.clickelement("xpath",Template_Namexpath );
   	   UTF.clickelement("xpath", "//div[@class='jconfirm-buttons']/button[1]");
   	   Log4j.infoLog("click the confirm");
   	   UTF.SwitchToDefaltFrame();
      }
       
     


/********user privi
 * @throws Exception 
 * 
 */
  public void userPrivileges_web(String datasetname) throws Exception {
  String calenderview=readData.getdata(datasetname, "calenderview");
  String Calendar_add=readData.getdata(datasetname, "Calendar_add");
  String Calendar_Update=readData.getdata(datasetname, "Calendar_Update");
  String Contacts_Addevent=readData.getdata(datasetname, "Contacts_Addevent");
  String Contacts_viewgroup=readData.getdata(datasetname, "Contacts_viewgroup");
  String Contacts_AddGroup=readData.getdata(datasetname, "Contacts_AddGroup");
  String Contacts_EditGroup=readData.getdata(datasetname, "Contacts_EditGroup");
  String Contacts_DeleteGroup=readData.getdata(datasetname, "Contacts_DeleteGroup");
  String Contacts_ShareGroup=readData.getdata(datasetname, "Contacts_ShareGroup");
  String Contacts_MoveGroup=readData.getdata(datasetname, "Contacts_MoveGroup");
  String Contacts_SetPermission=readData.getdata(datasetname, "Contacts_SetPermission");
  String Contacts_ViewContacts=readData.getdata(datasetname, "Contacts_ViewContacts");
  String Contacts_DeleteContact=readData.getdata(datasetname, "Contacts_DeleteContact");
  String Contacts_AddComment=readData.getdata(datasetname, "Contacts_AddComment");
  String Contacts_SMS=readData.getdata(datasetname, "Contacts_SMS");
  String Contacts_Voice=readData.getdata(datasetname, "Contacts_Voice");
  String Contacts_Email=readData.getdata(datasetname, "Contacts_Email");
  String Contacts_Upload=readData.getdata(datasetname, "Contacts_Upload");
  String reportingview=readData.getdata(datasetname, "reportingview");
  String sourceTracker=readData.getdata(datasetname, "sourceTracker");
     Sync.frameToBeAvailableAndSwitchToitlocator("id", "Dynamic_Frame", 40);
     UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
     
      UTF.clickelement("xpath", ".//*[contains(text(),'manoj kumar')]");
      Log4j.infoLog("click the the useres");
      UTF.clickelement("xpath", ".//input[@name='Web_Email_Prev[]']/following::span[1]");
      Log4j.infoLog("selecting the webmail view option");
      
      UTF.clickelement("xpath",calenderview);
      
      UTF.clickelement("xpath",Calendar_add);
      
      UTF.clickelement("xpath",Calendar_Update);
      
      UTF.clickelement("xpath",Contacts_Addevent);
      
      UTF.clickelement("xpath",Contacts_viewgroup);
      
      UTF.clickelement("xpath",Contacts_AddGroup);
      
      UTF.clickelement("xpath",Contacts_EditGroup);
      
      UTF.clickelement("xpath",Contacts_DeleteGroup);
      
      UTF.clickelement("xpath",Contacts_ShareGroup);
      
      UTF.clickelement("xpath",Contacts_MoveGroup);
      
      UTF.clickelement("xpath",Contacts_SetPermission);
      
      UTF.clickelement("xpath",Contacts_ViewContacts);
      
      UTF.clickelement("xpath",Contacts_DeleteContact);
      
      UTF.clickelement("xpath",Contacts_AddComment);
      
      UTF.clickelement("xpath",Contacts_SMS);
      
      UTF.clickelement("xpath",Contacts_Voice);
      
      UTF.clickelement("xpath",Contacts_Email);
      
      
      UTF.clickelement("xpath",Contacts_Upload);
      
      
      UTF.clickelement("xpath",reportingview);
      
      UTF.clickelement("xpath",sourceTracker);
      
      
      
      UTF.clickelement("xpath", ".//*[@id='assign_usermenus_submit']");
  
     
      }
  
  
  
 /*
  * this method for source managements clickig
  */
  
  public void clickSourceManagemenet_UpperBord() {
	   Sync.elementToBeClickable("id", "flow_name,append_values_36,MARKETING_MARKETING_MANAGEMENT", 40);
	   UTF.clickelement("id", "flow_name,append_values_36,MARKETING_MARKETING_MANAGEMENT");
	   Log4j.infoLog("clickSourceManagemenet_UpperBord");
	   }
  
  public void clickSourceManagemenet_lowerBord() {
	   Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Source Management')]/div", 40);
	   UTF.clickelement("xpath", "//*[contains(@title, 'Source Management')]/div");
  	   Log4j.infoLog("clickSourceManagemenet_lowerBord");
       }
  public static void delete_SourceManagemenetnode() {
	   Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Source Management')]/div", 40);
	   UTF.clickelement("xpath", "//*[contains(@title, 'Source Management')]/div");
	   Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Source Management')]/div/button[1]", 40);
	   UTF.clickelement("xpath", "//*[contains(@title, 'Source Management')]/div/button[1]");
	   Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
	   UTF.clickelement("partialLinkText", "Yes");
	   Log4j.infoLog("delete_SourceManagemenetnode");
  }
  
  /*
   * this method  related productCosting  nodes
   */
  
 
    public void clickProductCosting_UpperBord() {
	   Sync.elementToBeClickable("id", "append_values_36,append_values_38,MARKETING_MARKETING_COSTING", 40);
	   UTF.clickelement("id", "append_values_36,append_values_38,MARKETING_MARKETING_COSTING");
	   Log4j.infoLog("clickProductCosting_UpperBord");
	   }
    
    public void clickProductCosting_lowerBord() {
 	   Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Product Costing')]/div", 40);
 	   UTF.clickelement("xpath", "//*[contains(@title, 'Product Costing')]/div");
   	   Log4j.infoLog("clickProductCosting_lowerBord");
        }
    
    public  void clickProductCosting_Edit()  {
    	  Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_MARKETING_COSTING']", 40);
	      UTF.clickelement("xpath", ".//button[@id='MARKETING_MARKETING_COSTING']");
	      Log4j.infoLog("clickOn_Audio_Editoption");
	      Sync.procesWait(2000);
      }
    public void delete_ProductCostingnode() {
       Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Product Costing')]/div", 40);
   	   UTF.clickelement("xpath", "//*[contains(@title, 'Product Costing')]/div");
 	   Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Product Costing')]/div/button[2]", 40);
 	   UTF.clickelement("xpath", "//*[contains(@title, 'Product Costing')]/div/button[2]");
 	   Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
 	   UTF.clickelement("partialLinkText", "Yes");
 	   Log4j.infoLog("delete_ProductCostingnode");
   }
   /*
    * this methods for Source Tracker nodes 
    */
    
    public void clickSourceTracker_UpperBord() {
 	   Sync.elementToBeClickable("id", "append_values_36,append_values_93,MARKETING_SOURCE_TRACKER", 40);
 	   UTF.clickelement("id", "append_values_36,append_values_93,MARKETING_SOURCE_TRACKER");
 	   Log4j.infoLog("clickSourceTracker_UpperBord");
 	   }
     
     public void clickSourceTracker_lowerBord() {
  	   Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Source Tracker')]/div", 40);
  	   UTF.clickelement("xpath", "//*[contains(@title, 'Source Tracker')]/div");
       Log4j.infoLog("clickSourceTracker_lowerBord");
         }
     public void delete_SourceTrackernode() {
       Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Source Tracker')]/div", 40);
       UTF.clickelement("xpath", "//*[contains(@title, 'Source Tracker')]/div");
   	   Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Source Tracker')]/div/button[1]", 40);
   	   UTF.clickelement("xpath", "//*[contains(@title, 'Source Tracker')]/div/button[1]");
   	   Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
   	   UTF.clickelement("partialLinkText", "Yes");
   	   Log4j.infoLog("delete_SourceTrackernode");
       }
     
     /*
     * this method for  
     * this methods Source Management------>> Website Tracker---->>Sources 
	 * Sources  related nodes flow
     */
     public void clickSource_UpperBord() {
   	   Sync.elementToBeClickable("id", "append_values_93,append_values_97,MARKETING_SOURCE_MANAGER", 40);
   	   UTF.clickelement("id", "append_values_93,append_values_97,MARKETING_SOURCE_MANAGER");
   	   Log4j.infoLog("clickSources_UpperBord()");
   	   }
       
     public void clickSource_lowerBord() {
       Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Sources')]/div", 40);
       UTF.clickelement("xpath", "//*[contains(@title, 'Sources')]/div");
       Log4j.infoLog("clickSource_lowerBord");
       }
     public void clickSource_edit() {
       Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_SOURCE_MANAGER']", 40);
	   UTF.clickelement("xpath", ".//button[@id='MARKETING_SOURCE_MANAGER']");
	   Log4j.infoLog("clickSource_edit");
	   }
     public void delete_SourceNode() {
       /* Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Sources')]/div", 40);
       UTF.clickelement("xpath", "//*[contains(@title, 'Sources')]/div");
       */
       Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_SOURCE_MANAGER']/following::button[1]", 40);
       UTF.clickelement("xpath", ".//button[@id='MARKETING_SOURCE_MANAGER']/following::button[1]");
       Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
       UTF.clickelement("partialLinkText", "Yes");
       Log4j.infoLog("delete_SourceTrackernode");
         }
     
     /*
     * this method for  
     * this methods Source Management------>> Website Tracker---->>Events 
	 * Events  related nodes flow
     */
     
       public void clickEvents_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_93,append_values_96,MARKETING_EVENT_MANAGER", 40);
     	   UTF.clickelement("id", "append_values_93,append_values_96,MARKETING_EVENT_MANAGER");
     	   Log4j.infoLog("clickEvents_UpperBord()");
     	   }
         
       public void clickEvents_lowerBord() {
          Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Events')]/div", 40);
          UTF.clickelement("xpath", "//*[contains(@title, 'Events')]/div");
          Log4j.infoLog("clickEvents_lowerBord");
          }
       public void clickEvents_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_EVENT_MANAGER']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_EVENT_MANAGER']");
  	      Log4j.infoLog("clickEvents_edit");
  	     
  	      }
       public void delete_EventsNode() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_EVENT_MANAGER']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_EVENT_MANAGER']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_SourceTrackernode");
          }
       public void SwitchtoEventFrame() {
    	   Sync.frameToBeAvailableAndSwitchToitlocator("id", "Dynamic_Frame", 40);
     	   UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
       }
       
       public void creatingEvents(String datasheetname) throws Exception {
    	   String Event_Name= readData.getdata(datasheetname, "Event_Name");
    	   Sync.procesWait(2000);
    	   UTF.inputText("xpath", ".//*[@id='dynamic_source_form']/div[1]/input", Event_Name);
    	   Log4j.infoLog("entring user name ");
           Sync.elementToBeClickable("xpath", ".//*[@id='dynamic_source_form']/div[2]/input", 40);
           UTF.clickelement("xpath", ".//*[@id='dynamic_source_form']/div[2]/input");
           Log4j.infoLog("clcik the save buttion ");
    	   }
       
       public void creatingsources(String datasheetname) throws Exception {
    	   String Event_Name= readData.getdata(datasheetname, "Event_Name");
    	   String Source_Type= readData.getdata(datasheetname, "Source_Type");
    	   String Source_Name= readData.getdata(datasheetname, "Source_Name");
    	   Sync.procesWait(2000);
    	   UTF.selectByVisibleText("xpath", ".//*[@id='Event_Name']", Event_Name);
    	   Log4j.infoLog("entring user name ");
    	   Sync.procesWait(2000);
    	   UTF.selectByVisibleText("id", "source_type_id", Source_Type);
    	   Sync.procesWait(2000);
    	   UTF.inputText("id", "src_type", Source_Name);
    	   
    	   UTF.clickelement("xpath", ".//*[@id='dynamic_source_form']/div[5]/input");
    	   
       }
      /* this node is CONNECTOR
       * 
       * 
       *  sourcemanagement---->>CONNECTOR
       *  
       *  
       */
       

       public void click_CONNECTOR_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_36,append_values_98,MARKETING_CONNECTOR", 40);
     	   UTF.clickelement("id", "append_values_36,append_values_98,MARKETING_CONNECTOR");
     	   Log4j.infoLog("clickCONNECTOR_UpperBord()");
     	   }
         
       public void click_CONNECTOR_lowerBord() {
          Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Connector')]/div", 40);
          UTF.clickelement("xpath", "//*[contains(@title, 'Connector')]/div");
          Log4j.infoLog("clickCONNECTOR_lowerBord");
          }
       public void click_CONNECTOR_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_CONNECTOR']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_CONNECTOR']");
  	      Log4j.infoLog("clickCONNECTOR_edit");
  	     
  	      }
       public void delete_CONNECTOR_Node() {
          Sync.elementToBeClickable("xpath", "//button[@id='MARKETING_CONNECTOR']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_CONNECTOR']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_SourceTrackernode");
          } 
       
       
       public void Connector_Configuration(String Datasheetname) throws Exception {
    	   
    	   String Categroy= readData.getdata(Datasheetname, "Categroy");
    	   String Permanent_Token= readData.getdata(Datasheetname, "Permanent_Token");
    	   String Ad_Account_Id= readData.getdata(Datasheetname, "Ad_Account_Id");
    	 
    	   Sync.procesWait(2000);
    	   UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
    	  
    	   Sync.elementToBeClickable("id", "newConnector", 40);
    	   UTF.clickelement("id", "newConnector");
    	   Log4j.infoLog("click the pluse butiion");
    	   
    	   
    	   
    	   UTF.selectByVisibleText("id", "categroy", Categroy);
    	   Log4j.infoLog("Select Categroy is selected");
    	   
    	   UTF.inputText("xpath", ".//*[@id='connectorForm']/div[1]/input", Permanent_Token);
    	   Log4j.infoLog("Permanent Token  is enter ");
    	   
    	   
    	   UTF.inputText("xpath", ".//*[@id='connectorForm']/div[2]/input[1]", Ad_Account_Id);
    	   Log4j.infoLog("Ad Account Id is eneter  ");
    	   
    	   UTF.clickelement("xpath", ".//*[@id='connectorForm']/div[3]/input");
    	   Log4j.infoLog("click the  save button");
    	   
       }
      /*
       * 
       *  Social Media 
       *  sourcemanagement---->>Social Media
       *  
       *  
       */
       
       public void click_SocialMedia_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_36,append_values_100,MARKETING_SOCIAL_MEDIA'", 40);
     	   UTF.clickelement("id", "append_values_36,append_values_100,MARKETING_SOCIAL_MEDIA'");
     	   Log4j.infoLog("click_SocialMedia_UpperBord()");
     	   }
         
       public void click_SocialMedia_lowerBord() {
          Sync.elementToBeClickable("xpath", "//*[contains(@title, 'Social Media')]/div", 40);
          UTF.clickelement("xpath", "//*[contains(@title, 'Social Media')]/div");
          Log4j.infoLog("click_SocialMedia_lowerBord");
          }
       public void delete_SocialMedia_Node() {
           Sync.elementToBeClickable("xpath", ".//span[@id='MARKETING_SOCIAL_MEDIA']/following::button[1]", 40);
           UTF.clickelement("xpath", ".//span[@id='MARKETING_SOCIAL_MEDIA']/following::button[1]");
           Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
           UTF.clickelement("partialLinkText", "Yes");
           Log4j.infoLog("delete_SourceTrackernode");
           } 
       
       /*
        * 
        *  Social media source
        *  sourcemanagement---->>Social Media--->Social media source
        *  
        *  
        */
       public void click_Socialmediasource_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_100,append_values_101,MARKETING_SOCIAL_SOURCE", 40);
     	   UTF.clickelement("id", "append_values_100,append_values_101,MARKETING_SOCIAL_SOURCE");
     	   Log4j.infoLog(" click_Socialmediasource_UpperBord");
     	   }
         
       public void click_Socialmediasource_lowerBord() {
          Sync.elementToBeClickable("xpath", ".//*[contains(@title, 'Social media source')]/div", 40);
          UTF.clickelement("xpath", ".//*[contains(@title, 'Social media source')]/div");
          Log4j.infoLog("click_Socialmediasource_lowerBord");
          }
       public void click_Socialmediasource_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_SOCIAL_SOURCE']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_SOCIAL_SOURCE']");
  	      Log4j.infoLog("click_Socialmediasource_edit");
  	     
  	      }
       public void delete_Socialmediasource_Node() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_SOCIAL_SOURCE']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_SOCIAL_SOURCE']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_Socialmediasource_Node");
          } 
       
       /*
        * 
        *  Add posting
        *  sourcemanagement---->>Social Media--->Add posting
        *  
        *  
        */
       public void click_Addposting_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_100,append_values_102,MARKETING_ADD_POSTING", 40);
     	   UTF.clickelement("id", "append_values_100,append_values_102,MARKETING_ADD_POSTING");
     	   Log4j.infoLog(" click_Addposting_UpperBord");
     	   }
         
       public void click_Addposting_lowerBord() {
          Sync.elementToBeClickable("xpath", ".//*[contains(@title, 'Add posting')]/div", 40);
          UTF.clickelement("xpath", ".//*[contains(@title, 'Add posting')]/div");
          Log4j.infoLog("click_Addposting_lowerBord");
          }
       public void click_Addposting_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_ADD_POSTING']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_ADD_POSTING']");
  	      Log4j.infoLog("click_Addposting_edit");
  	     
  	      }
       public void delete_Addposting_Node() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_ADD_POSTING']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_ADD_POSTING']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_Addposting_Node");
          } 
       /*
        * 
        *  Account Information
        *  sourcemanagement---->>Social Media--->Account Information
        *  
        *  
        */
       public void click_AccountInformation_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_100,append_values_103,MARKETING_ACCOUNT_INFORMATION", 40);
     	   UTF.clickelement("id", "append_values_100,append_values_103,MARKETING_ACCOUNT_INFORMATION");
     	   Log4j.infoLog(" click_Addposting_UpperBord");
     	   }
         
       public void click_AccountInformation_lowerBord() {
          Sync.elementToBeClickable("xpath", ".//*[contains(@title, 'Account Information')]/div", 40);
          UTF.clickelement("xpath", ".//*[contains(@title, 'Account Information')]/div");
          Log4j.infoLog("click_AccountInformation_lowerBord");
          }
       public void click_AccountInformation_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_ACCOUNT_INFORMATION']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_ACCOUNT_INFORMATION']");
  	      Log4j.infoLog("click_AccountInformation_edit");
  	     
  	      }
       public void delete_AccountInformation_Node() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_ACCOUNT_INFORMATION']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_ACCOUNT_INFORMATION']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_AccountInformation_Node");
          } 
       /*
        * 
        *  Competitor analysis
        *  sourcemanagement---->>Social Media--->Competitor analysis
        *  
        *  
        */
       public void click_Competitoranalysis_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_100,append_values_104,MARKETING_COMPETITOR_ANALYSIS", 40);
     	   UTF.clickelement("id", "append_values_100,append_values_104,MARKETING_COMPETITOR_ANALYSIS");
     	   Log4j.infoLog(" click_Competitoranalysis_UpperBord");
     	   }
         
       public void click_Competitoranalysis_lowerBord() {
          Sync.elementToBeClickable("xpath", ".//*[contains(@title, 'Competitor analysis')]/div", 40);
          UTF.clickelement("xpath", ".//*[contains(@title, 'Competitor analysis')]/div");
          Log4j.infoLog("click_Competitoranalysis_lowerBord");
          }
       public void click_Competitoranalysis_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_COMPETITOR_ANALYSIS']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_COMPETITOR_ANALYSIS']");
  	      Log4j.infoLog("click_AccountInformation_edit");
  	     
  	      }
       public void delete_Competitoranalysis_Node() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_COMPETITOR_ANALYSIS']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_COMPETITOR_ANALYSIS']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_AccountInformation_Node");
          } 
       /*
        * 
        *  Social chart
        *  sourcemanagement---->>Social Media--->Social chart
        *  
        *  
        */
       public void click_Socialchart_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_100,append_values_105,MARKETING_SOCIAL_CHART", 40);
     	   UTF.clickelement("id", "append_values_100,append_values_105,MARKETING_SOCIAL_CHART");
     	   Log4j.infoLog(" click_Socialchart_UpperBord");
     	   }
         
       public void click_Socialchart_lowerBord() {
          Sync.elementToBeClickable("xpath", ".//*[contains(@title, 'Social chart')]/div", 40);
          UTF.clickelement("xpath", ".//*[contains(@title, 'Social chart')]/div");
          Log4j.infoLog("click_Socialchart_lowerBord");
          }
       public void click_Socialchart_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_SOCIAL_CHART']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_SOCIAL_CHART']");
  	      Log4j.infoLog("click_Socialchart_edit");
  	     
  	      }
       public void delete_Socialchart_Node() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_SOCIAL_CHART']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_SOCIAL_CHART']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_Socialchart_Node");
          } 
      
       /*
        * 
        *   Push Notifications
        *  sourcemanagement---->> Push Notifications--->
        *  
        *  
        */
       public void click_PushNotifications_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_36,append_values_106,MARKETING_PUSH_NOTIFICATIONS", 40);
     	   UTF.clickelement("id", "append_values_36,append_values_106,MARKETING_PUSH_NOTIFICATIONS");
     	   Log4j.infoLog(" click_Socialchart_UpperBord");
     	   }
         
       public void click_PushNotifications_lowerBord() {
          Sync.elementToBeClickable("xpath", ".//*[contains(@title, 'Push Notifications')]/div", 40);
          UTF.clickelement("xpath", ".//*[contains(@title, 'Push Notifications')]/div");
          Log4j.infoLog("click_Socialchart_lowerBord");
          }
      
       public void delete_PushNotifications_Node() {
          Sync.elementToBeClickable("xpath", ".//span[@id='MARKETING_MARKETING_MANAGEMENT']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//span[@id='MARKETING_MARKETING_MANAGEMENT']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_Socialchart_Node");
          } 
       
       /*
        * 
        *  MOBILE_PUSH_NOTIFICATIONS
        *  sourcemanagement---->>PUSH_NOTIFICATIONS-->>MOBILE_PUSH_NOTIFICATIONS
        *  
        *  
        */
       public void click_MOBILE_PUSH_NOTIFICATIONS_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_106,append_values_107,MARKETING_MOBILE_PUSH_NOTIFICATIONS", 40);
     	   UTF.clickelement("id", "append_values_106,append_values_107,MARKETING_MOBILE_PUSH_NOTIFICATIONS");
     	   Log4j.infoLog("click_MOBILE_PUSH_NOTIFICATIONS_UpperBord");
     	   }
         
       public void click_MOBILE_PUSH_NOTIFICATIONS_lowerBord() {
          Sync.elementToBeClickable("xpath", ".//*[contains(@title, 'Mobile push notifications')]/div", 40);
          UTF.clickelement("xpath", ".//*[contains(@title, 'Mobile push notifications')]/div");
          Log4j.infoLog("click_MOBILE_PUSH_NOTIFICATIONS_lowerBord");
          }
       public void click_MOBILE_PUSH_NOTIFICATIONS_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_MOBILE_PUSH_NOTIFICATIONS']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_MOBILE_PUSH_NOTIFICATIONS']");
  	      Log4j.infoLog("click_MOBILE_PUSH_NOTIFICATIONS_edit");
  	     
  	      }
       public void delete_MOBILE_PUSH_NOTIFICATIONS_Node() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_MOBILE_PUSH_NOTIFICATIONS']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_MOBILE_PUSH_NOTIFICATIONS']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_MOBILE_PUSH_NOTIFICATIONS_Node");
          } 
       /*
        * 
        *  Web push notifications
        *  sourcemanagement---->>PUSH_NOTIFICATIONS-->>Web push notifications
        *  
        *  
        */
       public void click__WEB_PUSH_NOTIFICATIONS_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_106,append_values_108,MARKETING_WEB_PUSH_NOTIFICATIONS", 40);
     	   UTF.clickelement("id", "append_values_106,append_values_108,MARKETING_WEB_PUSH_NOTIFICATIONS");
     	   Log4j.infoLog("click_MOBILE_PUSH_NOTIFICATIONS_UpperBord");
     	   }
         
       public void click__WEB_PUSH_NOTIFICATIONS_lowerBord() {
          Sync.elementToBeClickable("xpath", ".//*[contains(@title, 'Web push notifications')]/div", 40);
          UTF.clickelement("xpath", ".//*[contains(@title, 'Mobile push notifications')]/div");
          Log4j.infoLog("click__WEB_PUSH_NOTIFICATIONS_lowerBord");
          }
       public void click__WEB_PUSH_NOTIFICATIONS_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_WEB_PUSH_NOTIFICATIONS']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_WEB_PUSH_NOTIFICATIONS']");
  	      Log4j.infoLog("click__WEB_PUSH_NOTIFICATIONS_edit");
  	     
  	      }
       public void delete__WEB_PUSH_NOTIFICATIONS_Node() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_WEB_PUSH_NOTIFICATIONS']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_WEB_PUSH_NOTIFICATIONS']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete_MOBILE_PUSH_NOTIFICATIONS_Node");
          } 
       /*
        * 
        *  Web push notifications
        *  sourcemanagement---->>PUSH_NOTIFICATIONS-->>Web push notifications
        *  
        *  
        */
       public void click__IN_APP_MESSAGES_UpperBord() {
     	   Sync.elementToBeClickable("id", "append_values_106,append_values_109,MARKETING_IN_APP_MESSAGES", 40);
     	   UTF.clickelement("id", "append_values_106,append_values_109,MARKETING_IN_APP_MESSAGES");
     	   Log4j.infoLog("click__IN_APP_MESSAGES_UpperBord");
     	   }
         
       public void click__IN_APP_MESSAGES_lowerBord() {
          Sync.elementToBeClickable("xpath", ".//*[contains(@title, 'In-App messages')]/div", 40);
          UTF.clickelement("xpath", ".//*[contains(@title, 'In-App messages')]/div");
          Log4j.infoLog("click__IN_APP_MESSAGES_lowerBord");
          }
       public void click__IN_APP_MESSAGES_edit() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_IN_APP_MESSAGES']", 40);
  	      UTF.clickelement("xpath", ".//button[@id='MARKETING_IN_APP_MESSAGES']");
  	      Log4j.infoLog("click__IN_APP_MESSAGES_edit");
  	     
  	      }
       public void delete__IN_APP_MESSAGES_Node() {
          Sync.elementToBeClickable("xpath", ".//button[@id='MARKETING_IN_APP_MESSAGES']/following::button[1]", 40);
          UTF.clickelement("xpath", ".//button[@id='MARKETING_IN_APP_MESSAGES']/following::button[1]");
          Sync.textToBePresentInElementLocated("partialLinkText", "Yes", 40, "Yes");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete__IN_APP_MESSAGES_Node");
          } 
       
       /*
        * 
        * 
          Long Code
        *  sourcemanagement---->>-->Long Code

        *  
        *  
        */
        public void click__LongCode_UpperBord() {
       	
       	   UTF.clickelement("id", "append_values_36,append_values_77,MARKETING_LONG_CODE");
       	   Log4j.infoLog("click__LongCode_UpperBord");
       	   }
         
        public void click_LongCode_edit() {
              UTF.clickelement("xpath", ".//button[@id='MARKETING_LONG_CODE']");
    	      Log4j.infoLog("click__ILongCode_edit");
    	     
    	      }
        public void click_LongCode_lowerBord() {
          UTF.clickelement("xpath", ".//*[contains(@title, 'Long Code')]/div");
          Log4j.infoLog("click___LongCode_lowerBord");
          }
        
        public void delete_LongCode_Node() {
          UTF.clickelement("xpath", ".//button[@id='MARKETING_LONG_CODE']/following::button[1]");
          UTF.clickelement("partialLinkText", "Yes");
          Log4j.infoLog("delete___LongCode_Node");
          } 
        
        public void filling_LongCode(String datasheetname) throws Exception {
        	String Event_Name=readData.getdata(datasheetname, "Event_Name");

        	String source_name=readData.getdata(datasheetname, "source_name");
        	Log4j.infoLog("source_name is enter");
        	String long_code=readData.getdata(datasheetname, "long_code");
        	
        	UTF.selectByVisibleText("id", "Event_Name", Event_Name);
        	Log4j.infoLog(" select the event name");
        	UTF.selectByVisibleText("id", "source_name",source_name);
        	Log4j.infoLog(" select the source_name");
        	UTF.selectByVisibleText("id", "long_code", long_code);
        	Log4j.infoLog(" select the long_code");
        	UTF.clickelement("id", "fieldsssubmit");
        	Log4j.infoLog(" click save ");
        	
        }
        
        
        /*
         * 
         * 
           Customer Score
         *  sourcemanagement---->>-->Customer Score

         *  
         *  
         */
         public void click_CustomerScore_UpperBord() {
        	
        	   UTF.clickelement("id", "append_values_36,append_values_79,MARKETING_CUSTOMER_SCORE");
        	   Log4j.infoLog("click__CustomerScore_UpperBord");
        	   }
          
       
         public void click_CustomerScore_lowerBord() {
           UTF.clickelement("xpath", ".//*[contains(@title, 'Customer Score')]/div");
           Log4j.infoLog("click_CustomerScore_lowerBord");
           }
         
         public void delete_CustomerScore_Node() {
           UTF.clickelement("xpath", ".//span[@id='MARKETING_CUSTOMER_SCORE']/following::button[1]");
           UTF.clickelement("partialLinkText", "Yes");
           Log4j.infoLog("delete___LongCode_Node");
           } 
        
         /*
          * 
          * 
            Source Wise
          *  sourcemanagement---->>-->Customer Score----------->>>Source Wise

          *  
          *  
          */
          public void click_SourceWise_UpperBord() {
         	
         	   UTF.clickelement("id", "append_values_79,append_values_86,MARKETING_CUSTOMER_SCORE_SOURCE_WISE");
         	   Log4j.infoLog("click__SourceWise_UpperBord()");
         	   }
           
          public void click_SourceWise_edit() {
                UTF.clickelement("xpath", ".//button[@id='MARKETING_CUSTOMER_SCORE_SOURCE_WISE']");
      	        Log4j.infoLog("click_SourceWise_edit");
      	     
      	      }
          public void click_SourceWise_lowerBord() {
            UTF.clickelement("xpath", ".//*[contains(@title, 'Source Wise')]/div");
            Log4j.infoLog("click_SourceWise_lowerBord");
            }
          
          public void delete_SourceWise_Node() {
            UTF.clickelement("xpath", ".//button[@id='MARKETING_CUSTOMER_SCORE_SOURCE_WISE']/following::button[1]");
            UTF.clickelement("partialLinkText", "Yes");
            Log4j.infoLog("delete_SourceWise_Node");
            } 
          
         public void SourceWiseScore(String datasheetname) throws Exception {
             String Dynamic_Source=	 readData.getdata(datasheetname, "Dynamic_Source");
             String Source_Type=	 readData.getdata(datasheetname, "Source_Type");
             String Source_Name=	 readData.getdata(datasheetname, "Source_Name");
             String Source_Score=	 readData.getdata(datasheetname, "Source_Score");
        	 
        	 UTF.selectByVisibleText("id", "source", Dynamic_Source);
        	 Log4j.infoLog("click the source");
            
        	 UTF.selectByVisibleText("id", "source_type_id", Source_Type);
        	 Log4j.infoLog("select the source type ");
        	 
        	 UTF.selectByVisibleText("id", "source_name", Source_Name);
        	 Log4j.infoLog("select the source name  ");
        	 
        	 UTF.inputText("id", "sourcescore", Source_Score);
        	 Log4j.infoLog("entring score  ");
        	 
        	 
        	 
        	 UTF.clickelement("id", "fieldsssubmit");
        	 Log4j.infoLog("click the save buttion");
         }
          

          /*
           * 
           * 
            
              Field Wise
           *  sourcemanagement---->>-->Customer Score----------->>>Field Wise

           *  
           *  
           */
           public void click__FieldWise_UpperBord() {
          	
          	   UTF.clickelement("id", "append_values_79,append_values_87,MARKETING_CUSTOMER_SCORE_FIELDS_WISE");
          	   Log4j.infoLog("click__FieldWise_UpperBord()");
          	   }
            
           
           public void click_FieldWise_lowerBord() {
             UTF.clickelement("xpath", ".//*[contains(@title, 'Field Wise')]/div");
             Log4j.infoLog("click_FieldWise_lowerBord()");
             }
           
           public void click_FieldWise_edit() {
               UTF.clickelement("xpath", ".//button[@id='MARKETING_CUSTOMER_SCORE_FIELDS_WISE']");
     	        Log4j.infoLog("click_FieldWise_edit");
     	     
     	      }
           
           public void delete_FieldWise_Node() {
             UTF.clickelement("xpath", ".//button[@id='click_FieldWise_edit']/following::button[1]");
             UTF.clickelement("partialLinkText", "Yes");
             Log4j.infoLog("delete_FieldWise_Node");
             } 
           
        
        
        
       
}
     
    
    
       
       
       
       
       
       
   

