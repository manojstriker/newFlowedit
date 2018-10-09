package testCases.Home.ProjectSetUp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

public class Verifying_pluseButton_InProjucts {
  
	@Test
  public void verifying_pluseButton_InProjucts () {
		try {
			ProjectSetUpComponeat projuxts=new ProjectSetUpComponeat("Verifying_pluseButton_InProjucts") ;
			ProjectSetUpComponeat.plusbuttonIn_projucts();
		}
		catch (Exception e) {
			e.printStackTrace();
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
