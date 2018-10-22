package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Creating_Manger_usercreationFrom {
	@Test
	  public void creating_Manger_usercreationFrom() {
		  ProjectSetUpComponeat project;
		try {
			project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Manager.xml","creating_Manger_usercreationFrom");
			    project.clickFlowEdit();
				project.clickOn_ProjectManagement_upperbord();
				project.clickOn_projuctManagement_lowerbord();
				project.clickOn_USERS_Upperbord();
				project.clickOn_USER_Lowerbord();
				project.clickOn_Manager_Upperbord();
				project.clickOn_Manager_Lowerbord();
				project.clickOn_Manager_Editoption();
				project.clickPlsebuttion();
				project.addManager_user_fields("Managersundeep");
				project.managersubmitbuttion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
		 finally {
			  ProjectSetUpComponeat.delete_ProjectManagement();
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
