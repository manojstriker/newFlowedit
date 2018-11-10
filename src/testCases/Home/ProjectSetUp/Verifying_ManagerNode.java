package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Verifying_ManagerNode {
  @Test(retryAnalyzer=utilities.RetryAnalyzer.class)
  public void verifying_ManagerNode() {
	  ProjectSetUpComponeat project;
	try {
		project = new ProjectSetUpComponeat("Verifying_ManagerNode");
		    project.clickFlowEdit();
			project.clickOn_ProjectManagement_upperbord();
			project.clickOn_projuctManagement_lowerbord();
			project.clickon_USERS_Upperbord();
			project.clickon_USER_Lowerbord();
			project.clickOn_Manager_Upperbord();
			project.clickOn_Manager_Lowerbord();
			project.clickOn_Manager_Editoption();
			project.delete_Manager();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
