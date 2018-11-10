package testCases.MyService.MarketingAutomation.Organization.Branch;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.Organization.BranchesComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Add_branch {
	@Test
    public void add_branch() {
	BranchesComponeat branch;
	  try {
		  branch=new BranchesComponeat("MyServices/MarketingAutomation/Organization/Branch.xml","Add_branch");
		  branch. ClickOrganization();
		  branch.ClickBranches();
		 
		  branch.Add_branch("addBranchTable");
		 
	
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
