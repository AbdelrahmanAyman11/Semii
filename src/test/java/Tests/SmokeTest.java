package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {

    @Test
    public void verifyTestNGExecution() {
        System.out.println("TestNG is running successfully!");
        Assert.assertTrue(true);
    }
    @Test
    public void verifyTestNGExecution22() {
        System.out.println("TestNG is running successfully222222222222!");
        Assert.assertTrue(true);
    }
    @Test
    public void verifyTestNGExecution33() {
        System.out.println("TestNG is running successfully33333333333!");
        Assert.assertTrue(true);
    }

}