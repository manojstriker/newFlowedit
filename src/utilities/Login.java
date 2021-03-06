package utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

import ActionDriver.Sync;
import ActionDriver.UTF;
import basedriver.Browser;

public class Login 
{
	
	public static void LoginWithAdmin(String filepath)
	{
		try {
			Browser.startBrowser("Chrome", "http://10.10.10.3/office24by7");
			XmlReader readData=new XmlReader(filepath);
			String username=readData.getdata("AdminLogin", "username");
			String password=readData.getdata("AdminLogin", "password");
			Sync.procesWait(2000);
			UTF.clickelement("xpath", ".//*[@class='nav-item office-login']/a");
	        UTF.inputText("id", "username", username);
	        UTF.inputText("id", "password", password);
	        UTF.clickelement("id", "loginsubmit");
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public static void LoginWithAdminUser()
	{
		try {
			
			PropertiesReusabuls properies=new PropertiesReusabuls(System.getProperty("user.dir")+"//src//Configurations//config.properties");
					//System.getProperty("user.dir")+"\\src\\Configurations\\config.properties");
			String username=properies.getProperty("AdminUserName");
			String password=properies.getProperty("AdminPassword");
			Browser.startBrowser();
			UTF.clickelement("partialLinkText", "Login");
	       UTF.inputText("id", "username", username);
	       UTF.inputText("id", "password", password);
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public static void LoginWithReportingUser()
	{
		try {
			
			PropertiesReusabuls properies=new PropertiesReusabuls(System.getProperty("user.dir")+"\\src\\Configurations\\config.properties");
			String username=properies.getProperty("ReportingUserName");
			String password=properies.getProperty("ReportingPassword");
			Browser.startBrowser();
			UTF.clickelement("partialLinkText", "Login");
	       UTF.inputText("id", "username", username);
	       UTF.inputText("id", "password", password);
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
