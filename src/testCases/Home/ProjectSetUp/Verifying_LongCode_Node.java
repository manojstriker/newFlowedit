package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_LongCode_Node {
	 @Test
	  public void verifying_LongCode_Node() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("Verifying_LongCode_Node");
				project.clickFlowEdit();
				UTF.refresh();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.click__LongCode_UpperBord();
				project.click_LongCode_lowerBord();
				project.click_LongCode_edit();
				project.delete_LongCode_Node();
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
