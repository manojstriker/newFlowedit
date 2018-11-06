package testCases.MyService.MarketingAutomation.Organization.Branch;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.Organization.BranchesComponeat;

import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Verifying_BranchTable_features {
	@Test
	    public void verifying_BranchTable_features() {
		BranchesComponeat branch;
		  try {
			  branch=new BranchesComponeat("MyServices/MarketingAutomation/Organization/Branch.xml","verifying_BranchTable_features");
			  branch. ClickOrganization();
			  branch.ClickBranches();
			  branch.verifying_AddBranchTable_features("addBranchTable_Features");
		
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
