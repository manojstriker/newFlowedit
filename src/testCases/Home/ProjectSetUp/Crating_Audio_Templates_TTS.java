package testCases.Home.ProjectSetUp;

import org.testng.annotations.Test;

import pageobject.MyServices.marketingAutomation.home.ProjectSetUpComponeat;
import utilities.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Crating_Audio_Templates_TTS {
	 @Test
	  public void crating_Audio_Templates_TTS()  {
		  ProjectSetUpComponeat project;
		try {
			project = new ProjectSetUpComponeat("MyServices/marketingAutomation/home/projuctSetUp/TemplateSettings.xml","Crating_Audio_Templates_TTS");
			project.clickFlowEdit();
			project.clickOn_ProjectManagement_upperbord();
			project.clickOn_projuctManagement_lowerbord();
			project.clickOn_Template_Settings_Upperbord();
			project.ClickOn_Template_Settings_Lowerbord();
			
			project.clickOn_Audio_Upperbord();
			project.ClickOn_Audio_Lowerbord();
			project.clickOn_Audio_Editoption();
			project.clickPlsebuttion();
			project.crating_Audio_Templates_TTS("Text_fromnumbers");
			
			
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
			
		  }

}
