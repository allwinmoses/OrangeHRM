package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout {

    public WebDriver driver;
    public WebDriverWait wait;

    public Logout(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement lnk_Menu;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement lnk_Logout;

    public void clickOnLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_Menu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(lnk_Logout)).click();
    }
}
