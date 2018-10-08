package testCases.Home.Profile;

import org.testng.annotations.Test;


import pageobject.MyServices.marketingAutomation.home.Profilecomponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Upload_companyregistration_certificate {
  @Test
  public void upload_companyregistration_certificate () throws Exception {
	  Profilecomponeat profile=new Profilecomponeat("Upload_companyregistration_certificate");
		
		try {
			Profilecomponeat.verifying_profilefileuploading();
			
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
