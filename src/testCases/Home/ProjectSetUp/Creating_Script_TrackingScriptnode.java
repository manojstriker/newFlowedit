package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Creating_Script_TrackingScriptnode {
	 @Test
	  public void creating_Script_TrackingScriptnode() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Sourcetracker.xml","Creating_Script_TrackingScriptnode");
				project.clickFlowEdit();
				
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.click_Website_Tracker_UpperBord();
				project.click_Website_Tracker_lowerBord();
				project.click_Tracking_script_UpperBord();
				project.click_Tracking_script_lowerBord();
				project.click_STracking_script_edit();
				project.clickPlsebutton();
				project.creation_trckerScrept("source_Creation_Form_TrackingScript");
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
