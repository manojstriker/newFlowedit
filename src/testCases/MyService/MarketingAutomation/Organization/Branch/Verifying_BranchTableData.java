package testCases.MyService.MarketingAutomation.Organization.Branch;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.Organization.BranchesComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Verifying_BranchTableData {
	@Test
    public void verifying_BranchTableData() {
	BranchesComponeat branch;
	  try {
		  branch=new BranchesComponeat("MyServices/MarketingAutomation/Organization/Branch.xml","Verifying_BranchTableData");
		  branch. ClickOrganization();
		  branch.ClickBranches();
		  branch.branch_tableData_verifying("brach_data_verfying");
		  branch.branch_table_data_And_features_verifying("branch_table_data_And_features_verifying");
	
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
