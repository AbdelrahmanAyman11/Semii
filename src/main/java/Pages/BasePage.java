package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.RemoveAds.removeAds;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait ;

    public void safeClick(By locator) {

        try {
            driver.findElement(locator).click();
            if (driver.getCurrentUrl().contains("google_vignette")) {

                driver.navigate().back();

                driver.findElement(locator).click();
            }
        } catch (ElementClickInterceptedException e) {

            removeAds(driver);

            WebElement element = driver.findElement(locator);

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);

        }
    }
    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Clicking
    public void click(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void type(By locator , String text)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .clear();

        driver.findElement(locator).sendKeys(text);
    }
    public String getText(By locator)
    {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    public void submit(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).submit();
    }
    public String getAttribute(By locator, String AttributeName)
    {
         return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(AttributeName);
    }
    public void selection(By locator,String Value)
    {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        Select select = new Select(element);

        select.selectByVisibleText(Value);
    }


}





















//
//    protected WebDriver driver;
//    protected WebDriverWait wait;
//
//    public BasePage(WebDriver driver) {
//
//        this.driver = driver;
//
//        wait = new WebDriverWait(
//                driver,
//                Duration.ofSeconds(10)
//        );
//    }
//
//    protected void click(By locator) {
//
//        wait.until(
//                ExpectedConditions
//                        .elementToBeClickable(locator)
//        ).click();
//    }
//
//    protected void type(By locator, String text) {
//
//        WebElement element = wait.until(
//                ExpectedConditions
//                        .visibilityOfElementLocated(locator)
//        );
//
//        element.clear();
//        element.sendKeys(text);
//    }
//
//    protected String getAttribute(By locator,
//                                  String attribute) {
//
//        return wait.until(
//                ExpectedConditions
//                        .visibilityOfElementLocated(locator)
//        ).getAttribute(attribute);
//    }
//
//    protected String getText(By locator) {
//
//        return wait.until(
//                ExpectedConditions
//                        .visibilityOfElementLocated(locator)
//        ).getText();
//    }