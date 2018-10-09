package testCases.Home.DashBord;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.DashBordcomponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class verifying_plusebuttonfeatures {
  @Test
  public void verifying_plusebutton_features() {
	  try {
		DashBordcomponeat dashbord=new DashBordcomponeat("verifying_plusebuttonfeatures");
		DashBordcomponeat.verifying_plusbuttonfeatures();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
  }
  @BeforeMethod
  public void beforeMethod() {
	 // Browser.startBrowser("Firefox", "http://demo.office24by7.com/");
	  //Login.LoginWithAdminUser();
	  Login.LoginWithAdmin("MyServices//AdminLogin.xml");
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  Browser.closebrowser();
  }

}
