package testCases.Home.ProjectSetUp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

public class InvalidPasswordvalidation_manager {
  @Test
  public void invalidPasswordvalidation_manager() {
	  try {
		ProjectSetUpComponeat project=new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Manager.xml","InvalidPasswordvalidation_manager");
		 project.clickFlowEdit();
		    project. edit_flows_settingfor_manger(); 
			/*project.clickOn_ProjectManagement_upperbord();
			project.clickOn_projuctManagement_lowerbord();
			project.clickOn_USERS_Upperbord();
			project.clickOn_USER_Lowerbord();
			project.clickOn_Manager_Upperbord();
			project.clickOn_Manager_Lowerbord();
		    project.clickOn_Manager_Editoption();
			*/
		    project.clickPlsebuttio();
			project.inavalidpasswordvalidation("invalidpassword");
			project.inavalidpasswordvalidation("lowcharcter");
			project.inavalidpasswordvalidation("upperlatters");
			project.inavalidpasswordvalidation("nummbers");
			project.managersubmitbuttion();
		
		//project.inavalidpasswordvalidation("");
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
