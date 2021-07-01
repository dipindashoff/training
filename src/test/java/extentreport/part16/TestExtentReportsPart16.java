package extentreport.part16;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static extentreport.part4.ExtentTestNGITestListener.test;

public class TestExtentReportsPart16 {

     /*
    Extent Reports are created in a separate Listener class
     */

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
