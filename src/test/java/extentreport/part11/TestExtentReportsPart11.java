package extentreport.part11;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExtentReportsPart11 {

    /*
    A Test calls a method that fails assertion but the assertion in the Test is pass.
    A Test calls a method that throws a NullPointerException but the assertion in the Test is pass.
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
        test = extent.createTest("test1");
        //
        method1();
        Assert.assertTrue(true);
    }

    @Test()
    public void testCase2(){
        test = extent.createTest("test2");
        //
        method2();
        Assert.assertTrue(true);
    }

    public void method1(){
        Assert.fail("method1 failed - assertion error");
    }

    public void method2(){
        throw new NullPointerException("return value is null at method2");
    }

}
