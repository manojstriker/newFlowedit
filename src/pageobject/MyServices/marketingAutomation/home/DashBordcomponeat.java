package pageobject.MyServices.marketingAutomation.home;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import ActionDriver.Sync;
import ActionDriver.UTF;
import bsh.This;
import utilities.Log4j;
import utilities.Login;
import utilities.XmlReader;

public class DashBordcomponeat {
	XmlReader readData;
	 public DashBordcomponeat (String filename,String className) throws Exception{
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
		  
		 }
	 public DashBordcomponeat (String className) throws Exception{
		  UTF.callLog4j(className);
		 }
	
	public static void verifying_dashboardfeatures(String featurename) {
		  HomeComponent.clickhomebutton();
		  Log4j.infoLog("click the home button");
		   HomeComponent.clickDashBord();
		   Log4j.infoLog("click the dash button");
	// Sync.presenceofElementLocated("className", "campain-re-title", 30);
		 // Sync.presenceofElementsLocated("className", "campain-re-title", 60);
		   Sync.procesWait(1600);  
		   List<WebElement> feautures= UTF.findelements("className", "campain-re-title");
		   Iterator<WebElement> datas = feautures.iterator();
		   while(datas.hasNext()) {
		   WebElement we = datas.next();
           if (we.getText().equals(featurename) ){
		   System.out.println("featurepresent in dash bord");
		   }
		   }
		   }
	
	  public static void verifying_plusebuttonfeatures() {
		  DashBordcomponeat.verifying_plusebutton();
		  Sync.procesWait(1600);
		  List<WebElement> oCheckBox= UTF.findelements("className", "filter-search");
		   for(WebElement element:oCheckBox) {
			   String features=element.getText();
			   System.out.println(features);
			   
		     }
		
		   
	  }
	 
	  
	 public static void  verifying_plusebutton() {
		 HomeComponent.clickhomebutton();
		   Log4j.infoLog("click the home button");
		   HomeComponent.clickDashBord();
		   Log4j.infoLog("click the dash button");
		   Sync.procesWait(1600); 
		   boolean disply=UTF.findElement("className", "smart-add").isDisplayed();
		   boolean selected=UTF.findElement("className", "smart-add").isSelected();
		   if(disply ) {
			   UTF.clickelement("className", "smart-add");
			   System.out.println("verifying_plusebutton is  working ");
			   
		   }
		   else {
			   System.out.println("verifying_plusebutton is not working ");
		   }
	 }
	
	
	
	
	
	
	 public static void verifying_todayCalls(){
		 HomeComponent.clickhomebutton();
		 HomeComponent.clickDashBord();
		 Sync.procesWait(4000);
		 List<WebElement> futures=UTF.findelements("xpath", "//span[text()='Today Calls']/following::tr[1]/th[*]");
		 System.out.println(futures.size());
		 for(int i=0;i<futures.size();i++) {
			   System.out.println(futures.get(i).getText());
			   
			 
		 
		 
		 /* Iterator<WebElement> datas = futures.iterator();
		 while(datas.hasNext()) {
			   WebElement we = datas.next();
			   System.out.println(datas.next().getText());
	          // if (we.getText().equals(futurename) ){
			   System.out.println("futurepresent in dash bord");
		 */
	 }
	
	 }
}


