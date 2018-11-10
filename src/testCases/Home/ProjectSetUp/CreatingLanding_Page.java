package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import ActionDriver.UTF;
import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CreatingLanding_Page {
  @Test
  public void creatingLanding_Page() {
	  ProjectSetUpComponeat project;
		try {
			project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/Sourcetracker.xml","CreatingLanding_Page");
			project.clickFlowEdit();
			UTF.refresh();
			project.clickSourceManagemenet_UpperBord();
			project.clickSourceManagemenet_lowerBord();
			project.clickBuilder_UpperBord();
			project.clickBuilder_lowerBord();
			project.click_landingpage_UpperBord();
			project.click_landingpage_lowerBord();
			project.click_landingpage_edit();
			project.Art_Board_Properties_submitbutton();
			project.Click_Default_Templates_forms();
			project.DefaltCategoryType();
		    }
			catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			    }
		
		   
}
@BeforeMethod
public void beforeMethod() {
	  Login.LoginWithAdmin("MyServices//AdminLogin.xml");
	  
}

@AfterMethod
public void afterMethod() {
}
}
