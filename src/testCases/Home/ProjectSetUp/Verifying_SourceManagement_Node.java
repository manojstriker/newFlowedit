package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_SourceManagement_Node {
  @Test
  public void verifying_SourceManagement_Node() {
	    ProjectSetUpComponeat project;
		try {
			project = new ProjectSetUpComponeat("verifying_SourceManagement_Node");
			project.clickFlowEdit();
			project.clickSourceManagemenet_UpperBord();
			project.clickSourceManagemenet_lowerBord();
			project.delete_SourceManagemenetnode();
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
