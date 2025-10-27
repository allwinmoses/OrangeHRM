package pageobjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public MyInfoPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'oxd-text') and text()='My Info']")
    WebElement lnk_MyInfo;

    @FindBy(xpath = "//h6[contains(@class,'oxd-text') and text()='Personal Details']")
    WebElement lbl_headerMyInfo;

    public void clickOnMyInfo(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_MyInfo));
        lnk_MyInfo.click();
    }

    public boolean isHeaderMyInfoDisplayed(){
        try{
            wait.until(ExpectedConditions.visibilityOf(lbl_headerMyInfo));
            return lbl_headerMyInfo.isDisplayed();
        } catch (TimeoutException e){
            return false;
        }
    }
}
