package testCases.MyServices.MarketingAutomation;

import org.testng.annotations.BeforeMethod;

import utilities.Login;

public class Test 
{

	
	public void salesValidation()
	{
		
		
	}
	
	@BeforeMethod
	public void login()
	{
		Login.LoginWithAdminUser();
	}
	
}
