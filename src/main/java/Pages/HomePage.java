package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    By loggedUser = By.cssSelector("[data-test='nav-menu']");

    public String getLoggedInUserName() {
        return getText(loggedUser);
    }
}
