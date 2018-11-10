package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CreatingLongCode {
	 @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
	  public void creatingLongCode() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/LongCode.xml","CreatingLongCode");
				project.clickFlowEdit();
				UTF.refresh();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.click_LongCode_UpperBord();
				project.click_LongCode_lowerBord();
				project.click_LongCode_edit();
				project.clickeplusbutton();
				project.filling_LongCode("longcode");
			    }
				catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
				    }
			 finally {
				 ProjectSetUpComponeat.delete_SourceManagemenetnode();
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
