package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_FlowEdit_buttion_Marketing {
	
	
  @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
  public void verifying_FlowEdit_buttion() {
	  try {
		ProjectSetUpComponeat project=new ProjectSetUpComponeat("verifying_FlowEdit_buttion");
		project.clickFlowEdit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
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
