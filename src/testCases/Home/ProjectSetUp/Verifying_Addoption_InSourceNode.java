package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_Addoption_InSourceNode {
	@Test
	  public void verifying_Addoption_InSourceNode() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Sourcetracker.xml","verifying_Addoption_InSourceNode");
				project.clickFlowEdit();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.clickSourceTracker_UpperBord();
				project.clickSourceTracker_lowerBord();
				project.clickSource_UpperBord();
				project.clickSource_lowerBord();
				project.clickSource_edit();
				project.addEventIn_SourceNode("events_Names_Adding_SourceNode");
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
		  Browser.closebrowser();
	  }


}
