package pageobject.MyServices.marketingAutomation.Organization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.UTF;
import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class DivisionsComponeat {

	 public static	XmlReader readData;
	 public static DataSheet datssheet;
	public DivisionsComponeat(String filename,String className) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
	}
	public DivisionsComponeat(String xmlfilename,String className,String excelFile) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(xmlfilename);
		  datssheet=new DataSheet(excelFile);
	}
	public DivisionsComponeat(String className) throws Exception {
		  UTF.callLog4j(className);
	}
   public void ClickOrganization() {
		  UTF.clickelement("xpath", "//*[text()='Organization']");
		  Log4j.infoLog("click the Organization ");
   }
   public void click_Divisions() {
		
		UTF.clickelement("xpath", "//*[text()='Divisions']");
		Log4j.infoLog("click the Branches ");
		if(UTF.findElement("xpath", "//*[@class='col-sm-6']/h4").getText().trim().equals("Division List")) {
	    	Log4j.infoLog(" Shift to Division  ");
           	    	}
	    else {
	    	Log4j.infoLog("its click Divisions but it not present");
	    }
       }
   public void verifying_DivisionTable_features(String datasheetname) throws Exception {
	    String DivisionTable_features=readData.getdata(datasheetname, "addBranchTable_Features");
	    List<WebElement>divisionstableWebElement=	UTF.findelements("xpath", "//table[@class='table smart-table']/thead/tr/th");
	    ArrayList<String>divisionArry=new ArrayList<String>();
	    for(int i=0;i<divisionstableWebElement.size();i++) {
	    	divisionArry.add(divisionstableWebElement.get(i).getText().trim());
		}
	    String[] divisiontable=DivisionTable_features.split("/");
	    for(int i=0;i<divisiontable.length;i++) {
	    if(divisionArry.contains(divisiontable[i])) {
	    Log4j.infoLog(divisiontable[i]+"---- feture is present in table");
	    }
	    else {
	    Log4j.errorLogLog("some fetures are missing");
	    }
	    }
		}
   
      public void  selectcompany(String companyname) {
    	UTF.selectByVisibleText("id", "Company_ID",companyname); 
      }
      public void  SelectDivisiontype(String DivisionType) {
	    UTF.selectByVisibleText("id", "Group_Role", DivisionType);
	  }
      public void creatingDivisionName(String divisionName) {
    	 UTF.inputText("id", "Group_Name", divisionName);
      }
      public void  Allow_Duplicate_Records(String YesorNo) {
    	 UTF.clickelement("xpath", "//*[text()='"+YesorNo+"']");
      }
      public void subbmitbutton_didvisions() {
    	 UTF.clickelement("id", "groupsubmit");
       }
      
      public void Add_Division(String dataSheetname) throws Exception {
    	  String companyname=readData.getdata(dataSheetname, "companyname");
    	  String SelectDivisionType=readData.getdata(dataSheetname, "SelectDivisionType");
    	  String creatingDivisionName=readData.getdata(dataSheetname, "creatingDivisionName");
    	  String Allow_Duplicate_Records=readData.getdata(dataSheetname, "Allow_Duplicate_Records");
    	  
    	  
    	  UTF.clickelement("xpath", ".//*[@id='action']/span");
    	  selectcompany(companyname);
    	  SelectDivisiontype(SelectDivisionType);
    	  creatingDivisionName(creatingDivisionName);
    	  Allow_Duplicate_Records(Allow_Duplicate_Records);
    	  subbmitbutton_didvisions();
       }
      
    //td[text()='CXO'] and//td[text()='sales']
      
      public void update(String dataSheetname) throws Exception {
    	  String SelectDivisionType=readData.getdata(dataSheetname, "SelectDivisionType");
    	  String creatingDivisionName=readData.getdata(dataSheetname, "creatingDivisionName");
    	  UTF.clickelement("xpath", "//td[text()='CXO'] and//td[text()='sales']/following::td[3]/a");
        }
      
    public void app() {
    	LinkedHashMap<Integer,String> linkedhashmap=new LinkedHashMap<Integer,String>();
        List<WebElement>DivisionNames=	UTF.findelements("xpath", "//table[@class='table smart-table']/tbody/tr");
	    ArrayList<String>divisionArry=new ArrayList<String>();
	    for(int i=0;i<DivisionNames.size();i++) {
	    	//Log4j.infoLog(DivisionNames.get(i).getText().trim());
	    	divisionArry.add(DivisionNames.get(i).getText().trim());
	    	linkedhashmap.put(i, DivisionNames.get(i).getText().trim());
	    	
		}
	    System.out.println(linkedhashmap.size());
	    System.out.println(linkedhashmap.values());
	    
	    Iterator<String> it=linkedhashmap.values().iterator();
	    while(it.hasNext())
	    	
	    for(int i=0;i<linkedhashmap.size();i++) {
	    	
	    	
	    	
	    	
	    	if(linkedhashmap.values().contains("Striker")&& linkedhashmap.values().contains("CXO")) {
	    		System.out.println(linkedhashmap.values());
	    		}
	    	
	    }
	    
     // String DivisionNames="//table[@class='table smart-table']/tbody/tr/td[3]";
      //String DivisionType="//table[@class='table smart-table']/tbody/tr/td[5]";
    
        }
}
