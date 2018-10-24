package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Verifying_ProductCosting_node {
  @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
 
  public void verifying_ProductCosting_node() {
	    ProjectSetUpComponeat project;
		try {
			project = new ProjectSetUpComponeat("Verifying_ProductCosting_node");
			project.clickFlowEdit();
			UTF.refresh();
			project.clickSourceManagemenet_UpperBord();
			project.clickSourceManagemenet_lowerBord();
			UTF.refresh();
			project.clickProductCosting_UpperBord();
			project.clickProductCosting_lowerBord();
			project.clickProductCosting_Edit();
			project.delete_ProductCostingnode();
		    }
			catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			    }
		finally {
			 ProjectSetUpComponeat.delete_SourceManagemenetnode();
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
