package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;


import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class VirtualNumber_allocation_For_Missedcall {
	@Test
	  public void virtualNumber_allocation_For_Missedcall() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Sourcetracker.xml","virtualNumber_allocation_For_Missedcall");
				project.clickFlowEdit();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.click_VIRTUAL_NUMBER_UpperBord();
				project.click_VIRTUAL_NUMBER_lowerBord();
				project.click_VIRTUAL_NUMBER_edit();
				project.clickeplusbutton();
				project.Virtual_Number_allocation_Missedcall("VirtualNumber_allocationMissedcall");
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
