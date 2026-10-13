package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {

    @Test
    public void verifyTestNGExecution() {
        System.out.println("TestNG is running successfully!");
        Assert.assertTrue(true);
    }
}