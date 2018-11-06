package testCases.MyService.MarketingAutomation.Organization.Divisions;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.Organization.DivisionsComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AddDivision {
	@Test
    public void addDivision() {
		DivisionsComponeat division;
	  try {
		  division=new DivisionsComponeat("MyServices/MarketingAutomation/Organization/Division.xml","addDivision");
		  division. ClickOrganization();
		  division.click_Divisions();
		  
		  division.app();
		 // division.Add_Division("divisionCreation_cxo");
		//  division.update("divisionCreation_cxo");
		 
	
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
