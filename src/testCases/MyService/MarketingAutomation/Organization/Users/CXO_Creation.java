package testCases.MyService.MarketingAutomation.Organization.Users;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.Organization.UsersComponeat;
import utilities.Login;

public class CXO_Creation {
	@Test
    public void cXO_Creation() {
		UsersComponeat user;
	  try {
		  user=new UsersComponeat("MyServices/MarketingAutomation/Organization/user.xml","addDivision");
		 
		  user.ClickOrganization();
		  user.click_Users();
		  user.clcik_CXO();
		  user.verifying_Users_features("userTableFeatures");
		  user. click_UserCreationPlseButton();
		  user.userCeation("cxo_user");
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
