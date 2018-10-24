package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Creating_eventname {
	 @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
	  public void creating_eventname() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Sourcetracker.xml","Creating_eventname");
				project.clickFlowEdit();
				UTF.refresh();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.clickSourceTracker_UpperBord();
				project.clickSourceTracker_lowerBord();
				project.clickEvents_UpperBord();
				project.clickEvents_lowerBord();
				project.clickEvents_edit();
				project.clickeplusbutton();
				project.creatingEvents("eventname_summeroffers");
				UTF.SwitchToDefaltFrame();
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
