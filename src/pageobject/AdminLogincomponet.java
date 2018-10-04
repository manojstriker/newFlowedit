package pageobject;

import java.io.FileNotFoundException;
import java.io.IOException;

import ActionDriver.UTF;
import utilities.ExcelReusables;

public class AdminLogincomponet {
	public AdminLogincomponet(String filename){
	//String className=getClass().getName();
	try {
		ExcelReusables excelreader=new ExcelReusables( filename);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
    public void Adminlogin(String sheetnmame) throws Exception {
    	    String username=ExcelReusables.getCellData(1, 0, sheetnmame);
			String password=ExcelReusables.getCellData(1, 1, sheetnmame);
		
       UTF.clickelement("tagname", "Login");
       UTF.inputText("id", "username", username);
       UTF.inputText("id", "password", password);
    	
    	
    	
    }
    
	
	
	
}
