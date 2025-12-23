package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import baseclass.launchezhour;

public class Externreportmanager implements ITestListener {
	
	
	public ExtentSparkReporter extentsparkreporter;
	public  ExtentReports externreport;
	public ExtentTest test;
	

	 public void onStart(ITestContext context) {
		 
		 
		 extentsparkreporter=new ExtentSparkReporter("./newreports/reports.html");
		 extentsparkreporter.config().setDocumentTitle("Automation result");
		 extentsparkreporter.config().setReportName("Ezhour function testing");
		 extentsparkreporter.config().setTheme(Theme.DARK);
		 
		 
		 
		  externreport=new ExtentReports();
		 externreport.attachReporter(extentsparkreporter);
		 
		 
		 externreport.setSystemInfo("System", "windows");
		 externreport.setSystemInfo("Project Name", "Ezhour");
		    
		  }
	 
	public void onTestStart(ITestResult result) {
		 test=  externreport.createTest(result.getName()).assignAuthor("Rengaraj Kumaravel");
		
		
		
	  }
	
	   
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case is passed " +result.getName());
	
	     
	   }

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case is failed " +result.getName());
		test.log(Status.FAIL, "Test case failed reason" +result.getThrowable()); 

	    Object currentclass = result.getInstance();
	    WebDriver driver = ((launchezhour) currentclass).driver;
	    String screenshotpath = getscreenshort(driver, result.getName());

	    try {
	        test.addScreenCaptureFromPath(screenshotpath);
	    } catch (Exception e) {
	        System.out.println(e);
	    }
		
		
		  }
	   
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case is skipped" +result.getName());
		    
		  }
	public void onFinish(ITestContext context) {
		   externreport.flush();
		  }
	
	
	public String getscreenshort(WebDriver driver,String imagename)
	{
		SimpleDateFormat dataformat=new SimpleDateFormat("yy-MM-dd_HH-mm");
		String timestamp=dataformat.format(new Date());
		
		TakesScreenshot takescreenshort=(TakesScreenshot)driver;
		File sourcepath=takescreenshort.getScreenshotAs(OutputType.FILE);
	String path="./screenshort/"+imagename+ " "+timestamp+ ".png";
		File destinationpath=new File(path);
//		sourcepath.renameTo(destinationpath);
		  try {
			FileUtils.copyFile(sourcepath, destinationpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationpath.getAbsolutePath();
		
	}
	
}
