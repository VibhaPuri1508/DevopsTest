package com.ecstore.utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;


public class ListenerClass extends ExtentManager implements ITestListener {

	WebActions action = new WebActions();
	BaseClass base = new BaseClass();
	WebDriver driver=null;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Passed Test case is: " + result.getName());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String methodName = result.getName().toString().trim();
			ITestContext context = result.getTestContext();
			WebDriver driver = base.getDriver();
			action.screenShot(driver, methodName);
		}
		
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		 extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
}
