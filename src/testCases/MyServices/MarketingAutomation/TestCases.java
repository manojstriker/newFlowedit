package testCases.MyServices.MarketingAutomation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.MyServices.MarketingAutomation;
import utilities.Login;

public class TestCases 
{

	@Test
	public void salesValidation()
	{
		try {
			MarketingAutomation market=new MarketingAutomation("", "Testcase");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	@BeforeMethod
	public void login()
	{
		Login.LoginWithAdminUser();
	}
	
}
