package pageobjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuzzPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BuzzPage(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Buzz']")
    WebElement lnk_Buzz;

    @FindBy(xpath = "//h6[text()='Buzz']")
    WebElement header_Buzz;

    public void clickOnBuzz(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_Buzz)).click();
    }

    public boolean isBuzzHeaderDisplayed(){
        try{
            wait.until(ExpectedConditions.visibilityOf(header_Buzz));
            return header_Buzz.isDisplayed();
        }catch (TimeoutException e){
            return false;
        }
    }
}
