package testCases.Home.ProjectSetUp;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

public class UserPrivileges_web {
  @Test
  public void userPrivileges_web() {
	  ProjectSetUpComponeat project;
	try {
		project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/UserPrivileges.xml","UserPrivileges_web");
	                project.clickFlowEdit();
					project.clickOn_ProjectManagement_upperbord();
					project.clickOn_projuctManagement_lowerbord();
					project.clickOn__userprivilleges_Upperbord();
					project.clickOn__userprivilleges_lowerbord();
					project.clickOn_userPrivilleges_Editoption();
					project.userPrivileges_creation_web("Cxo");
					
					
	} catch (Exception e) {
		// TODO Auto-generated catch block
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
	// Browser.closebrowser();
  }
  
  
}
