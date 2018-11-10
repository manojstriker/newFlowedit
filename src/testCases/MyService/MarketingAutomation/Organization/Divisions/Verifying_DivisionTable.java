package testCases.MyService.MarketingAutomation.Organization.Divisions;

import org.testng.annotations.Test;

import basedriver.Browser;

import pageobject.MyServices.marketingAutomation.Organization.DivisionsComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Verifying_DivisionTable {
	@Test
    public void add_branch() {
		DivisionsComponeat division;
	  try {
		  division=new 		DivisionsComponeat("MyServices/MarketingAutomation/Organization/Division.xml","Add_branch");
		  division. ClickOrganization();
		  division.click_Divisions();
		  division.verifying_DivisionTable_features("DivisionTableFeatures");
		  
		 
	
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
      Browser.closebrowser();
      }
}
