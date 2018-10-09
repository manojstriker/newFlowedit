package testCases.Home.DashBord;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.DashBordcomponeat;
import utilities.Login;

public class DashBordfeauturesVerfying {
	@Test
	
	  public void dashBordfuturesVerfying () throws Exception {
		DashBordcomponeat dashbord=new DashBordcomponeat("DashBordfeauturesVerfying");
		 DashBordcomponeat.verifying_dashboardfeatures("Today Calls");
		try {
			DashBordcomponeat.verifying_todayCalls();
			//Assert.fail();
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
