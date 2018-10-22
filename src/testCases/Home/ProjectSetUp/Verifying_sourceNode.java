package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_sourceNode {
	 @Test
	  public void verifying_sourceNode() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("Verifying_sourceNode");
				project.clickFlowEdit();
				UTF.refresh();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.clickSourceTracker_UpperBord();
				project.clickSourceTracker_lowerBord();
				project.clickSource_UpperBord();
				project.clickSource_lowerBord();
				project.clickSource_edit();
				project.delete_SourceNode();
			    }
				catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
				    }
			/* finally {
				 ProjectSetUpComponeat.delete_SourceManagemenetnode();
			  } 
			  */  
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  Login.LoginWithAdmin("MyServices//AdminLogin.xml");
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }

}
