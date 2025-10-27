package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PerformancePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public PerformancePage(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'oxd-text oxd') and text()='Performance']")
    WebElement lnk_Performance;

    @FindBy(xpath = "//input[@Placeholder='Type for hints...']")
    WebElement txt_EmployeeName;

    @FindBy(xpath = "//label[text()='Job Title']/following::div[4]")
    WebElement drp_JobTitle;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='QA Engineer']")
    WebElement opt_QAEngineer;

    @FindBy(xpath = "//label[text()='Review Status']/following::div[4]")
    WebElement drp_RStatus;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Completed']")
    WebElement opt_Completed;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement btn_Search;

    public void clickOnPerformance(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_Performance));
        lnk_Performance.click();
    }

    public void EnterEmployeeName(){
        wait.until(ExpectedConditions.elementToBeClickable(txt_EmployeeName));
        txt_EmployeeName.sendKeys("Joseph");
        // Wait briefly for suggestions to load
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Press Arrow Down to move to first suggestion, then Enter to select
        txt_EmployeeName.sendKeys(Keys.ARROW_DOWN);
        txt_EmployeeName.sendKeys(Keys.ENTER);
    }

    public void JobTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(drp_JobTitle));
        drp_JobTitle.click();
        wait.until(ExpectedConditions.elementToBeClickable(opt_QAEngineer));
        opt_QAEngineer.click();
    }

    public void ReviewStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(drp_RStatus));
        drp_RStatus.click();
        wait.until(ExpectedConditions.elementToBeClickable(opt_Completed));
        opt_Completed.click();
    }

    public void clickOnSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Search));
        btn_Search.click();
    }
}
