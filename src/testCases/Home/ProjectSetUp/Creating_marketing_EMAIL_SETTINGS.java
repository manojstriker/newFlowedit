package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Creating_marketing_EMAIL_SETTINGS {
	 @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
	  public void creating_marketing_EMAIL_SETTINGS()  {
		  ProjectSetUpComponeat project;
		try {
			project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/TemplateSettings.xml","Creating_marketing_EMAIL_SETTINGS");
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
			project.marketing_EMAIL_SETTINGS_Creating("emailsettingsform");
		    } 
		catch (Exception e) {
			
			 e.printStackTrace();
		     }
		  finally {
			  ProjectSetUpComponeat.delete_ProjectManagement();
		  }
		   }
		  @BeforeMethod
		  public void beforeMethod() {
			  Login.LoginWithAdmin("MyServices//AdminLogin.xml");
		  }

		  @AfterMethod
		  public void afterMethod() {
			
		  }
}
