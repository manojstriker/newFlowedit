package testCases.Home.DashBord;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.DashBordcomponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Dashbord_Todaycalls_verifying {
  @Test
  public void f() {
	  try {
		DashBordcomponeat dashbord=new DashBordcomponeat("Dashbord_Todaycalls_verifying");
		DashBordcomponeat.verifying_todayCalls();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 DashBordcomponeat.verifying_dashboardfeatures("Today Calls");
  }
  @BeforeMethod
  public void beforeMethod() {
	  Login.LoginWithAdmin("MyServices//AdminLogin.xml");
  }

  @AfterMethod
  public void afterMethod() {
  }

}
