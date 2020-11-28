package cucumberoptions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.qa.base.Base;
public class Listeners extends Base implements ITestListener {
@Override
	public void onTestStart(ITestResult result) {
	  
		log.info("Test scenarios has been started i.e. " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test scenarios has been passed i.e. " + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	Listeners.getScreenshotPath(result.getMethod().getMethodName());	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}
		
	public static String getScreenshotPath(String testname)
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hhmmss");
		String timestamp = sdf.format(d);
		TakesScreenshot ts = (	TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationpath = "./" + "/Screenshots/" + testname + "_" + timestamp + ".png";
		File dest = new File(destinationpath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationpath;
	
	}
//We can use the following method too to retrieve the screenshot
	public static String getCurrentDateandTimeInScreenshot(String testname)
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		String timestamp = sdf.format(d);
		timestamp = timestamp.replace(" " , "").replaceAll("/", "").replaceAll(":", "");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationpath = "./" + "/Screenshots/" + testname + "_" + timestamp + ".png";
		File dest = new File(destinationpath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationpath;	}
	
	
	
		
}
 