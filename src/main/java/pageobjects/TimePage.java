package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public TimePage(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Time']")
    WebElement btn_Time;

    @FindBy(xpath = "//label[text()='Employee Name']/following::input")
    WebElement txt_EmployeeName;

    @FindBy(xpath = "//div[@role='option']//span[text()='Peter Mac Anderson']")
    WebElement select_name;

    @FindBy(xpath = "//button[contains(@class,'oxd-button oxd-button--medium oxd-button--s') and text()=' View ']")
    WebElement btn_view;

    @FindBy(xpath = "//h6[text()='Timesheet for Timothy Amiano']")
    WebElement lbl_TimesheetHeader;

    public void clickOnTime(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Time));
        btn_Time.click();
    }

    public void EnterEmployeeName(){
        wait.until(ExpectedConditions.elementToBeClickable(txt_EmployeeName));
        txt_EmployeeName.sendKeys("Timothy Lewis");
        WebElement suggestion = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@role='option']//span[text()='Timothy Lewis Amiano']")));
        suggestion.click();
    }

    public void clickOnView(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_view));
        btn_view.click();
    }
    public boolean isTimesheetPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(lbl_TimesheetHeader));
            return lbl_TimesheetHeader.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
