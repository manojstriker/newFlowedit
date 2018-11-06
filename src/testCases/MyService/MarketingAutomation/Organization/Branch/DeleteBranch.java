package testCases.MyService.MarketingAutomation.Organization.Branch;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.Organization.BranchesComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class DeleteBranch {
	@Test
    public void editdate_branch() {
	BranchesComponeat branch;
	  try {
		  branch=new BranchesComponeat("MyServices/MarketingAutomation/Organization/Branch.xml","Editdate_branch");
		  branch.ClickOrganization();
		  branch.ClickBranches();
		  branch.deleteBranch("deletebranch");
		  
	
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
