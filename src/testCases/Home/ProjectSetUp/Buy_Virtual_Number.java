package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Buy_Virtual_Number {
	@Test
	  public void buy_Virtual_Number() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Sourcetracker.xml","Buy_Virtual_Number");
				project.clickFlowEdit();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.click_VIRTUAL_NUMBER_UpperBord();
				project.click_VIRTUAL_NUMBER_lowerBord();
				project.click_VIRTUAL_NUMBER_edit();
				project.clickPlsebutton();
				project.buy_Virtual_Number("Buy_VirtualNumber_Land_Line_SILVER");
				//project.delete_Virtual_Number_allocation("delete_VirtualNumber_allocationCall_Forwarding");
				//project.Virtual_Number_allocation_Missedcall("VirtualNumber_allocationMissedcall");
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
