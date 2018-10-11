package testCases.Home.ProjectSetUp;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

public class Sample {
	
		@Test
		
		  public void projuctSet_validation () throws Exception {
			ProjectSetUpComponeat project=new ProjectSetUpComponeat("Verifying_projuctSet_validation");
			try {
				project.clickFlowEdit();
				project.clickOn_ProjectManagement_upperbord();
				project.clickOn_projuctManagement_lowerbord();
			
				project.clickOn_USERS_Upperbord();
				project.clickOn_User_Lowerbord();
				project.clickOn_Manager_Upperbord();
				project.clickOn_Manager_Lowerbord();
				project.clickOn_Manager_Editoption();
				
				
				/*ProjectSetUpComponeat.clickOn_CXO_Upperbord();
				ProjectSetUpComponeat.clickOn_CXO_Lowerbord();
				ProjectSetUpComponeat.clickOn_CXO_Editoption();
				*/
		
				
			}
			catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
			finally {
				project.delete_Manager();			}
		  }
		  @BeforeMethod
		  public void beforeMethod() {
			  Login.LoginWithAdmin("MyServices//AdminLogin.xml");
			 
			
		  }

		  @AfterMethod
		  public void afterMethod() {
			  //Browser.closebrowser();
		  }
}
