package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Calendar clendar= Calendar.getInstance();
		SimpleDateFormat fromt=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		String date=fromt.format(clendar.getTime());
		String method=result.getName();
		//Log4j.infoLog(method+date);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log4j.infoLog(result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Calendar calender=Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		String date=format.format(calender.getTime());
		Log4j.infoLog("***** Error "+result.getName()+" test has failed *****");
		String methodName=result.getName().toString().trim();
		String filePath=System.getProperty("user.dir")+"\\src\\testngReports\\ScreenShots\\";
		Log4j.infoLog("filepath is "+filePath);
		ActionDriver.UTF.takeScrenShort(filePath+methodName+date);
		Log4j.infoLog("***** Place screen Short in"+filePath+"****");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Log4j.infoLog(result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		Log4j.infoLog(result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	//	Log4j.infoLog(context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Log4j.infoLog(context.getName());
	}

}
