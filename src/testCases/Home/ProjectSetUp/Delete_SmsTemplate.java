package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Delete_SmsTemplate {
	@Test
	  public void delete_SmsTemplate()  {
		  ProjectSetUpComponeat project;
		try {
			project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/TemplateSettings.xml","delete_SmaSendername_creation");
			project.clickFlowEdit();
			project.clickOn_ProjectManagement_upperbord();
			project.clickOn_projuctManagement_lowerbord();
			project.clickOn_Template_Settings_Upperbord();
			project.ClickOn_Template_Settings_Lowerbord();
			project.clickOn_SMS_Upperbord();
			project.clickOn_SMS_Lowerbord();
			project.clickOn_MARKETING_SMS_TEMPLETES_Upperbord();
			project.clickOn_MARKETING_SMS_TEMPLETES_Lowerbord();
			project.clickOn_MARKETING_SMS_TEMPLETES_Editoption();
			project.SmsTemplate_deletion("smstemplate_wish");
			//project.creationSmsTemplate("smstemplate_wish");
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
