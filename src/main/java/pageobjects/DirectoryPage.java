package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DirectoryPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public DirectoryPage(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'oxd-text oxd') and text()='Directory']")
    WebElement lnk_Directory;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement txt_EmployeeName;

    @FindBy(xpath = "//label[text()='Job Title']/following::div[4]")
    WebElement drp_JobTitle;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Chief Financial Officer']")
    WebElement opt_CFOfficer;

    @FindBy(xpath = "//label[text()='Location']/following::div[4]")
    WebElement drp_Location;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='New York Sales Office']")
    WebElement opt_NewYork;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement btn_Search;

    public void clickOnDirectory(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_Directory)).click();
    }

    public void EnterEmployeeName(){
        wait.until(ExpectedConditions.elementToBeClickable(txt_EmployeeName));
        txt_EmployeeName.sendKeys("Peter");
        WebElement suggestion = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@role='option']//span[text()='Peter Mac Anderson']")));
        suggestion.click();
    }

    public void selectJobTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(drp_JobTitle)).click();
        wait.until(ExpectedConditions.elementToBeClickable(opt_CFOfficer)).click();
    }

    public void selectLocation(){
        wait.until(ExpectedConditions.elementToBeClickable(drp_Location)).click();
        wait.until(ExpectedConditions.elementToBeClickable(opt_NewYork)).click();
    }

    public void clickOnSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Search)).click();
    }
}
