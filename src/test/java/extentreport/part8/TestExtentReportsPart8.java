package extentreport.part8;

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

public class TestExtentReportsPart8 {

    /*
    NO tearDown() to fail/pass using Listener
    Have tests with Assert but no test.pass/fail()
    Have tests with Assert & no test.pass/fail()

    Inference:
    test1 & test2 BOTH are marked PASS even when test2 fails assert condn; a test is created - status is set to PASS
    by default - no tearDown() to update Assert status.
    test3 & test4 are marked as pass & fail
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
        test = extent.createTest("test3");
        test.pass("testcase3 passed yay!");
    }

    @Test(description = "fail")
    public void testCase4(){
        test = extent.createTest("test4");
        test.fail("testcase4 failed nooo!!!");
    }

}
