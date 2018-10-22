package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_CONNECTOR_Node {
	 @Test
	  public void verifying_CONNECTOR_Node() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("Verifying_CONNECTOR_Node");
				project.clickFlowEdit();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.click_CONNECTOR_UpperBord();
				project.click_CONNECTOR_lowerBord();
				project.click_CONNECTOR_edit();
				project.delete_CONNECTOR_Node();
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
