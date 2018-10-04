package pageobject.MyServices;

import ActionDriver.UTF;
import utilities.XmlReader;

public class MarketingAutomation {

	XmlReader readData;
	public MarketingAutomation(String filename,String className) throws Exception
	{
	UTF.callLog4j(className);
	readData=new XmlReader(filename);
	}
}
