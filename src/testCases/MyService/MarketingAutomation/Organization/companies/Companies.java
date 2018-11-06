package testCases.MyService.MarketingAutomation.Organization.companies;

import org.testng.annotations.Test;

import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.Organization.CompaniesComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Companies {
  @Test
  public void companies() {
	  CompaniesComponeat compani;
	  try {
		  compani=new CompaniesComponeat("MyServices/MarketingAutomation/Organization/companies.xml","companies");
		  compani.ClickOrganization();
		  compani.clickCompanies();
		  
		  compani.click_PurchaseApplication();
		//  compani.PurchaseApplication_Solution("Purchase_Application_service");
		  compani.PurchaseApplication_Service("Purchase_Application_service");
		  
		  //compani.purchaseCompany_Service("Purchase_Company_service");
		 // compani.purchaseCompany_Solution("Purchase_Company_solution");
		//  compani.sample("companiTable_name");
		 // compani.verifying_companyTable_features("companiTable_name");
		//  compani.Edit_CompanyDetiles("edit_companyDetiles");
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
