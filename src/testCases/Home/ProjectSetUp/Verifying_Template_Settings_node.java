package testCases.Home.ProjectSetUp;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

public class Verifying_Template_Settings_node {
	@Test
	  public void verifying_Template_Settings_node() {
		  try {
			ProjectSetUpComponeat project=new ProjectSetUpComponeat("verifying_Template_Settings_node");
			project.clickFlowEdit();
			project.clickOn_ProjectManagement_upperbord();
			project.clickOn_projuctManagement_lowerbord();
			project.clickOn_Template_Settings_Upperbord();
			project.ClickOn_Template_Settings_Lowerbord();
			project.delete_Template_Settings();
		
			

			
		} 
		  catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
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
