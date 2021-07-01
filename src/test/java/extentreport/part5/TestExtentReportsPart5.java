package extentreport.part5;

import org.testng.Assert;
import org.testng.annotations.Test;

import static extentreport.part5.ExtentListeners5.test;

public class TestExtentReportsPart5 {

     /*
    Extent Reports are created in a separate class
    @Tests without CHILD nodes
    Mix of both:
    Using TestNg listeners & assertions to trigger pass/fail status
    along with test.pass()/test.fail() to mark pass/fail

    Inference: If you use both, assertions & test.log() in @Tests ie assertion in one @Test and test.pass() in
    another @Test,
    test.fail() fails the step,
    but the lack of Assertion in @Test) will insert another entry that the step passed because of no assertion
    errors.
    The @Test ultimately.
    FAILS)
     */

    @Test(priority = 0, description = "test1 description")
    public void test1() {
        Assert.assertTrue(true, "test1 failed");
    }

    @Test(priority = 1, description = "test2 description")
    public void test2() {
        Assert.assertTrue(false, "test2 failed");
    }

    @Test(priority = 2, description = "test3 description")
    public void test3() {
        test.get().pass("test3 PASSED");
    }

    @Test(priority = 3, description = "test4 description")
    public void test4() {
        test.get().fail("test4 FAILED");
    }

}
