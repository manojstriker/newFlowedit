package pageobject.MyServices.marketingAutomation.home;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
      UTF.clickelement("xpath", "/html/body/div[4]/div/table/tbody/tr/td[6]/a[1]");
      
      }
    public static void clickOn_ProjectManagement_upperbord() {
    	Sync.procesWait(3000);
    	UTF.clickelement("id", "flow_name,append_values_2,MARKETING_PROJECT_MANAGEMENT");
    	Log4j.infoLog("click on the ProjectManagement_upperbord");
    	
    }
    public  void clickOn_ProjectManagement_delete() {
    	 Sync.procesWait(3000);
	   	 UTF.clickelement("xpath", "//li[@title='Project Management']");
	     Sync.procesWait(2000);
	     UTF.clickelement("xpath", ".//*[@id='MARKETING_PROJECT_MANAGEMENT']/following::button[1]");
    	 Log4j.infoLog("delete button clicked ");
	   	 Sync.procesWait(3000);
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
    	 UTF.clickelement("xpath", "//*[contains(@title, 'UserPrivilleges')]");
    	Log4j.infoLog("ClickOn__userprivilleges_lowerbord");
    }
    
   
	
     public static void ClickOn_userPrivilleges_Editoption() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", "//*[contains(@title, 'User Privilleges')]");
    	 Sync.procesWait(3000);          
    	UTF.clickelement("xpath", ".//*[@id='MARKETING_USER_ROLES' and  @type='button']");
    	
    	Sync.procesWait(3000);
    	Log4j.infoLog("ClickOn_userPrivilleges_Editoption");
     }
     public static void clickOn_USERS_Upperbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("id", "append_values_2,append_values_13,MARKETING_USERS");
    	 Log4j.infoLog("clickon_USERS_Upperbord");

     }
     public static void clickOn_User_Lowerbord() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", "//*[contains(@title, 'Users')]");
    	 Log4j.infoLog("clickOn_User_Lowerbord");
     }
     public void clickOn_user_delete() {
    	 Sync.procesWait(3000);
    	 UTF.clickelement("xpath", ".//*[@id='MARKETING_USERS']/following::button[1]");
    	 Log4j.infoLog("delete button clicked ");
	   	 Sync.procesWait(3000);
	   	 UTF.clickelement("partialLinkText", "Yes");
  	     Log4j.infoLog("delete user" );
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
    public void delete_CXO() {
    	 Sync.procesWait(3000);
   	     UTF.clickelement("xpath", "//*[contains(@title, 'CXO')]");
    	 UTF.clickelement("xpath", ".//*[@id='MARKETING_CXO']/following::button[2]");
   	     Log4j.infoLog("delete button clicked ");
   	   	 Sync.procesWait(3000);
   	   	 UTF.clickelement("partialLinkText", "Yes");
     	 Log4j.infoLog("delete_CXO" );
    }
    public static void clickOn_Manager_Upperbord() {
   	 Sync.procesWait(3000);
   	 UTF.clickelement("id", "append_values_13,append_values_20,MARKETING_USER_MANAGER");
   	 Log4j.infoLog("clickOn_Manager_Upperbord");
    }
   
   public static void clickOn_Manager_Lowerbord() {
   	 Sync.procesWait(4000);
   	 UTF.clickelement("xpath", "//li[@title='Manager']");
   	 Log4j.infoLog("clickOn_Manager_Lowerbord");
   	 }

   public static void clickOn_Manager_Editoption() throws Exception {
	 Sync.procesWait(3000);
   	 UTF.clickelement("xpath", ".//*[@id='MARKETING_USER_MANAGER' and @type='button']");
   	 Log4j.infoLog("clickOn_Manager_Editoption");
   	 Sync.procesWait(2000);
    }
   public static void delete_Manager() {
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
   
   public static void clickOn_Template_Settings_Upperbord() {
		Sync.procesWait(3000);
		UTF.clickelement("id", "append_values_2,append_values_14,MARKETING_PROJECT_SETTINGS");
		Log4j.infoLog("click On Template_Settings_upper");
	}
     public static void ClickOn_Template_Settings_Lowerbord() {
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
     
     
     
      public static void clickOn_SMS_Upperbord() {
		   Sync.procesWait(3000);
	       UTF.clickelement("id", "append_values_14,append_values_24,MARKETING_SMS_STORE");
		   Log4j.infoLog("clickOn_SMS_Upperbord");
	  }
       public static void ClickOn_SMS_Lowerbord() {
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
       public static void ClickOn_MARKETING_SMS_TEMPLETES_Lowerbord() {
	       Sync.procesWait(3000);
           UTF.clickelement("xpath", "//*[contains(@title, 'SMS Templates')]");
	       Log4j.infoLog("ClickOn_SENDER_NAMES_Lowerbord");
       }
       public static void clickOn_MARKETING_SMS_TEMPLETES_Editoption() {
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
       public static void ClickOn_MARKETING_EMAIL_SETTINGS_Lowerbord() {
          Sync.procesWait(3000);
          UTF.clickelement("xpath", "//*[contains(@title, 'Email Settings')]");
          Log4j.infoLog("ClickOn_MARKETING_EMAIL_SETTINGS_Lowerbord");
        }


       public static void clickOn_MARKETING_EMAIL_SETTINGS_Editoption() throws Exception {
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
       



     public  void  addManagerfields() throws Exception {
	   
	     String username=readData.getdata("Manager", "username");
	     String password=readData.getdata("Manager", "password");
	     String ConfirmPassword=readData.getdata("Manager", "ConfirmPassword");
	     String FistName=readData.getdata("Manager", "FistName");
	     String LastName=readData.getdata("Manager", "LastName");
	 
	     String Emailaddress=readData.getdata("Manager", "Emailaddress");
	     String Mobilenumber=readData.getdata("Manager", "Mobilenumber");
	     String ADDBranchName=readData.getdata("Manager", "ADDBranchName");
	     String AddDivision=readData.getdata("Manager", "AddDivision");
	     String AddUserRole=readData.getdata("Manager", "AddUserRole");
	     String AddUserRoles=readData.getdata("Manager", "AddUserRoles");
	     String seleteLevel=readData.getdata("Manager", "seleteLevel");
	     String SelectReportingRole=readData.getdata("Manager", "SelectReportingRole");
	   
	     String Country=readData.getdata("Manager", "Country");
	     String state=readData.getdata("Manager", "state");
	     String city=readData.getdata("Manager", "city");
	     String ContactAddress=readData.getdata("Manager", "ContactAddress");
	     String PinCode=readData.getdata("Manager", "PinCode");
	     String  JoiningDateMonth=readData.getdata("Manager", "JoiningDateManth");
	     String  JoiningDateyear=readData.getdata("Manager", "JoiningDateyear");
	     String  EmployeeID=readData.getdata("Manager", "EmployeeID");
	     String  DateOfBirthmonth=readData.getdata("Manager", "DateOfBirthmanth");
	     String  DateOfBirthyear=readData.getdata("Manager", "DateOfBirthyear");
	   
	     
	     UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
	     Sync.procesWait(2000);
	     Log4j.infoLog("switch the frame");
	     String message= UTF.findElement("xpath", "//form[@id='dynamic_curd_pagination']/following::div[1]").getText();
	     Log4j.infoLog(message); 
	    if(message.equals("NO DATA")) {
	    	UTF.clickelement("xpath", ".//*[@id='action']/img");
	    	Log4j.infoLog("click the plse button");
	    }
	    else {
	    	Log4j.infoLog("data is present edit on it");
	    }
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
	     UTF.clickelement("id", "usersubmit");
	     Log4j.infoLog("click submit ");
	     
	     /*UTF.clickelement("xpath", ".//*[@id='adduser']/div[21]/button");
	     Log4j.infoLog("click the cancile ");
	     */
	     
	  
   }
   
       public void addCXOfields() throws Exception {
    	 String username=readData.getdata("CXO", "username");
  	     String password=readData.getdata("CXO", "password");
  	     String ConfirmPassword=readData.getdata("CXO", "ConfirmPassword");
  	     String FistName=readData.getdata("CXO", "FistName");
  	     String LastName=readData.getdata("CXO", "LastName");
  	 
  	     String Emailaddress=readData.getdata("CXO", "Emailaddress");
  	     String Mobilenumber=readData.getdata("CXO", "Mobilenumber");
  	     String ADDBranchName=readData.getdata("CXO", "ADDBranchName");
  	     String AddDivision=readData.getdata("CXO", "AddDivision");
  	     String AddUserRole=readData.getdata("CXO", "AddUserRole");
  	     String AddUserRoles=readData.getdata("CXO", "AddUserRoles");
  	     String seleteLevel=readData.getdata("CXO", "seleteLevel");
  	     String SelectReportingRole=readData.getdata("CXO", "SelectReportingRole");
  	   
  	     String Country=readData.getdata("CXO", "Country");
  	     String state=readData.getdata("CXO", "state");
  	     String city=readData.getdata("CXO", "city");
  	     String ContactAddress=readData.getdata("CXO", "ContactAddress");
  	     String PinCode=readData.getdata("CXO", "PinCode");
  	     String  JoiningDateMonth=readData.getdata("CXO", "JoiningDateManth");
  	     String  JoiningDateyear=readData.getdata("CXO", "JoiningDateyear");
  	     String  EmployeeID=readData.getdata("CXO", "EmployeeID");
  	     String  DateOfBirthmonth=readData.getdata("CXO", "DateOfBirthmanth");
  	     String  DateOfBirthyear=readData.getdata("CXO", "DateOfBirthyear");
  	   
  	     
  	     UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
  	     Sync.procesWait(2000);
  	     Log4j.infoLog("switch the frame");
  	     String message= UTF.findElement("xpath", "//form[@id='dynamic_curd_pagination']/following::div[1]").getText();
  	     Log4j.infoLog(message); 
  	    if(message.equals("NO DATA")) {
  	    	UTF.clickelement("xpath", ".//*[@id='action']/img");
  	    	Log4j.infoLog("click the plse button");
  	    }
  	    else {
  	    	Log4j.infoLog("data is present edit on it");
  	    }
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
  	     UTF.clickelement("partialLinkText", "6");
  	     Log4j.infoLog("select DAY ");
  	     UTF.selectByValue("className", "ui-datepicker-year", JoiningDateyear);
  	     Log4j.infoLog("select JoiningDateyear ");
  	     
  	     UTF.inputText("id", "Emp_ID", EmployeeID);
  	     Log4j.infoLog("EmployeeID ");
  	  
  	     UTF.clickelement("id", "DOB");
  	     Log4j.infoLog("select DateOfBirth ");
  	     Sync.procesWait(2000);
  	     UTF.selectByVisibleText("className", "ui-datepicker-month", DateOfBirthmonth);
  	     Log4j.infoLog("select DateOfBirth month ");
  	     UTF.clickelement("partialLinkText", "6");
  	     Log4j.infoLog("Day selected ");
  	     Sync.implicitwait(2000);
  	     UTF.selectByValue("className", "ui-datepicker-year", DateOfBirthyear);
  	     Log4j.infoLog("select DateOfBirthyear ");
  	     UTF.clickelement("xpath", ".//*[@id='adduser']/div[21]/button");
  	     
	   
       }
   
      public void checking_manager_usersRoles() {
    	  Sync.procesWait(2000);
    	  UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
   	      Sync.procesWait(2000);
   	   UTF.clickelement("xpath", ".//*[@id='item_127']/tr[1]/td[5]/button");
   	  Sync.procesWait(2000);
   	  List<WebElement> elements=UTF.findelements("xpath", ".//*[@id='item_127']/tr/td/h4/span");
   	      for(WebElement text:elements){
   	    	   System.out.println(text.getText());
   	      }
   	      
   	   	  Sync.procesWait(2000);
   	    UTF.clickelement("partialLinkText", "Update");  
   	      
   	      
   	  // UTF.clickelement("xpath", ".//*[@id='item_127']/tr[1]/td[5]/button");
   	      
   	      
   	     // UTF.clickelement("xpath", ".//*[@id='item_127']/tr[1]/td[5]/button");
   	      
      }
   
   
       public void user_Privileges_Web() {
    	  Sync.procesWait(2000);
     	  UTF.SwitchToFrameByWebElement("id", "Dynamic_Frame");
     	  Log4j.infoLog("shfiting uberprivilegs sheet");
     	  UTF.clickelement("xpath`", ".//*[@id='usertab_privilleges']");
     	  Sync.procesWait(2000);
     	  UTF.selectByVisibleText("id", "userrole", "Manager");
     	  Sync.procesWait(2000);
     	  UTF.clickelement("linkText", "manoj kumar");
    	   
       }
   
   
   
   
}
