package testCases.MyService.MarketingAutomation.Organization.Hierarchy;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.Organization.HierarchyComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Creating_user_hierarchy {
	@Test
    public void creating_user_hierarchy() {
		HierarchyComponeat hierarchy;
	  try {
		  hierarchy=new HierarchyComponeat("MyServices/MarketingAutomation/Organization/Hierarchy.xml","creating_user_hierarchy");
		  hierarchy.ClickOrganization();
		  hierarchy.click_Hierarchy();
		  hierarchy.click_Departments();
		  hierarchy.click_hierarchyADDing_button();
		  hierarchy.Add_User_Hierarchy("AddUserHierarchy");
		  
		  
	
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
