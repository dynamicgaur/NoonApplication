package Utility.Listener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersDefinitionClass implements ITestListener {
	
	public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test case started");

    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test case passed");

    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test case failed");


    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test case skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("Test case started");

    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("Test case finished");

    }

	
	

}
