package testCases.MyService.MarketingAutomation.MyAccount.currentPlan;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.MyAccount.CurrentPlanComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Verifying_currentPlan_Componeat_table {
	@Test
    public void verifying_currentPlan_Componeat_table() {
		CurrentPlanComponeat currentPlan;
	  try {
		  currentPlan=new CurrentPlanComponeat("MyServices/MarketingAutomation/MyAccount/currentplan.xml","creating_user_hierarchy");
		  currentPlan.MyAccount();
		  currentPlan.CurrentPlan();
		  currentPlan.Action_numberDetiles("numberplan");
		//  currentPlan.current_data_verifying("currentplanTable");
		  
		  
	
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
   //  Browser.closebrowser();
      }


}
