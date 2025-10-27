package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver; // this referring this.driver

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement txt_username;

    @FindBy(name ="password")
    WebElement txt_password;

    @FindBy(xpath = "//button[contains(@class,'oxd-button oxd')]")
    WebElement btn_login;


    public void enterUsername(String username){
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password){
        txt_password.sendKeys(password);
    }

    public void clickLogin(){
        btn_login.click();
    }
}
