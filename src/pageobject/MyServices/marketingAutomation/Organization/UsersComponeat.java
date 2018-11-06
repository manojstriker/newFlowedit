package pageobject.MyServices.marketingAutomation.Organization;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.Sync;
import ActionDriver.UTF;

import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class UsersComponeat {
	 public static	XmlReader readData;
	 public static DataSheet datssheet;
	public UsersComponeat(String filename,String className) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
	}
	public UsersComponeat(String xmlfilename,String className,String excelFile) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(xmlfilename);
		  datssheet=new DataSheet(excelFile);
	}
	public UsersComponeat(String className) throws Exception {
		  UTF.callLog4j(className);
	}
   public void ClickOrganization() {
		  UTF.clickelement("xpath", "//*[text()='Organization']");
		  Log4j.infoLog("click the Organization ");
   }
   public void click_Users() {
	      UTF.clickelement("xpath", "//*[text()='Users']");
		  Log4j.infoLog("click the users");
		  }
   public void clcik_CXO() {
	      UTF.clickelement("partialLinkText", "CXO");
	      Log4j.infoLog("click the CXO");
	      }
   public void clcik_Managers() {
	     UTF.clickelement("partialLinkText", "Managers");
	     Log4j.infoLog("click the Managers");
	     }
   
   public void select_Search_By(String selectType) {
	     UTF.selectByVisibleText("xpath", ".//*[@id='search_type']", selectType);
	     Log4j.infoLog("select the search by");
         }
   
   public void Search_ByName(String serchby) {
	    UTF.inputText("xpath", ".//*[@id='search_name']", serchby);
	    Log4j.infoLog("search by "+serchby+"name");
	    }
    public void click_serchbutton() {
    	UTF.clickelement("xpath", ".//*[@id='search_filters']");
    	Log4j.infoLog("select the serach button");
       }

   public void verifying_Users_features(String datasheetname) throws Exception {
     String UserTable_Features=readData.getdata(datasheetname, "UserTable_Features");
     List<WebElement>UsertableWebElement=	UTF.findelements("xpath", "//table[@class='table smart-table']/thead/tr/th");
     ArrayList<String>UserArry=new ArrayList<String>();
     for(int i=0;i<UsertableWebElement.size();i++) {
    	 Log4j.infoLog(UsertableWebElement.get(i).getText().trim());
    	 UserArry.add(UsertableWebElement.get(i).getText().trim());
    	 }
     String[] divisiontable=UserTable_Features.split("/");
     for(int i=0;i<divisiontable.length;i++) {
     if(UserArry.contains(divisiontable[i])) {
     Log4j.infoLog(divisiontable[i]+"---- feture is present in table");
     }
     else {
     Log4j.errorLogLog("some fetures are missing");
     }
     }
	 }
   public void click_UserCreationPlseButton() {
	  UTF.clickelement("xpath", ".//*[@class='smart-records']/following::span[2]"); 
	  Log4j.infoLog("click  the plse button");
   }
   public void add_branch(String Branchname) {
            Sync.procesWait(2000);
		    UTF.findElement("id", "addDesg").click();
		    Sync.procesWait(2000);
	        UTF.inputText("xpath", ".//*[@id='designtn']",Branchname );
	        UTF.clickelement("id", "designatins");
	        UTF.clickelement("xpath", "//*[@id='designationadd']/div/div/div[1]/button");
	        UTF.clickelement("xpath", ".//*[@id='refreshDesg']");
	        Sync.procesWait(2000);
		    UTF.selectByVisibleText("id", "Branch_ID",Branchname );
		    Log4j.infoLog("branch is selected");
	 }
   public void addDivision(String AddDivisionname) {
	         UTF.clickelement("id", "addGroup");
	         Log4j.infoLog("click the  addGroup");
	         Sync.procesWait(2000);
	         UTF.inputText("id", "group",AddDivisionname );
	         Log4j.infoLog("enter the AddDivision ");
	         UTF.clickelement("id", "groups");
	         Log4j.infoLog("click the  ADDbuttion");
	         UTF.clickelement("xpath", ".//*[@id='groupadd']/div/div/div[1]/button");
	         Log4j.infoLog("click the  closebutton");
	         UTF.clickelement("xpath", " .//*[@id='refreshGroup']");
	         Sync.procesWait(2000);
	         UTF.selectByVisibleText("id", "Group_ID",AddDivisionname );
	         Log4j.infoLog("select the AddDivision");
	  
   }
   public void adduserRoles(String AddUserRole,String seleteLevelText,String SelectReportingRole,String AddUserRoles) {
  	     UTF.clickelement("id", "addUserrole");
	     Log4j.infoLog("click the addUserrole");
	    Sync.procesWait(2000);
	     UTF.inputText("id", "deptname", AddUserRole);
	     Log4j.infoLog("enter userrole");
	     
	     UTF.selectByVisibleText("id", "Dept_Level", seleteLevelText);
	     Log4j.infoLog("select the level");
	     Sync.procesWait(2000);
	     UTF.selectByVisibleText("id", "Reporting_Dept", SelectReportingRole);
	     Log4j.infoLog("select the ReportingRole");
	     UTF.clickelement("id", "userroles");
	     Log4j.infoLog("click the addbutton");
	     UTF.clickelement("xpath", "//*[@id='userroleadd']/div/div/div[1]/button");
	     Log4j.infoLog("click the close button");
	   
	     UTF.clickelement("xpath", ".//*[@id='refreshRole']");
	    
	     UTF.selectByVisibleText("id", "Dept_ID", AddUserRoles);
	     Log4j.infoLog("select the add user role");
  	   
     }
   public void managersubmitbuttion() {
  	     UTF.clickelement("xpath", "//input[@id='usersubmit']");
	     Log4j.infoLog("click submit buttion");
	   
   }
   public void userCeation(String datasetname ) throws Exception {
   String username=readData.getdata(datasetname, "username");
   String password=readData.getdata(datasetname, "password");
   String ConfirmPassword=readData.getdata(datasetname, "ConfirmPassword");
   String FistName=readData.getdata(datasetname, "FistName");
   String LastName=readData.getdata(datasetname, "LastName");

   String Emailaddress=readData.getdata(datasetname, "Emailaddress");
   String Mobilenumber=readData.getdata(datasetname, "Mobilenumber");
   String Company_name=readData.getdata(datasetname, "Company_name");
   String ADDBranchName=readData.getdata(datasetname, "ADDBranchName");
   String AddDivision=readData.getdata(datasetname, "AddDivision");
   String AddUserRole=readData.getdata(datasetname, "AddUserRole");
   String AddUserRoles=readData.getdata(datasetname, "AddUserRoles");
   String seleteLevel=readData.getdata(datasetname, "seleteLevel");
   String SelectReportingRole=readData.getdata(datasetname, "SelectReportingRole");
 
   String Country=readData.getdata(datasetname, "Country");
   String state=readData.getdata(datasetname, "state");
   String city=readData.getdata(datasetname, "city");
   String ContactAddress=readData.getdata(datasetname, "ContactAddress");
   String PinCode=readData.getdata(datasetname, "PinCode");
   String JoiningDateMonth=readData.getdata(datasetname, "JoiningDateManth");
   String JoiningDateyear=readData.getdata(datasetname, "JoiningDateyear");
   String EmployeeID=readData.getdata(datasetname, "EmployeeID");
   String DateOfBirthmonth=readData.getdata(datasetname, "DateOfBirthmanth");
   String DateOfBirthyear=readData.getdata(datasetname, "DateOfBirthyear");
   Sync.procesWait(2000);
   UTF.inputText("id", "username", username);
   Log4j.infoLog("enter the user name");
   UTF.inputText("id", "password", password);
   Log4j.infoLog("enter the password");
   UTF.inputText("id", "conf_password", ConfirmPassword);
   Log4j.infoLog("enter the confirmpassword");
   UTF.inputText("id", "First_Name", FistName);
   Log4j.infoLog("enter the FistName");
   UTF.inputText("id", "Last_Name", LastName);
   Log4j.infoLog("enter LastName");
   UTF.inputText("name", "Email_ID",Emailaddress);
   Log4j.infoLog("enter Emailaddress");
   UTF.clickelement("id", "Mobile_Number");
   UTF.inputText("id", "Mobile_Number", Mobilenumber);
   Log4j.infoLog("enter Mobilenumber");
  
   UTF.selectByVisibleText("id", "Company_ID",Company_name );
   Log4j.infoLog("select the company");
   
   add_branch(ADDBranchName);
   
   
   
   addDivision(AddDivision);
   
   adduserRoles(AddUserRole,seleteLevel,SelectReportingRole,AddUserRoles);
   Sync.procesWait(2000);
   UTF.selectByVisibleText("id", "Reporting_Dept_UserId", SelectReportingRole);
   Log4j.infoLog("select the deporting");
   
   UTF.selectByValue("id", "countryid", Country);
   Log4j.infoLog("select the Country");
   UTF.selectByVisibleText("id", "stateid",state );
   Log4j.infoLog("select the state");
   UTF.selectByVisibleText("id", "cityid", city);
   Log4j.infoLog("select the city");
   UTF.inputText("id", "Contact_Address", ContactAddress);
   Log4j.infoLog("select the ContactAddress");
   UTF.inputText("id", "Pincode", PinCode);
   Log4j.infoLog("select the PinCode");
   
   UTF.clickelement("id", "DOJ");
   Log4j.infoLog("select Date of join ");
   
   UTF.selectByVisibleText("className", "ui-datepicker-month", JoiningDateMonth);
   Log4j.infoLog("select JoiningDateManth ");
  
   UTF.selectByValue("className", "ui-datepicker-year", JoiningDateyear);
   Log4j.infoLog("select JoiningDateyear ");
   UTF.clickelement("partialLinkText", "6");
   Log4j.infoLog("select DAY ");
   UTF.inputText("id", "Emp_ID", EmployeeID);
   Log4j.infoLog("EmployeeID ");

   UTF.clickelement("id", "DOB");
   Log4j.infoLog("select DateOfBirth ");
   Sync.procesWait(2000);
   UTF.selectByVisibleText("className", "ui-datepicker-month", DateOfBirthmonth);
   Log4j.infoLog("select DateOfBirth month ");
  
   Sync.procesWait(2000);
   UTF.selectByValue("className", "ui-datepicker-year", DateOfBirthyear);
   Log4j.infoLog("select DateOfBirthyear ");
   UTF.clickelement("partialLinkText", "6");
   Log4j.infoLog("Day selected ");
   Sync.procesWait(2000);
   managersubmitbuttion();
 
   }
   
   
   
}
