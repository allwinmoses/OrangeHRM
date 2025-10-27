package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClaimPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public ClaimPage(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Claim']")
    WebElement lnk_Claim;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement txt_EmployeeName;

    @FindBy(xpath = "//label[text()='Status']/following::div[4]")
    WebElement drp_Status;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Submitted']")
    WebElement opt_Submitted;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement btn_Search;

    public void clickOnClaim(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_Claim)).click();
    }

    public boolean EnterEmployeeName() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(txt_EmployeeName));
            txt_EmployeeName.sendKeys("Hamo");
            WebElement suggestion = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@role='option']//span[text()='Hamo raju Beeka']")));
            suggestion.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void selectStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(drp_Status)).click();
        wait.until(ExpectedConditions.elementToBeClickable(opt_Submitted)).click();
    }

    public void clickOnSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Search)).click();
    }

}
