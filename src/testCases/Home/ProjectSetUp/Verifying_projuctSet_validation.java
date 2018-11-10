package testCases.Home.ProjectSetUp;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

public class Verifying_projuctSet_validation {
	@Test(retryAnalyzer=utilities.RetryAnalyzer.class)
	
	  public void projuctSet_validation () throws Exception {
		
		try {
			ProjectSetUpComponeat project=new ProjectSetUpComponeat("Verifying_projuctSet_validation");
			ProjectSetUpComponeat.projuctSetUpCreation();
	
			
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
		  //Browser.closebrowser();
	  }
}
