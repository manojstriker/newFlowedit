package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Authentication_OTP_requst {
  @Test
  public void authentication_OTP_requst() {
	  ProjectSetUpComponeat project;
		try {
			project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Sourcetracker.xml","authentication_OTP_requst");
			project.clickFlowEdit();
			UTF.refresh();
			project.clickSourceManagemenet_UpperBord();
			project.clickSourceManagemenet_lowerBord();
			project.click_WebTraffic_UpperBord();
			project.click_WebTraffic_lowerBord();
			project.click_Authentications_UpperBord();
			project.click_Authentications_lowerBord();
			project.click_Authentications_edit();
			project.Authentication_OTP("Authentication_singleSelection");
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
}

}
