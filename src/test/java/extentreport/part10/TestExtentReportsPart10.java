package extentreport.part10;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExtentReportsPart10 {

    /*
    If I use only test.pass()/fail() how will I Assert a method?

    No tearDown().
    A method with an assert condition.
    And insert a test.fail() in the try-catch block to capture assertion exceptions.

    Inference: test.fail() inside catch block never get executed after Assertion failure.
    So in the report the Test is marked as Pass (default status).
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

    @Test(description = "assert true inside a try-catch block")
    public void testCase1(){
        test = extent.createTest("test1");
        try {
            Assert.fail("assert condn failed");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION : " + e);
            test.fail("test log inside catch block");
        }
    }


}
