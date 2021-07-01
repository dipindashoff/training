package extentreport.part16;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentTestNGITestListener implements ITestListener {
    //    private static ThreadLocal parentTest = new ThreadLocal();
//    private static ThreadLocal test = new ThreadLocal();
    public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal();
    private static ExtentReports extent = ExtentManager.createInstance();

    @Override
    public synchronized void onStart(ITestContext context) {
//        ExtentTest parent = extent.createTest(getClass().getName());
        // context.getName() - gets the name of <test> from xml
        ExtentTest parent = extent.createTest(context.getName());
        parentTest.set(parent);
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
        test.set(child);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
}
