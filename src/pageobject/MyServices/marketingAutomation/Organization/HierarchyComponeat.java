package pageobject.MyServices.marketingAutomation.Organization;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.Sync;
import ActionDriver.UTF;
import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class HierarchyComponeat {
	public static	XmlReader readData;
	public static DataSheet datssheet;
	public HierarchyComponeat(String filename,String className) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
	}
	public HierarchyComponeat(String xmlfilename,String className,String excelFile) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(xmlfilename);
		  datssheet=new DataSheet(excelFile);
		  }
	public HierarchyComponeat(String className) throws Exception {
		  UTF.callLog4j(className);
	      }
    public void ClickOrganization() {
		  UTF.clickelement("xpath", "//*[text()='Organization']");
		  Log4j.infoLog("click the Organization ");
          }
    public void click_Hierarchy() {
	      UTF.clickelement("xpath", "//*[text()='Hierarchy']");
	      Log4j.infoLog("click the hierarchy");
          }
    public void click_Departments() {
	      UTF.clickelement("xpath", "//*[text()='Departments']");
	      Log4j.infoLog("click_Departments");
          }
    public void click_DepartmentHierarchy() {
	      UTF.clickelement("xpath", "//*[text()='Department Hierarchy']");
	      Log4j.infoLog("click Department Hierarchy");
          }
    public void click_UserHierarchy() {
	      UTF.clickelement("xpath", "//*[text()='User Hierarchy']");
	      Log4j.infoLog("click User Hierarchy");
          }
    public void click_hierarchyADDing_button() {
    	  UTF.clickelement("xpath", ".//*[@id='action']/span");
    	  Log4j.infoLog("clcik the pluse button");
          }

    public void Add_User_Hierarchy(String dataSheetname) throws Exception {
    	String Company=readData.getdata(dataSheetname, "Company");
    	String User_Role=readData.getdata(dataSheetname, "User_Role");
    	String Hierarchy_Name=readData.getdata(dataSheetname, "Hierarchy_Name");
    	String Level=readData.getdata(dataSheetname, "Level");
    	String Reporting_to=readData.getdata(dataSheetname, "Reporting_to");
    	
    	UTF.selectByVisibleText("xpath", ".//*[@id='Company_ID']", Company);
    	Log4j.infoLog(" enter company  name");
    	
    	UTF.selectByVisibleText("xpath", ".//*[@id='user_role']", User_Role);
    	Log4j.infoLog(" enter user role name");
    	
    	UTF.inputText("xpath", ".//*[@id='Dept_Name']", Hierarchy_Name);
    	Log4j.infoLog(" enter hierachy name");
    	Sync.procesWait(2000);
    	
    	UTF.selectByVisibleText("xpath", ".//*[@id='Dept_Level']", Level);
    	Log4j.infoLog(" select level");
    	
    	UTF.selectByVisibleText("xpath", ".//*[@id='Reporting_Dept']", Reporting_to);
    	Log4j.infoLog(" select reporting To");
        
    	UTF.clickelement("id", "deptsubmit");
        }
    

    public void verifying_DepartmentsHierarchy_features(String datasheetname) throws Exception {
      String DepartmentsHierarchy_features=readData.getdata(datasheetname, "features");
      List<WebElement>DepartmentsHierarchy_featuresWebElement=	UTF.findelements("xpath", "//table[@class='table smart-table']/thead/tr/th");
      ArrayList<String>UserArry=new ArrayList<String>();
      for(int i=0;i<DepartmentsHierarchy_featuresWebElement.size();i++) {
     	 UserArry.add(DepartmentsHierarchy_featuresWebElement.get(i).getText().trim());
     	 }
      String[] DepartmentsHierarchytable=DepartmentsHierarchy_features.split("/");
      for(int i=0;i<DepartmentsHierarchytable.length;i++) {
      if(UserArry.contains(DepartmentsHierarchytable[i])) {
      Log4j.infoLog(DepartmentsHierarchytable[i]+"---- feture is present in table");
      }
      else {
      Log4j.errorLogLog("some fetures are missing");
      }
      }
 	  }
    
    
    
  //table[@class='table smart-table']/tbody/tr/td[4]/following::td[4]/a[1]
    
    public void Update_DepartmentsHierarchy_Table(String datasheetname) throws Exception {
   
			String Hierarchy_Name=readData.getdata(datasheetname, "Hierarchy_Name");
			
			 List<WebElement>UserHierarchyWebElement=UTF.findelements("xpath", "//table[@class='table smart-table']/tbody/tr/td[4]");
		        ArrayList<String>UserArry=new ArrayList<String>();
		        for(int i=0;i<UserHierarchyWebElement.size();i++) {
		        	UserArry.add(UserHierarchyWebElement.get(i).getText());
		        	if(UserHierarchyWebElement.get(i).getText().equals(Hierarchy_Name)) {
		             		
		        	}
		        }
		
    }
    
    
    public void verifying_DepartmentsHierarchy_Table_Data(String datasheetname) throws Exception {
        String Hierarchy_Name=readData.getdata(datasheetname, "Hierarchy_Name");
        List<WebElement>UserHierarchyWebElement=UTF.findelements("xpath", "//table[@class='table smart-table']/tbody/tr/td[4]");
        ArrayList<String>UserArry=new ArrayList<String>();
        for(int i=0;i<UserHierarchyWebElement.size();i++) {
        	UserArry.add(UserHierarchyWebElement.get(i).getText());
        	if(UserHierarchyWebElement.get(i).getText().equals(Hierarchy_Name)) {
        	List<WebElement>UserHierarchytableData=UTF.findelements("xpath", "//table[@class='table smart-table']/tbody/tr/td[4]");
        	}
        	
        	
           }
        
        if(UserArry.contains(Hierarchy_Name)) {
        	
       	 }
        String[] DepartmentsHierarchytable=Hierarchy_Name.split("/");
        for(int i=0;i<DepartmentsHierarchytable.length;i++) {
        if(UserArry.contains(DepartmentsHierarchytable[i])) {
        Log4j.infoLog(DepartmentsHierarchytable[i]+"---- feture is present in table");
        }
        else {
        Log4j.errorLogLog("some fetures are missing");
        }
        }
   	  }
    
}
