package testCases.Home.ProjectSetUp;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

public class ProjuctSetUp_table_Features_verifying{
  @Test
  public void verifying_ProjuctSetUp_table_Fetures() {
	  try {
		ProjectSetUpComponeat projuctSetup=new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/smartTableFeture.xml","ProjuctSetUp_table_Fetures_verifying");
		ProjectSetUpComponeat.projectSetUp_smart_table_features();
	  } catch (Exception e) {
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
	//.closebrowser();
  }
}