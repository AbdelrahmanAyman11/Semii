package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class hooks {

    public static WebDriver driver;
    public static SoftAssert soft = new SoftAssert();
    @Before
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
    }

    @After
    public void tearDown() throws InterruptedException {

        if(driver != null) {
            driver.quit();
        }
        soft.assertAll();

    }
}