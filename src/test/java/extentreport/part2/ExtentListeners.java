package extentreport.part2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.*;

import java.util.Arrays;
import java.util.Date;

public class ExtentListeners implements ITestListener, ISuiteListener {

    static Date date = new Date();
    static String fileName = "Extent_" + date.toString().replace(":", "_").replace(" ", "_") + ".html";

    private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir") + "\\reports\\" + fileName);

    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
//    static String messageBody;
//    public static ExtentTest test;

    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testReport.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        // Highlight text in green (optional)
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);
    }

    public void onTestFailure(ITestResult result) {
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + result.getName() + " failed with exception: Exception Occurred: Click to see"
                + "</font>" + "</b >" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n");

        // Highlight text in red (optional)
        String failureLogg = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);
    }

    public void onTestSkipped(ITestResult result) {

        // Highlight text in yellow (optional)
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        testReport.get().skip(m);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

        if (extent != null)
            extent.flush();
    }

    public void onStart(ISuite suite) {

    }

    public void onFinish(ISuite suite) {

//        try {
//            messageBody = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/job/APITestingFramework/Extent_20Reports/" + fileName;
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//
//        MonitoringMail mail = new MonitoringMail();
//        try {
//            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
//        } catch (AddressException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }

    }

}

