package stepDefinitions;

import Hooks.hooks;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterationPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.Instant;

//import static Hooks.hooks.driver;
import static Hooks.hooks.driver;
import static Hooks.hooks.soft;

public class RegisterationSteps {


    RegisterationPage registration;
    LoginPage loginPage;
    HomePage homePage;
    @Given("User navigates to Registration page")
    public void openRegistrationPage() {

        driver.get("https://practicesoftwaretesting.com/auth/register");
        registration = new RegisterationPage(driver);


    }

    @When("User enters first name {string}")
    public void enterFirstName(String value){
        registration.enterFirstName(value);
    }

    @When("User enters last name {string}")
    public void enterLastName(String value){
        registration.enterLastName(value);
    }
    @When("User enters date of birth {string}")
    public void enterDateOfBirth(String dob) {
        registration.enterDOB(dob);
    }
    @When("User enters street {string}")
    public void enterStreet(String street) {
        registration.enterAddress(street);
    }
    @Then("Registration should be successful")
    public void registrationShouldBeSuccessful(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("/auth/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"));
    }


    @When("User enters email {string}")
    public void enterEmail(String value){

        registration.enterEmail(value);
    }

    @When("User enters phone number {string}")
    public void enterPhone(String value){
        registration.enterPhone(value);
    }


    @When("User enters city {string}")
    public void enterCity(String value){
        registration.enterCity(value);
    }

    @When("User enters state {string}")
    public void enterState(String value){
        registration.enterState(value);
    }

    @When("User enters country {string}")
    public void enterCountry(String value){
        registration.ChooseCountry(value);
    }

    @When("User enters postcode {string}")
    public void enterPostcode(String value){
        registration.enterPostcode(value);
    }
    @When("User enters House number {string}")
    public void enterHouse(String value){
        registration.enterHouseNumber(value);
    }
    @When("User enters password {string}")
    public void enterPassword(String value){
        registration.enterPassword(value);
    }

    @When("User submits the registration form")
    public void submitForm(){
        registration.clickRegister();
    }

    @Then("Date of birth validation message should be displayed")
    public void verifyDOB(){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"dob-error\"]"));
        soft.assertTrue(element.isDisplayed());
    }

    @Then("Email validation message should be displayed")
    public void verifyEmail(){

        WebElement email = driver.findElement(By.id("email-error"));

        soft.assertTrue(email.isDisplayed());

    }

    @Then("Phone validation message should be displayed")
    public void verifyPhone(){

        WebElement phone = driver.findElement(By.id("phone-error"));
        soft.assertTrue(phone.isDisplayed());

    }
    @When("User navigates to Login page")
    public void navigateToLoginPage() {
        driver.get("https://practicesoftwaretesting.com/auth/login");
    }

    @When("User logs in with email {string} and password {string}")
    public void login(String email, String password) {
        loginPage= new LoginPage(driver);
        loginPage.login(email,password);
    }
    @Then("User {string} and {string} should be displayed in the navigation bar")
    public void verifyUserName(String firstname, String Lastname) {
        homePage = new HomePage(driver);

        String str = firstname +" "+Lastname;
        Assert.assertEquals(homePage.getLoggedInUserName(), str);
    }



}