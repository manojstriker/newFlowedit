package testCases.Home.ProjectSetUp;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

public class Sample {
	
		@Test
		
		   public void projuctSet_validation () throws Exception {
			ProjectSetUpComponeat project=new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/marketing_EMAIL_SETTINGSUploadingform.xml","Verifying_projuctSet_validation");
			try {
				
				
				
	
				/*project.clickOn_ProjectManagement_upperbord();
				project.clickOn_projuctManagement_lowerbord();
				project.ClickOn__userprivilleges_Upperbord();
				project.ClickOn__userprivilleges_lowerbord();
				
				project.ClickOn_userPrivilleges_Editoption();
				project.user_Privileges_Web();
				*/
				
				project.clickFlowEdit();
				project.clickOn_ProjectManagement_upperbord();
				project.clickOn_projuctManagement_lowerbord();
				project.clickOn_Template_Settings_Upperbord();
				project.ClickOn_Template_Settings_Lowerbord();
				project.clickOn_Email_Upperbord();
				project.ClickOn_Email_Lowerbord();
				project.clickOn_MARKETING_EMAIL_SETTINGS_Upperbord();
				project.ClickOn_MARKETING_EMAIL_SETTINGS_Lowerbord();
				project.clickOn_MARKETING_EMAIL_SETTINGS_Editoption();
				project.marketing_EMAIL_SETTINGS_dataupload();
				
				
		
				
				
				
				
				
				/*project.clickFlowEdit();
				project.clickOn_ProjectManagement_upperbord();
				project.clickOn_projuctManagement_lowerbord();
		
				project.clickOn_Template_Settings_Upperbord();
                project.ClickOn_Template_Settings_Lowerbord();
                project.clickOn_SMS_Upperbord();
                project.ClickOn_SMS_Lowerbord();
                
                project.clickOn_SENDER_NAMES_Upperbord();
                project.ClickOn_SENDER_NAMES_Lowerbord();
                project.clickOn_SENDER_NAMES_Editoption();
                project.delete_SENDER_NAMES();
                
                project.clickOn_MARKETING_SMS_TEMPLETES_Upperbord();
                project.ClickOn_MARKETING_SMS_TEMPLETES_Lowerbord();
                project.clickOn_MARKETING_SMS_TEMPLETES_Editoption();
                project.delete_MARKETING_SMS_TEMPLETES();
                
                project.delete_SMSStore();
                
        
                project.clickOn_Email_Upperbord();
                project.ClickOn_Email_Lowerbord();
                project.clickOn_MARKETING_EMAIL_SETTINGS_Upperbord();
                project.ClickOn_MARKETING_EMAIL_SETTINGS_Lowerbord();
                project.clickOn_MARKETING_EMAIL_SETTINGS_Editoption();
                project.delete_MARKETING_EMAIL_SETTINGS();
                
                project.dalete_EmailStore();
                
                project.clickOn_Audio_Upperbord();
                project.ClickOn_Audio_Lowerbord();
                project.clickOn_Audio_Editoption();
                project.delete_AudioStore();
                project.delete_Template_Settings();
			    project.clickOn_ProjectManagement_delete();
				
				
				
				
				
				/* project.clickOn_USERS_Upperbord();
				project.clickOn_User_Lowerbord();
				project.clickOn_CXO_Upperbord();
				project.clickOn_CXO_Lowerbord();
				project.clickOn_CXO_Editoption();
				project.addCXOfields();
				
				/*project.clickOn_Manager_Upperbord();
				project.clickOn_Manager_Lowerbord();
				project.clickOn_Manager_Editoption();
				project.addManagerfields();
				project.delete_Manager();
				
				
				/*ProjectSetUpComponeat.clickOn_CXO_Upperbord();
				ProjectSetUpComponeat.clickOn_CXO_Lowerbord();
				ProjectSetUpComponeat.clickOn_CXO_Editoption();
				*/
		
				
			}
			catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
			/*finally {
				project.clickOn_ProjectManagement_delete();			}
			*/	
		  }
		 
		  @BeforeMethod
		  public void beforeMethod() {
			  Login.LoginWithAdmin("MyServices//AdminLogin.xml");
			 
			
		  }

		  @AfterMethod
		  public void afterMethod() {
			  //Browser.closebrowser();
		  }
}
