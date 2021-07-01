package extentreport.part3;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestExtentReportsPart3 {

    /*
    Just like part 1 but with ONLY childTests.
    Here even if the NODE fails, it shows up as fails.
    But a parent should ALWAYS have a child for this to work.
    Parent 'steps' are not displayed if it has NO child items.
     */

    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest parentTest;
    public ExtentTest childTest;

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
        extent.setSystemInfo("Host name", "local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Dipin");
    }

    // CHILD item inside the @Test
    @Test(priority = 0, description = "This is @Test1 description")
    public void test1(){
        parentTest = extent.createTest("TESTNAME1");

        // CHILD item 1
        childTest = parentTest.createNode("STEP1");
        Assert.assertTrue(true, "step1 FAILED");
        // CHILD item 2
        childTest = parentTest.createNode("STEP2");
        Assert.assertTrue(false, "step2 FAILED");
    }

    // CHILD items are from other non-TEST methods
    @Test(priority = 1, description = "This is @Test2 description")
    public void test2(){
        parentTest = extent.createTest("TESTNAME2");
        node1();
        node2();
    }

    public void node1(){
        childTest = parentTest.createNode("Node1");
        Assert.assertTrue(true, "Node1 FAILED");
    }

    public void node2(){
        childTest = parentTest.createNode("Node2");
        Assert.assertTrue(false, "Node2 FAILED");
    }

    // NO CHILD items Only 1 PARENT item
    @Test(priority = 3, description = "This is @Test3 description")
    public void test3(){
        parentTest = extent.createTest("TESTNAME3");
        // As it's a parent item, the 'Step1' won't be displayed
        // FIX - Create a child item - All @Test SHOULD contain child items for this to work
        childTest = parentTest.createNode("Step1");
        Assert.assertTrue(true, "parent item FAILED");
    }

//    @AfterTest
//    public void endReport() {
//
//        extent.flush();
//    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                childTest.log(Status.FAIL, result.getName() + " failed with exception: " + result.getThrowable());
                break;
            case ITestResult.SKIP:
                childTest.log(Status.SKIP, result.getName() + " skipped");
                break;
            default:
                childTest.log(Status.PASS, result.getName() + " passed");
                break;
        }

        extent.flush();
    }

}
