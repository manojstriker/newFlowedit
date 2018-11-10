package testCases.MyService.MarketingAutomation.Organization.Hierarchy;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.Organization.HierarchyComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Verifying_DepartmentsHierarchytablefeatures {
	@Test
    public void verifying_DepartmentsHierarchytablefeatures() {
		HierarchyComponeat hierarchy;
	  try {
		  hierarchy=new HierarchyComponeat("MyServices/MarketingAutomation/Organization/Hierarchy.xml","Verifying_DepartmentsHierarchytablefeatures");
		  hierarchy.ClickOrganization();
		  hierarchy.click_Hierarchy();
		  hierarchy.click_Departments();
		  hierarchy.verifying_DepartmentsHierarchy_features("DepartmentsHierarchytablefeatures");
		  
		  
	
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
