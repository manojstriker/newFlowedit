package testCases.Home.DashBord;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.DashBordcomponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class verifying_plusbuttonfeatures {
  @Test
  public void verifying_plusbutton_features() {
	  try {
		DashBordcomponeat dashbord=new DashBordcomponeat("verifying_plusebuttonfeatures");
		DashBordcomponeat.verifying_plusbuttonfeatures();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
  }
  @BeforeMethod
  public void beforeMethod() {
	  Login.LoginWithAdmin("MyServices//AdminLogin.xml");
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
