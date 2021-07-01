package extentreport.part1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class TestExtentReportsPart1 {

    /*
    Extent Report creation is Inline here.
    CHILD Nodes always appears PASS even if the node fails - However the TC FAILS
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

    @Test()
    public void testCase1(){
        test = extent.createTest("This test will PASS");
        Assert.assertTrue(true);
    }

    @Test()
    public void testCase2(){
        test = extent.createTest("This test will FAIL");
        Assert.assertFalse(true);
    }

    @Test()
    public void testCase3(){
        test = extent.createTest("This test will be SKIPPED");
        throw new SkipException("Skip this testCase3");
    }

//    @Test()
    public void testCasePass2(){
        test = extent.createTest("This test will PASS");
        Assert.assertTrue(true);
    }

//    @Test()
    public void testCasePass3(){
        test = extent.createTest("This test will PASS");
        Assert.assertTrue(true);
    }

    @Test()
    public void testCaseWithNodes(){
        test = extent.createTest("This test has 2 nodes");
        test.createNode("This node will PASS");
        Assert.assertTrue(true);

        test.createNode("This node will FAIL");
        Assert.assertTrue(false);

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
