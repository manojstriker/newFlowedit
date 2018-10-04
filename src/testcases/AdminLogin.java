package testcases;

import basedriver.Browser;
import pageobject.AdminLogincomponet;

public class AdminLogin {
   public static void main(String[] args) throws Exception {
	   Browser.startBrowser("Chrome", "http://demo.office24by7.com/");
	   AdminLogincomponet admins=new AdminLogincomponet(System.getProperty("user.dir")+"//Lib//AdminLogin.xlsx"); 
	 //  admin.Adminlogin("Sheet1");
	   
}
}
