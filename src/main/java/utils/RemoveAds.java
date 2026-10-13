package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RemoveAds {
    public static void removeAds(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "document.querySelectorAll('iframe').forEach(e => e.remove());"
        );
    }
}
