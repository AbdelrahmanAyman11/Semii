package listeners;

import Tests.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.ScreenShots;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class TestListener implements ITestListener {

//    ExtentReports extent = ExtentManager.getInstance();

//    ExtentTest test;
private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("hello");
        logger.info("jghjgkjh");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed !!");


    }

    @Override
    public void onTestFailure(ITestResult result) {
        //1
        System.out.println();

        //2 Save the screenshot on my device
        WebDriver driver1 =  ((BaseTest) result.getInstance()).getDriver();
        String screenshotPath= ScreenShots.capture(driver1,result.getName());

        //3 : pass to report

    }

    @Override
    public void onTestSkipped(ITestResult result) {
       logger.info("khkjlhj");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution Started");
//        test.info("Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            ExtentManager.flushReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



//
//    ExtentReports extent = ExtentManager.getInstance();
//
//    ExtentTest test;
//
//    @Override
//    public void onStart(ITestContext context) {
//        System.out.println("Execution Started");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        try {
//            ExtentManager.flushReport();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        test = extent.createTest(result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//       ;
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//
//        test.fail(result.getThrowable());
//
//
//
//        String screenshotPath =
//                ScreenShots.capture(driver, result.getName());
//
//
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        System.out.println(result.getName() + " Skipped");
//    }