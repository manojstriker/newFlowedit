package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_AddCatrgoty_optionNames {
	@Test
	
	  public void verifying_AddCatrgoty_optionNames () throws Exception {
		
		try {
			ProjectSetUpComponeat projuct=new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/smartTableFeture.xml","verifying_AddCatrgoty_optionNames");
			ProjectSetUpComponeat.addcategory_option_names();
			
			
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
