package extentreport.part14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class TestExtentReportsPart14 extends ExtentTestNGReportBuilder {

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
