package testCases.MyServices.MarketingAutomation;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import basedriver.Browser;
import pageobject.MyServices.marketingAutomation.home.HomeComponent;
import utilities.Login;

import org.testng.annotations.BeforeMethod;

import javax.security.auth.login.LoginException;

import org.testng.annotations.AfterMethod;

public class NewTest {
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	
	//  Browser.startBrowser("chrome", "http://demo.office24by7.com/");
	  //Browser.startBrowser("chrome", "http://demo.office24by7.com/");
	//UTF.clickelement("partialLinkText", "Login");
	//UTF.clickelement("id", "loginsubmit");
	 
	Login.LoginWithAdmin("MyServices//AdminLogin.xml");
	//HomeComponent.clickhomeof();
	// HomeComponent.clickDashBord();
	
	HomeComponent.clickhomebutton();
	HomeComponent.clickDashBord();
    HomeComponent.clickProjectSetUp();
	HomeComponent.clickChat();
	
	HomeComponent.clickReports();
	HomeComponent.clickProfile();
	
	
	 //Login.LoginWithAdminUser();
	// Login.LoginWithAdminUser();
	  //Login.LoginWithAdminUser();
	 // HomeComponent.clickDashBord();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
