package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Creating_ConnectorConfiguration {
	 @Test
	  public void creating_ConnectorConfiguration() {
		    ProjectSetUpComponeat project;
			try {
				project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Connector.xml","Creating_ConnectorConfiguration");
				project.clickFlowEdit();
				project.clickSourceManagemenet_UpperBord();
				project.clickSourceManagemenet_lowerBord();
				project.click_CONNECTOR_UpperBord();
				project.click_CONNECTOR_lowerBord();
				project.click_CONNECTOR_edit();
			    project.Connector_Configuration("connector");
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
