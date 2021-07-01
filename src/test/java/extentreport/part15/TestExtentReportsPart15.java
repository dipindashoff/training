package extentreport.part15;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestExtentReportsPart15 extends ExtentTestNGReportBuilder {
    /*
    Extent Reports are created in a separate class ExtentTestNGReportBuilder - NO listener here
    CHILD Nodes always appears PASS even if the node (child-child) fails - However the TC FAILS
     */

    @Test(priority = 0)
    public void test1() {
        Assert.assertTrue(true, "test1 failed");
    }

    @Test(priority = 1)
    public void test2() {
        Assert.assertTrue(false, "test2 failed");
    }

    @Test(priority = 2)
    public void test3() {
        test.get().createNode("Node 1");
        Assert.assertTrue(true);

        test.get().createNode("Node 2");
        Assert.assertTrue(true, "node2 failed");

        // This TEST fails because node3 fails
        // Extent Report:
        // Test fails but node3 is marked as PASS (as only child tests status are marked as pass - not the child of
        // child)
        test.get().createNode("Node 3");
        Assert.assertTrue(false, "node3 failed");

    }

}

