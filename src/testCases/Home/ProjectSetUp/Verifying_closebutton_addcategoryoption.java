package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_closebutton_addcategoryoption {
	@Test
	 public void verifying_closebutton_addcategoryoption () throws Exception {
		
		try {
			ProjectSetUpComponeat projuct=new ProjectSetUpComponeat("verifying_closebutton_addcategoryoption");
			ProjectSetUpComponeat.closebutton_addcategory_option();
			
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
