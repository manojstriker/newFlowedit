package testCases.Home.DashBord;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.DashBordcomponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Verifying_Dashbord_plusebutton {
  @Test
  public void verifying_Dashbord_plusebutton() throws Exception {
	  DashBordcomponeat dashbord=new DashBordcomponeat("Verifying_Dashbord_plusebutton");
	   DashBordcomponeat.verifying_plusbutton();
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
