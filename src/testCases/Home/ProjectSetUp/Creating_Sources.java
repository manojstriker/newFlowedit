package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Creating_Sources {
	 @Test
	  public void creating_Sources() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Sourcetracker.xml","Creating_Sources");
				project.clickFlowEdit();
				
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.clickSourceTracker_UpperBord();
				project.clickSourceTracker_lowerBord();
				project.clickSource_UpperBord();
				project.clickSource_lowerBord();
				project.clickSource_edit();
				project.clickPlsebuttion();
				project.creatingsources("source_Creation_Landing_Page");
				project.creatingsources("source_Creation_Form");
				project.creatingsources("source_Creation_Virtual_Number");
				project.creatingsources("source_Creation_Longcode");
				project.creatingsources("source_Creation_Ads");
				project.creatingsources("source_Creation_Downloads");
				project.creatingsources("source_Creation_Web_Page");
				project.creatingsources("source_Creation_Short_URL");
				project.creatingsources("source_Creation_API");
				project.creatingsources("source_Creation_Email");				
				project.creatingsources("source_Creation_Inside_Team");
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
