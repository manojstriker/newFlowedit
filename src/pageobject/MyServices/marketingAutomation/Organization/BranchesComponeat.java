package pageobject.MyServices.marketingAutomation.Organization;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import ActionDriver.Sync;
import ActionDriver.UTF;
import utilities.DataSheet;
import utilities.Log4j;
import utilities.XmlReader;

public class BranchesComponeat {
	 public static	XmlReader readData;
	 public static DataSheet datssheet;
	public BranchesComponeat(String filename,String className) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(filename);
	}
	public BranchesComponeat(String xmlfilename,String className,String excelFile) throws Exception {
		  UTF.callLog4j(className);
		  readData=new XmlReader(xmlfilename);
		  datssheet=new DataSheet(excelFile);
	}
	public BranchesComponeat(String className) throws Exception {
		 UTF.callLog4j(className);
	}
   public void ClickOrganization() {
		
		UTF.clickelement("xpath", "//*[text()='Organization']");
		Log4j.infoLog("click the Organization ");
		//*[text()='Companies']
	}
	public void ClickBranches() {
		
		UTF.clickelement("xpath", "//*[text()='Branches']");
		Log4j.infoLog("click the Branches ");
		if(UTF.findElement("xpath", "//*[@class='col-sm-6']/h4").getText().trim().equals("Branch List")) {
	    	Log4j.infoLog(" Shift to Branches  ");
            	    	
	    }
	    else {
	    	Log4j.infoLog("its click branches but it not present");
	    }
		
	}
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
		    Log4j.errorLogLog("some fetures are missing");
		    }
		    }
			}
		 
	   public void clickPlusebutton_Addbranch() {
		   UTF.clickelement("xpath", ".//*[@id='action']/span");
   	       Log4j.infoLog("click the plse buttion ");
	   }
	
	 
	  public void edit_Branch_data(String datasheetname) throws Exception {
		  
		  String company_Name=readData.getdata(datasheetname, "company_Name");
		  String Branchname=readData.getdata(datasheetname, "Branchname");
		  String editBranchName=readData.getdata(datasheetname, "editBranchName");
		  List<WebElement>Branchnames_webelements=	UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td[3]");
		  ArrayList<String>BranchnamesArry=new ArrayList<String>();
		  for(int i=0;i<Branchnames_webelements.size();i++) {
		       BranchnamesArry.add(Branchnames_webelements.get(i).getText().trim());
			 }
		  if(BranchnamesArry.contains(editBranchName)) {  
			  UTF.clickelement("xpath", "//td[text()='"+editBranchName+"']/following::td[2]/a[1]");
		      UTF.selectByVisibleText("id", "companyid", company_Name);
		      Log4j.infoLog("select the company");
		      UTF.inputText("xpath", ".//*[@id='deptname']",Branchname );
			  Log4j.infoLog("branch name is enter");
		      UTF.clickEneter();
		      
		
		      
		      
		      if(editBranchName.equals(Branchname)|| !BranchnamesArry.contains(Branchname)) {
			      Log4j.infoLog("branch name is enter");
			      UTF.clickEneter();
			      Sync.procesWait(200);
				  UTF.findElement("xpath", "//span[@class='smart-success']").getText().equals("Branch  Updated Successfully");
				  Log4j.infoLog(UTF.findElement("xpath", "//span[@class='smart-success']").getText());
			
		   }
		  else {
			     Log4j.infoLog("branch name is enter");
		         UTF.clickEneter();
				 UTF.findElement("xpath", ".//*[@id='hid']").getText().equals("Branch Name Already Exist");
				 Log4j.infoLog(UTF.findElement("xpath", ".//*[@id='hid']").getText());
			
		       }
		   }
		  else {
			  Log4j.infoLog("barnch doesnt exit");
		  }
	  }
	  
	  public void add_button_brachcreation() {
		  Sync.procesWait(3000);
		  UTF.doubleclick("xpath", ".//*[@id='desigsubmit']");
		  Log4j.infoLog("clcik the add  button");
	  }
	  
	  public void back_button_brachcreation() {
		  UTF.clickelement("xpath", ".//a[text()='Back']");
		  Log4j.infoLog("clcik the back  button");
	  }
	  public void Add_branch(String datasheetname) throws Exception {
		  String company_Name=readData.getdata(datasheetname, "company_Name");
		  String Branchname=readData.getdata(datasheetname, "Branchname");
          List<WebElement>Branchnames_webelements=	UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td[3]");
		  ArrayList<String>BranchnamesArry=new ArrayList<String>();
		  for(int i=0;i<Branchnames_webelements.size();i++) {
		  BranchnamesArry.add(Branchnames_webelements.get(i).getText().trim());
		  }
		  if(!BranchnamesArry.contains(Branchname)||BranchnamesArry.isEmpty()) {
	      clickPlusebutton_Addbranch();
		  UTF.selectByVisibleText("id", "companyid", company_Name);
		  Log4j.infoLog("select the company");
		  UTF.inputText("xpath", ".//*[@id='designame']",Branchname );
		  Log4j.infoLog("enter the branch name");
		  UTF.clickEneter();
		  Sync.procesWait(2000);
		  if(UTF.findElement("xpath", "//span[@class='smart-success']").getText().equals("Branch Added Successfully")) {
			   Log4j.infoLog("branch add success");
		   }
		  else {
			  Log4j.infoLog("sucess message not visable");
		  }
	  }
	  }
	  
	  public void deleteBranch(String datasheetname) throws Exception {
		  String Branchname=readData.getdata(datasheetname, "Branchname");
		  List<WebElement>Branchnames_webelements=	UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td[3]");
		  ArrayList<String>BranchnamesArry=new ArrayList<String>();
		  for(int i=0;i<Branchnames_webelements.size();i++)
		  {
		  BranchnamesArry.add(Branchnames_webelements.get(i).getText().trim());
		  }
		  UTF.clickelement("xpath", "//td[text()='"+Branchname+"']/following::td[2]/a[2]");
		  UTF.clickelement("xpath", "//div[@class='jconfirm-buttons']/button[1]");
		  Log4j.infoLog("branch is deleted");
		  
	  }
	  
	  
	  
	  
	  
	  public void branch_tableData_verifying(String datasheetname ) throws Exception {
		  String branch_data=readData.getdata(datasheetname, "branch_data");
		    List<WebElement>Branchtable_webelements=	UTF.findelements("xpath", "//*[@class='table smart-table']/tbody/tr/td");
		    ArrayList<String>BranchtableArry=new ArrayList<String>();
		    for(int i=0;i<Branchtable_webelements.size();i++) {
		    	BranchtableArry.add(Branchtable_webelements.get(i).getText().trim());
			}
		    String[] branchtabledata=branch_data.split("/");
		    for(int i=0;i<branchtabledata.length;i++) {
		    if(BranchtableArry.contains(branchtabledata[i])) {
		    Log4j.infoLog(branchtabledata[i]+"---- feture is present in table");
		    }
		    else {
		    Log4j.errorLogLog("some fetures are missing");
		    }
		    }
			}
		  
		  
		  
		  
	  
	  public void branch_table_data_And_features_verifying(String datasheetname ) throws Exception {
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
		   else {
			    Log4j.errorLogLog(branch_data_Arry[j]+"-----some  data is present in table");
			    }
		         sum++;
		    	 break;
		     }
		     }
		     }
	  
}
