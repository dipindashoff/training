package extentreport.part13;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class TestExtentReportsPart13 {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal();

    @BeforeSuite
    public void beforeSuite() {
        String dateTime = LocalDateTime.now().toString().replaceAll("\\W", "_");
        System.out.println("Building extent report...");
        extent = ExtentManager.createInstance("extent_"+dateTime+".html");
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
//        extent.attachReporter(htmlReporter);
    }

    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            test.get().fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            test.get().skip(result.getThrowable());
        else
            test.get().pass("Test passed");

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
        if (a == 1) {
            Assert.fail("method1 assertion fails for 1");
            return "Apple";
        }
        else if(a == 3){
            Assert.fail("method1 assertion fails for 3");
            return "Apple";
        }
        else {
            return "Ball";
        }

    }

    @Test(dataProvider = "getData")
    public void method2(int a, int b) {
        String str = method1(a, b);
        System.out.println(str);
    }
}
