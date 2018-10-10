package testCases.Home.ProjectSetUp;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

public class Verifying_addcategory {
	@Test
	
	  public void verifying_addcategor () throws Exception {
		
		try {
			ProjectSetUpComponeat project=new ProjectSetUpComponeat("verifying_addcategory_displayed");
			ProjectSetUpComponeat.addcategory();
	
			
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
