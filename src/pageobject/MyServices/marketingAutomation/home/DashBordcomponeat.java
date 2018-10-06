package pageobject.MyServices.marketingAutomation.home;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import ActionDriver.Sync;
import ActionDriver.UTF;
import utilities.Log4j;
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
	
	public static void verifying_dashboardfutures(String futurename) {
		  HomeComponent.clickhomebutton();
		  Log4j.infoLog("click the home button");
		   HomeComponent.clickDashBord();
		   Log4j.infoLog("click the dash button");
	// Sync.presenceofElementLocated("className", "campain-re-title", 30);
		 // Sync.presenceofElementsLocated("className", "campain-re-title", 60);
		   Sync.procesWait(1600);  
		   List<WebElement> futures= UTF.findelements("className", "campain-re-title");
		   Iterator<WebElement> datas = futures.iterator();
		   while(datas.hasNext()) {
		   WebElement we = datas.next();
           if (we.getText().equals(futurename) ){
		   System.out.println("futurepresent in dash bord");
		   }
		   }
		   }
	
	
	 public static void verifying_todayCalls(){
		 HomeComponent.clickhomebutton();
		 HomeComponent.clickDashBord();
		 Sync.procesWait(4000);
		 List<WebElement> futures=UTF.findelements("xpath", "//span[text()='Today Calls']/following::table[1]/following::tr[1]/th[*]");
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


