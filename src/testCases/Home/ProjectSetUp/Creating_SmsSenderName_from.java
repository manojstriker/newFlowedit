package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Creating_SmsSenderName_from {
  @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
  public void creating_SmsSenderName_from() {
  try {
  ProjectSetUpComponeat project=new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/TemplateSettings.xml","creating_SmsSenderName_from");
    project.clickFlowEdit();
    project.clickOn_ProjectManagement_upperbord();
	project.clickOn_projuctManagement_lowerbord();
	project.clickOn_Template_Settings_Upperbord();
	project.ClickOn_Template_Settings_Lowerbord();
	project.clickOn_SMS_Upperbord();
	project.clickOn_SMS_Lowerbord();
	project.clickOn_SENDER_NAMES_Upperbord();
	project.ClickOn_SENDER_NAMES_Lowerbord();
	project.clickOn_SENDER_NAMES_Editoption();
	project.sms_Sendername_creation("smsSendername_sundeep");
	
    }
catch (Exception e) {
	// TODO Auto-generated catch block
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
	 // Browser.closebrowser();
  }
}

