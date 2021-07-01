package extentreport.part4;

import org.testng.Assert;
import org.testng.annotations.Test;

import static extentreport.part4.ExtentTestNGITestListener.test;

public class TestExtentReportsPart4 {

     /*
    Extent Reports are created in a separate class
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

//        // Node 3 will not execute if Node2 assertion failed
//        test.get().createNode("Node 3");
//        Assert.assertTrue(false, "node3 failed");

        test.get().createNode("Node 3");
        int i = 2;
        if (i == 1)
            test.get().pass("node3 passed");
        else{
            System.out.println("node3 failed");
            test.get().fail("node3 failed");
        }
//        Assert.assertTrue(false, "node3 failed");
    }

}
