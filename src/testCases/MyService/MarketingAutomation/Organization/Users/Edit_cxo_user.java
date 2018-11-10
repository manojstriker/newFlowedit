package testCases.MyService.MarketingAutomation.Organization.Users;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.Organization.UsersComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Edit_cxo_user {
	@Test
    public void cXO_Creation() {
		UsersComponeat user;
	  try {
		  user=new UsersComponeat("MyServices/MarketingAutomation/Organization/user.xml","addDivision");
		 
		  user.ClickOrganization();
		  user.click_Users();
		  user.clcik_CXO();
		  user.IsAvalable("cxo_user_edit");
		  //user.update_User("cxo_user_edit");
		 
		  }
	  catch (Exception e) {
		  e.printStackTrace();
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
