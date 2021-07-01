package extentreport.part12;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class TestExtentReportsPart12 {

    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeTest
    public void setExtent() {
        // specify location of the report
        String dateTime = LocalDateTime.now().toString().replaceAll("\\W", "_");
        htmlReporter = new ExtentSparkReporter("./test-output/extent_"+ dateTime+".html");

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



    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }

    public String method1(int a, int b) {
        if (a == 1 || a == 3) {
            Assert.fail("method1 assertion fails");
            return "Apple";
        } else {
//0            Assert.fail("method1 assertion fails");
            return "Ball";
        }

    }

    @Test(dataProvider = "getData")
    public void method2(int a, int b) {
        test = extent.createTest("test1" + a);
        String str = method1(a, b);
        if(str == "Apple")
            Assert.assertTrue(true, "");
        System.out.println(str);
    }

}
