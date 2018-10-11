package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Demotestings {
		  @Test
		  public void Demotestings() {
			  try {
				ProjectSetUpComponeat projuctSetup=new ProjectSetUpComponeat("Demotestings");
				//ProjectSetUpComponeat.clickFlowEdit();
				ProjectSetUpComponeat.clickOn_ProjectManagement_upperbord();
				//ProjectSetUpComponeat.clickOn_ProjectManagement_delete();
				ProjectSetUpComponeat.clickOn_projuctManagement_lowerbord();
				ProjectSetUpComponeat.ClickOn__userprivilleges_Upperbord();
			//	ProjectSetUpComponeat.ClickOn__userprivilleges_lowerbord();
				ProjectSetUpComponeat.clickOn_USERS_Upperbord();
				ProjectSetUpComponeat.clickOn_User_Lowerbord();
				ProjectSetUpComponeat.clickOn_CXO_Upperbord();
				ProjectSetUpComponeat.clickOn_CXO_Lowerbord();
				ProjectSetUpComponeat.clickOn_CXO_Editoption();
				
				
			  } catch (Exception e) {
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
			//.closebrowser();
		  }
}
