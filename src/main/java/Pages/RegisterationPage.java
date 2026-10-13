package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterationPage extends BasePage{

    public RegisterationPage(WebDriver driver) {
        super(driver);
    }
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By dob = By.id("dob");
    By email = By.id("email");
    By phone = By.id("phone");
    By address = By.id("street");
    By city = By.id("city");
    By state = By.id("state");
    By country = By.id("country");
    By postcode = By.id("postal_code");
    By HouseNum = By.id("house_number");
    By password = By.id("password");
    By registerBtn = By.xpath("//button[@type='submit']");
    public void enterFirstName(String value){
        type(firstName,value);
    }

    public void enterLastName(String value){
        type(lastName,value);
    }

    public void enterDOB(String value){
        type(dob,value);
    }

    public void enterEmail(String value){
        type(email,value);
    }

    public void enterPhone(String value){
        type(phone,value);
    }

    public void enterAddress(String value){
        type(address,value);
    }

    public void enterCity(String value){
        type(city,value);
    }

    public void enterState(String value){
        type(state,value);
    }
    public void enterHouseNumber(String value){
        type(HouseNum,value);
    }


    public void ChooseCountry(String value){
        selection(country,value);
    }

    public void enterPostcode(String value){
        type(postcode,value);
    }

    public void enterPassword(String value){
        type(password,value);
    }

    public void clickRegister(){
        click(registerBtn);
    }

}
