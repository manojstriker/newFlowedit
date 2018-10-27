package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_SourceTrackerNode {
	 @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
	 
	  public void verifying_SourceTrackerNode() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("Verifying_SourceTrackerNode");
				project.clickFlowEdit();
				UTF.refresh();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.clickSourceTracker_UpperBord();
				project.clickSourceTracker_lowerBord();
				project.delete_SourceTrackernode();
				
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
