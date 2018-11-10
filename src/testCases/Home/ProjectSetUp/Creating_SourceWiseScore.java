package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Creating_SourceWiseScore {
	 @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
	  public void creating_SourceWiseScore() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/CustomerScore.xml","creating_SourceWiseScore");
				project.clickFlowEdit();
				UTF.refresh();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.click_CustomerScore_UpperBord();
				project.click_CustomerScore_lowerBord();
				project.click_SourceWise_UpperBord();
				project.click_SourceWise_lowerBord();
				project.click_SourceWise_edit();
				project.deleteSourcetypesscoreTable();
				//project.clickPlsebutton();
			//	project.SourceWiseScore("SourceWise");
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
		 // UTF.closebrowser();
	  }
}
