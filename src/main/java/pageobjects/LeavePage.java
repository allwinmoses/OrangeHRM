package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LeavePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public LeavePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'oxd-text oxd') and text()='Leave']")
    WebElement btn_Leave;

    @FindBy(xpath = "//*[text()='From Date']/following::div[3]/input")
    WebElement date_FromDate;

    @FindBy(xpath = "//*[text()='To Date']/following::div[3]/input")
    WebElement date_ToDate;

    @FindBy(xpath = "//*[text()='Show Leave with Status']/following::div[contains(@class,'oxd-select-text-input')][1]")
    WebElement dropdown_LeaveWithStatus;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Taken']")
    WebElement option_Taken;

    @FindBy(xpath = "//button[contains(@class,'oxd-button oxd-button--medium oxd-button--s')]")
    WebElement btn_search;

    public void clickOnLeave(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Leave));
        btn_Leave.click();
    }

    public void EnterFromDate(){
        wait.until(ExpectedConditions.elementToBeClickable(date_FromDate));
        date_FromDate.sendKeys(Keys.CONTROL + "a");  // select all text
        date_FromDate.sendKeys(Keys.BACK_SPACE);          // clear it completely
        date_FromDate.sendKeys("2025-12-01");
    }

    public void EnterToDate(){
        wait.until(ExpectedConditions.elementToBeClickable(date_ToDate));
        date_ToDate.sendKeys(Keys.CONTROL + "a");
        date_ToDate.sendKeys(Keys.BACK_SPACE);
        date_ToDate.sendKeys("2025-12-12");
    }

    public void SelectLeaveWithStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(dropdown_LeaveWithStatus)).click();
        wait.until(ExpectedConditions.elementToBeClickable(option_Taken)).click();
    }

    public void clickOnSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_search)).click();
    }


}
