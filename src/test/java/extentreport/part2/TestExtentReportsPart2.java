package extentreport.part2;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static extentreport.part2.ExtentListeners.testReport;

//import static extentreport.part2.ExtentListeners.test;

public class TestExtentReportsPart2 {

    /*
    Extent Reports are created in a separate class
    CHILD Nodes always appears PASS even if the node fails - However the TC FAILS
     */

    @Test
    public void testcasePass(){
        System.out.println("This test will PASS");
    }

    @Test
    public void testcaseFail(){
        Assert.fail("This test will FAIL");
    }

    @Test
    public void testcaseSkip(){
        throw new SkipException("This test will be SKIPPED");
    }


    @Test
    public void testWithNodes(){
        testReport.get().createNode("Node 1");
        Assert.assertTrue(true);

        testReport.get().createNode("Node 2");
        Assert.assertTrue(false);
    }
}
