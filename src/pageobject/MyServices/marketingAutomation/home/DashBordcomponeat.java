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
public static	XmlReader readData;
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
	
	  public static void verifying_plusbuttonfeatures() {
		  DashBordcomponeat.verifying_plusbutton();
		  Sync.procesWait(2000);
		 // List<WebElement> oCheckBox= UTF.findelements("className", "filter-search");
		//*[@id="myModal"]/div/div/div[2]/div/form/ul
		//*[@id="myModal"]/div/div/div[2]/div/form/ul/li[6]/div/label/input
		  List<WebElement> oCheckBox= UTF.findelements("xpath", "//ul[@class='filter-search']/li[*]");
		System.out.println(oCheckBox.size());
		  for(int i=0;i<oCheckBox.size();i++) {
		//	String s=  UTF.findElement("xpath", "//ui[@class='filter-search']/li[i]/dive[1]").getText();
			String s=  UTF.findElement("xpath", "//ul[@class='filter-search']/li[i]/following::span[1]").getText();
			String as=  UTF.findElement("xpath", "//ul[@class='filter-search']/li[i]/following::input[1]").getAttribute("checked");
		System.out.println("text is==>"+s);
		System.out.println("checked is==>"+as);
		
		System.out.println("text is==>==================");
		  }
		  
	//	  for(WebElement element:oCheckBox) {
			   
			   // findelements //ul[@class='search']/li[*]
			   //for(int i=1;i<=elemts.size()'i++)
			   {
				/*findlement   ul[@class='search']/li[i]/div[1].getText()
				findlement  ul[@class='search']/li[i]/following::input[1]).getattribut(checked")
            */				
			//   }
		//	   System.out.println(  element.getText());
		//	 System.out.println(element.getAttribute("checked"));
		//	   if(element.getAttribute("checked")!=null) {
		//		   System.out.println(element.getText());
				   
			//   }
			//   else {
				  System.out.println(",");
			//   }
			   
		     }
		
		   
	  }
	 
	  
	 public static void  verifying_plusbutton() {
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
			   
		 }
			
	 }
		 
		 
		 /* Iterator<WebElement> datas = futures.iterator();
		 while(datas.hasNext()) {
			   WebElement we = datas.next();
			   System.out.println(datas.next().getText());
	          // if (we.getText().equals(futurename) ){
			   System.out.println("futurepresent in dash bord");
		 */
	 
}


