package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.*;
import utils.DriverManager;

import java.lang.reflect.Method;

public class BaseTest {

        protected WebDriver driver;
        protected static ExtentReports extent;
        protected ExtentTest test;

        public WebDriver getDriver() {
            return driver;
        }

        @BeforeMethod
        public void setup(Method method) {
            ChromeOptions options = new ChromeOptions();


            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);


            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();

            DriverManager.getDriver().get("https://demowebshop.tricentis.com/");


        }
    @AfterMethod
    public void Quit(ITestResult result) {
        DriverManager.quitDriver();
   }


}
