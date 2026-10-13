package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By email = By.id("email");
    private final By password = By.id("password");
    private final By loginBtn = By.className("btnSubmit");

    // Actions

    public void login(String Email, String Password){

        type(email, Email);
        type(password, Password);
        click(loginBtn);

    }
}
