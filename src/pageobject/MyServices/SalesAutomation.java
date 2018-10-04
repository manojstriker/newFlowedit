package pageobject.MyServices;

import ActionDriver.UTF;
import utilities.XmlReader;

public class SalesAutomation {

	
	XmlReader readData;
	public SalesAutomation(String filename,String className) throws Exception
	{
	UTF.callLog4j(className);
	readData=new XmlReader(filename);
	}
	
	
}
