package pageobject.MyServices.marketingAutomation.Organization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.Sync;
import ActionDriver.UTF;
import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class CompaniesComponeat {
	 public static	XmlReader readData;
	 public static DataSheet datssheet;
	public CompaniesComponeat(String filename,String className) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
	}
	public CompaniesComponeat(String xmlfilename,String className,String excelFile) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(xmlfilename);
		  datssheet=new DataSheet(excelFile);
	}
	public CompaniesComponeat(String className) throws Exception {
		 UTF.callLog4j(className);
	}
	public void ClickOrganization() {
		
		UTF.clickelement("xpath", "//*[text()='Organization']");
		Log4j.infoLog("click the Organization ");
		//*[text()='Companies']
	}
	public void clickCompanies() {
		UTF.clickelement("xpath", "//*[text()='Companies']");
		Log4j.infoLog("click the Companies ");
	    if(UTF.findElement("xpath", "//*[@class='col-sm-6']/h4").getText().trim().equals("Company Details")) {
	    	Log4j.infoLog(" Shift to Companies  ");
            	    	
	    }
	    else {
	    	Log4j.infoLog("its click companies but it not present");
	    }
	}
	public void verifying_companyTable_features(String datasheetname) throws Exception {
		String companifeatures=readData.getdata(datasheetname, "Company_Details");
	    List<WebElement>copmanitable=	UTF.findelements("xpath", "//*[@class='table smart-table']/thead/tr/th");
	    ArrayList<String>copmanitableArry=new ArrayList<String>();
	    for(int i=0;i<copmanitable.size();i++) {
		copmanitableArry.add(copmanitable.get(i).getText().trim());
		}
	    String[] comanitable=companifeatures.split("/");
	    for(int i=0;i<comanitable.length;i++) {
	    if(copmanitableArry.contains(comanitable[i])) {
	    Log4j.infoLog(comanitable[i]+"---- feture is present in table");
	    }
	    else {
	    Log4j.infoLog("some fetures are missing");
	    }
	    }
		}
	
    public void comanitable_data_verifying(String datasheetname) throws Exception {
    	String companifeatures=readData.getdata(datasheetname, "companifeatures");
    	String compani_Data=readData.getdata(datasheetname, "compani_Data");
		
    	int count=0;
    	LinkedHashMap<String,String> linkedhashmap=new LinkedHashMap<String,String>();
    	List<WebElement>companifeatures_webelement=UTF.findelements("xpath", "//*[@class='table smart-table']/thead/tr/th");
 	    ArrayList<String>copmanitableArry=new ArrayList<String>();
 	    for(int i=0;i<companifeatures_webelement.size();i++) {
 		copmanitableArry.add(companifeatures_webelement.get(i).getText().trim());
 		List<WebElement>copmanitableInformation=UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td");
 		for(int j=count;j<copmanitableInformation.size();) {
 			linkedhashmap.put(companifeatures_webelement.get(i).getText().trim(), copmanitableInformation.get(j).getText().trim());
 	    count++;
 		break;
 		}
 		}
 	    
 	    int sum=0;
 	    String[] companifeaturesArry=companifeatures.split("/");
	    for(int i=0;i<companifeaturesArry.length;i++) {
	    	if(linkedhashmap.keySet().contains(companifeaturesArry[i])) {
	    	Log4j.infoLog(companifeaturesArry[i]+"---- feture is present in table");
	    	}
	   else {
	    	Log4j.errorLogLog(companifeaturesArry[i]+"-----some  feture is present in table");
	    	}
	    String[] companidatasArry=compani_Data.split("/");
	    for(int j=sum;j<companidatasArry.length;) {
	     if(linkedhashmap.values().contains(companidatasArry[j])) {
	        Log4j.infoLog(companidatasArry[j]+"---- data is present in table");
	        }
	   else{
		    Log4j.errorLogLog(companidatasArry[j]+"-----some  data is present in table");
		    }
	         sum++;
	    	 break;
	     }
	     }
	     }
    
    public void clickUpdate() {
		   UTF.clickelement("xpath", "//*[@class='table smart-table']/tbody/tr/td[10]/a");
		   Log4j.infoLog("clcik the update button");
	   }
	
    public void EnterCompany(String companyName) {
    	UTF.inputText("id", "Company_Name",companyName);
    	Log4j.infoLog("eneter the compnay name");
     }
    
    public void click_Is_SecureLogin(String YesorNo) {
       UTF.clickelement("xpath", "//span[text()='"+YesorNo+"']");
       Log4j.infoLog("select "+YesorNo);
     }
    public void EnterContactAddress(String Address) {
    	UTF.inputText("id", "Address",Address);
    	Log4j.infoLog("enetr the ContactAddress");
     }
    public void selectcountry(String county) {
    	UTF.selectByVisibleText("id", "country", county);
    	Log4j.infoLog("select the country");
     }
    
    public void selectState(String state) {
    	UTF.selectByVisibleText("id", "stateid", state);
    	Log4j.infoLog("select the state"); 
    }
    public void enterpinCode(String Pincode) {
    	UTF.inputText("id", "ZipCode", Pincode);
    	Log4j.infoLog("eneter the pincode");
     }
    public void enterGST(String GSTNumber) {
    	UTF.inputText("id", "gstnumber", GSTNumber);
    	Log4j.infoLog("eneter the GST");
     }
    public void clcikSubmit_editDetiles() {
		UTF.clickelement("id", "companysubmit");
		Log4j.infoLog("click the subbmit");
	}
    public void cfeatureslcikBackButton_editDetiles() {
		UTF.clickelement("xpath", ".//*[text()='Back']");
		Log4j.infoLog("click the back");
	}
    
    public void Edit_CompanyDetiles(String dataSheetname) throws Exception {
    	String Companyname=readData.getdata(dataSheetname, "Companyname");
    	String SecureLogin=readData.getdata(dataSheetname, "SecureLogin");
    	String ContactAddress=readData.getdata(dataSheetname, "ContactAddress");
    	String country=readData.getdata(dataSheetname, "country");
    	String State=readData.getdata(dataSheetname, "State");
    	String pincode=readData.getdata(dataSheetname, "pincode");
    	String GSTNumber=readData.getdata(dataSheetname, "GSTNumber");
		
    	EnterCompany(Companyname);
    	click_Is_SecureLogin(SecureLogin);
    	EnterContactAddress(ContactAddress);
    	selectcountry(country);
    	selectState(State);
    	enterpinCode(pincode);
    
    	clcikSubmit_editDetiles();
    	
	}
	
	
  //*[@class='col-sm-6 text-right']/a[1]
	
	public void click_PurchaseCompany() {
		UTF.clickelement("xpath", "//*[@class='col-sm-6 text-right']/a[1]");
	    }
    public void selectApplication_type(String applicationType) {
    	UTF.clickelement("id", "cloud_applicationtype");
    	UTF.clickelement("xpath", "//li[text()='"+applicationType+"']");
    	Log4j.infoLog("select the application type");
        }
	
    public void select_ServiceType(String serviceType) {
    	UTF.clickelement("id", "solution_type");
    	UTF.clickelement("xpath", "//li[text()='"+serviceType+"']");
    	Log4j.infoLog("select the service type");
    	}
    
    public void select_virtual_number(String virtualnumbers) {
    	UTF.clickelement("id", "virtual_numbers");
    	UTF.clickelement("xpath", "//li[text()='"+virtualnumbers+"']");
    	Log4j.infoLog("select the virtual_numbers type");
    	}
//number_plan
    public void select_numberplan(String numberplan) {
    	UTF.clickelement("id", "number_plan");
    	UTF.clickelement("xpath", "//li[text()='"+numberplan+"']");
    	Log4j.infoLog("selectnumber plan");
    	}
    
    public void select_NumberofUsers(String userscount) {
    	UTF.clickelement("id", "noof_users");
        UTF.clickelement("xpath", ".//*[@id='cloud']/div/div/div[15]/ul/li/ul/li["+userscount+"]");
    	Log4j.infoLog("selectnumber users---->"+userscount);
       }
    
    public void select_Validity(String Validity) {
    	UTF.clickelement("id", "paln_validate");
    	UTF.clickelement("xpath", "//li[text()='"+Validity+"']");
    	Log4j.infoLog("select the  validity");
    	}
	public void clcik_submitbutton_cloudaplication() {
		UTF.clickelement("xpath", ".//*[@value='Submit']");
	}
	
    public void purchaseCompany_Service(String dataSheetname) throws Exception {
    	String ApplicationType=readData.getdata(dataSheetname, "ApplicationType");
    	String Service_Type=readData.getdata(dataSheetname, "Service_Type");
       	String Virtual_Number=readData.getdata(dataSheetname, "Virtual_Number");
     	String Number_plan=readData.getdata(dataSheetname, "Number_plan");
    	String Validity=readData.getdata(dataSheetname, "Validity");
    	selectApplication_type(ApplicationType);
    	select_ServiceType(Service_Type);
    	select_virtual_number(Virtual_Number);
    	select_numberplan(Number_plan);
    	select_Validity(Validity);
    	clcik_submitbutton_cloudaplication();
    	
    }
    public void purchaseCompany_Solution(String dataSheetname) throws Exception {
    	String ApplicationType=readData.getdata(dataSheetname, "ApplicationType");
    	String Service_Type=readData.getdata(dataSheetname, "Service_Type");
       	String Virtual_Number=readData.getdata(dataSheetname, "Virtual_Number");
     	String Number_plan=readData.getdata(dataSheetname, "Number_plan");
     	String Validity=readData.getdata(dataSheetname, "Validity");
    	String users=readData.getdata(dataSheetname, "users");
    	selectApplication_type(ApplicationType);
    	select_ServiceType(Service_Type);
    	select_virtual_number(Virtual_Number);
    	select_numberplan(Number_plan);
    	select_NumberofUsers(users);
    	select_Validity(Validity);
    	clcik_submitbutton_cloudaplication();
    	}
    
    //*[@class='col-sm-6 text-right']/a[2]
    public void click_PurchaseApplication() {
       UTF.clickelement("xpath", "//*[@class='col-sm-6 text-right']/a[2]");
       Log4j.infoLog("clcik the Purchaseapplication");
    }
    
    public void PurchaseApplication_Service(String dataSheetname) throws Exception {
    	String ApplicationType=readData.getdata(dataSheetname, "ApplicationType");
    	String Service_Type=readData.getdata(dataSheetname, "Service_Type");
       	String Virtual_Number=readData.getdata(dataSheetname, "Virtual_Number");
     	String Number_plan=readData.getdata(dataSheetname, "Number_plan");
    	String Validity=readData.getdata(dataSheetname, "Validity");
    	selectApplication_type(ApplicationType);
    	select_ServiceType(Service_Type);
    	select_virtual_number(Virtual_Number);
    	select_numberplan(Number_plan);
    	select_Validity(Validity);
    	clcik_submitbutton_cloudaplication();
    	
    }
    public void PurchaseApplication_Solution(String dataSheetname) throws Exception {
    	String ApplicationType=readData.getdata(dataSheetname, "ApplicationType");
    	String Service_Type=readData.getdata(dataSheetname, "Service_Type");
       	String Virtual_Number=readData.getdata(dataSheetname, "Virtual_Number");
     	String Number_plan=readData.getdata(dataSheetname, "Number_plan");
     	String Validity=readData.getdata(dataSheetname, "Validity");
    	String users=readData.getdata(dataSheetname, "users");
    	selectApplication_type(ApplicationType);
    	select_ServiceType(Service_Type);
    	select_virtual_number(Virtual_Number);
    	select_numberplan(Number_plan);
    	select_NumberofUsers(users);
    	select_Validity(Validity);
    	clcik_submitbutton_cloudaplication();
    	}
	public void SurchNumber(String numbersurch) {
		UTF.inputText("xpath", "//*[@class='form-group']/input[1]", numbersurch);
		Log4j.infoLog("enter number");
	    }
	public void clickSurchbutton() {
		UTF.clickelement("xpath", "//*[@class='form-group']/input[1]");
	}
	public void clickselectnumber(String numbersurch) {
		UTF.clickelement("xpath", ".//*[text()='"+numbersurch+"']");
	}
	  public void clicksubmit_plan(){
     	 UTF.clickelement("xpath", ".//*[@id='dynamic_curd_edit']/div[2]/div[2]/input[1]");
     	 Log4j.infoLog("clcik the submit buttion");
      }
	  public void clicks_cancelbutton_plan(){
	     	 UTF.clickelement("xpath", ".//*[@id='dynamic_curd_edit']/div[2]/div[2]/input[2]");
	     	 Log4j.infoLog("clcik the cancuial buttion");
	      }
	  
	  public void inVoice_BillingDetails(String datasheetname) throws Exception {
     	 
     	 String Address=readData.getdata(datasheetname, "Address");
     	
     	 String country=readData.getdata(datasheetname, "country");
     	 String state=readData.getdata(datasheetname, "state");
     	 String city=readData.getdata(datasheetname, "city");
     	 String pincode=readData.getdata(datasheetname, "pincode");
     	 String gst=readData.getdata(datasheetname, "gst");
     	 
     	
     	 UTF.inputText("xpath", ".//*[@class='smart-formborder-div']/div[1]/div", Address);
     	 UTF.selectByVisibleText("id", "countryid", country);
     	 UTF.selectByVisibleText("id", "stateid", state);
     	 UTF.selectByVisibleText("id", "cityid", city);
     	 UTF.inputText("xpath", "//*[text()='Pincode']/following::div[1]/input", pincode);
     	 UTF.inputText("xpath", "//*[text()='GST Number']/following::div[1]/input", gst);
     	 
      }
	  public void  clickBuyNow() {
    	  UTF.clickelement("id", "updateformprofile");
      }
	  public void backTo_Order() {
		  UTF.clickelement("xpath", ".//*[@id='backtoplanorder']");
	  }
	  
	 /*
	  * This was AddBranch Related nodes
	  *  
	  *  
	  *  
	  */
	
	  
	  
	  public void verifying_AddBranchTable_features(String datasheetname) throws Exception {
		    String AddBranchTablefeatures=readData.getdata(datasheetname, "addBranchTable_Features");
		    List<WebElement>AddBranchtable=	UTF.findelements("xpath", "//table[@class='table smart-table']/thead/tr/th");
		    ArrayList<String>AddBranchtableArry=new ArrayList<String>();
		    for(int i=0;i<AddBranchtable.size();i++) {
		    	AddBranchtableArry.add(AddBranchtable.get(i).getText().trim());
			}
		    String[] ADDbranchtable=AddBranchTablefeatures.split("/");
		    for(int i=0;i<ADDbranchtable.length;i++) {
		    if(AddBranchtableArry.contains(ADDbranchtable[i])) {
		    Log4j.infoLog(ADDbranchtable[i]+"---- feture is present in table");
		    }
		    else {
		    Log4j.infoLog("some fetures are missing");
		    }
		    }
			}
		 
	   public void clickPlusebutton_Addbranch() {
		   UTF.clickelement("id", "action");
     	   Log4j.infoLog("click the plse buttion ");
	   }
	  public void delete_Branch_table() {
		  UTF.clickelement("xpath", "//a[text()='Delete']");
		  Log4j.infoLog("delete the brach_table");
	  }
	  public void update_Branch_table() {
		  UTF.clickelement("xpath", "//a[text()='Update']");
		  Log4j.infoLog("Update brach_table");
	  }
	  
	  public void add_button_brachcreation() {
		  UTF.clickelement("xpath", ".//*[@id='desigsubmit']");
		  Log4j.infoLog("clcik the back button");
	  }
	  
	  public void back_button_brachcreation() {
		  UTF.clickelement("xpath", ".//a[text()='Back']");
		  Log4j.infoLog("clcik the add  button");
	  }
	  public void Add_branc(String datasheetname) throws Exception {
		  String company_Name=readData.getdata(datasheetname, "company_Name");
		  String Branchname=readData.getdata(datasheetname, "Branchname");
		  
		  UTF.selectByVisibleText("id", "companyid", company_Name);
		  Log4j.infoLog("select the company");
		  
		  UTF.inputText("xpath", ".//*[@id='designame']",Branchname );
		  Log4j.infoLog("branch name is created");
		  add_button_brachcreation();
		  
	  }
	  public void branch_table_data_verifying(String datasheetname ) throws Exception {
		  String addBranchTable_Features=readData.getdata(datasheetname, "addBranchTable_Features");
	    	String branch_data=readData.getdata(datasheetname, "branch_data");
			
	    	int count=0;
	    	LinkedHashMap<String,String> linkedhashmap=new LinkedHashMap<String,String>();
	    	List<WebElement>Branchtablefeatures_webelement=UTF.findelements("xpath", "//*[@class='table smart-table']/thead/tr/th");
	 	   
	 	    for(int i=0;i<Branchtablefeatures_webelement.size();i++) {
	 	    List<WebElement>branchtableData=UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td");
	 		for(int j=count;j<branchtableData.size();) {
	 			linkedhashmap.put(Branchtablefeatures_webelement.get(i).getText().trim(), branchtableData.get(j).getText().trim());
	 	    count++;
	 		break;
	 		}
	 		}
	 	    
	 	    int sum=0;
	 	    String[] addBranchTable_Featuresarry=addBranchTable_Features.split("/");
		    for(int i=0;i<addBranchTable_Featuresarry.length;i++) {
		    	if(linkedhashmap.keySet().contains(addBranchTable_Featuresarry[i])) {
		    	Log4j.infoLog(addBranchTable_Featuresarry[i]+"---- feture is present in table");
		    	}
		   else {
		    	Log4j.errorLogLog(addBranchTable_Featuresarry[i]+"-----some  feture is present in table");
		    	}
		    String[] branch_data_Arry=branch_data.split("/");
		    for(int j=sum;j<branch_data_Arry.length;) {
		     if(linkedhashmap.values().contains(branch_data_Arry[j])) {
		        Log4j.infoLog(branch_data_Arry[j]+"---- data is present in table");
		        }
		   else{
			    Log4j.errorLogLog(branch_data_Arry[j]+"-----some  data is present in table");
			    }
		         sum++;
		    	 break;
		     }
		     }
		     }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

      
}
