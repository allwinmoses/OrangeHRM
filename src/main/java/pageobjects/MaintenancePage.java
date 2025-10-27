package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MaintenancePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public MaintenancePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Maintenance']")
    WebElement lnk_Maintenance;

    @FindBy(xpath = "//input[@name='password']")
    WebElement txt_Password;

    @FindBy(xpath = "//button[text()=' Confirm ']")
    WebElement btn_Confirm;

    @FindBy(xpath = "//a[text()='Access Records']")
    WebElement lnk_AccessRecords;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement txt_EmployeeName;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement btn_Search;

    public void clickOnMaintenance() {
        wait.until(ExpectedConditions.elementToBeClickable(lnk_Maintenance)).click();
    }

    public void EnterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(txt_Password));
        txt_Password.sendKeys(password);
    }

    public void clickOnConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Confirm)).click();
    }

    public boolean EnterEmployeeName() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_AccessRecords)).click();
            wait.until(ExpectedConditions.elementToBeClickable(txt_EmployeeName));
            txt_EmployeeName.sendKeys("Timothy");
            WebElement suggestion = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@role='option']//span[text()='Timothy Lewis Amiano']")));
            suggestion.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Search)).click();
    }
}