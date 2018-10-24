package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import basedriver.Browser;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_USERNode_merketing_Marketing {
  @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
  public void verifying_USERnode() {
	  try {
		ProjectSetUpComponeat project=new ProjectSetUpComponeat("Verifying_USERNode_merketing_Marketing");
		project.clickFlowEdit();
		project.clickOn_ProjectManagement_upperbord();
		project.clickOn_projuctManagement_lowerbord();
		project.clickOn_USERS_Upperbord();
		project.clickOn_USER_Lowerbord();
		project.delete_USER();
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
		 Browser.closebrowser();
	  }

	}
