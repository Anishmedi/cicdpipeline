package Anish.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class  ExtentReportsNG {

	ExtentReports extent;
	public  static ExtentReports getReportObject() {
		String path= System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("web automation");
		reporter.config().setDocumentTitle("test results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TESTER", "ANISH");
		return extent;
		
	}
}
