package extentreport.part7;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class TestExtentReportsPart7 {

    /*
    Have a tearDown() to fail/pass using Listener
    Have a test with Assert
    Have another test with test.pass/fail()

    Inference: It adds 2 passes instead of 1.
     */

    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeTest
    public void setExtent() {
        // specify location of the report
        htmlReporter = new ExtentSparkReporter("./test-output/extent.html");

        htmlReporter.config().setDocumentTitle("Automation Report"); // Title of report
        htmlReporter.config().setReportName("Functional Testing"); // Name of the report
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Passing General information
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Dipin");
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }

    @Test(description = "assert true")
    public void testCase1(){
        test = extent.createTest("test1");
        Assert.assertTrue(true);
    }

    @Test(description = "assert false")
    public void testCase2(){
        test = extent.createTest("test2");
        Assert.assertTrue(false);
    }

    @Test(description = "pass")
    public void testCase3(){
        test = extent.createTest("test2");
        test.pass("testcase3 passed yay!");
    }

    @Test(description = "fail")
    public void testCase4(){
        test = extent.createTest("test2");
        test.fail("testcase4 failed nooo!!!");
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
                test.fail(result.getName() + " failed with exception: " + result.getThrowable());
                break;

            case ITestResult.SKIP:
                test.skip(result.getName() + " skipped");
                break;

            case ITestResult.SUCCESS:
                test.pass(result.getMethod().getDescription());
                break;
        }
    }

}
