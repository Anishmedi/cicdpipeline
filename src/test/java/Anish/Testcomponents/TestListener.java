package Anish.Testcomponents;


	import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Anish.resources.ExtentReportsNG;

	public class TestListener extends BaseTest implements ITestListener {
		
		ExtentReports extent =ExtentReportsNG.getReportObject();

		ExtentTest test;
		ThreadLocal<ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
		 

	    // This method is invoked each time a test starts
	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	        extentTest.set(test);
	        test.log(Status.INFO, "Test started: " + result.getMethod().getMethodName());
	
	    }

	    // This method is invoked when a test passes
	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	extentTest.get().log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
	    }

	    // This method is invoked when a test fails
	    @Override
	    public void onTestFailure(ITestResult result) {
	    	extentTest.get().log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
	        String filePath = null;
	        extentTest.get().log(Status.FAIL, result.getThrowable());
	        try {
				driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance()
);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 	        
	       try {
			 filePath= getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	        
	    }

	    // This method is invoked when a test is skipped
	    @Override
	    public void onTestSkipped(ITestResult result) {
	    	extentTest.get().log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
	    }

	    // This method is invoked after all tests finish
	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	}

	
	
	


