package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerImplementation implements ITestListener {
	ExtentSparkReporter reporter=new ExtentSparkReporter("./reports/Suite.html");
	ExtentReports report=new ExtentReports();
	public static ExtentTest logger;

	public void onTestStart(ITestResult result) {
		 
		logger=report.createTest(result.getMethod().getMethodName());

	}

	
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, "This test is passed "+result.getMethod().getMethodName());
		
	}

	
	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, "This test is failed "+result.getMethod().getMethodName());
		logger.addScreenCaptureFromPath(ScreenshotUtility.takingScreenshot(result.getMethod().getMethodName()));
	}
	
	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP, "This test is skipped "+result.getMethod().getMethodName());
		
	}

	
	public void onStart(ITestContext context) {

		 report.attachReporter(reporter);
		
	}

	
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
}
