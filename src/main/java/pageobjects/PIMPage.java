package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {

   public WebDriver driver;
   public WebDriverWait wait;

    public PIMPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']")
    WebElement btn_PIM;

    @FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
    WebElement txt_EmployeeName;

    @FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
    WebElement num_EmployeeId;

    @FindBy(xpath = "//button[contains(@class,'oxd-button oxd') and text()=' Search ']")
    WebElement btn_Search;

    public void ClickOnPIM(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_PIM));
        btn_PIM.click();
    }
    public void EnterEmployeeName(){
        wait.until(ExpectedConditions.elementToBeClickable(txt_EmployeeName));
        txt_EmployeeName.sendKeys("Test");
    }
    public void EnterEmployeeId(){
        wait.until(ExpectedConditions.elementToBeClickable(num_EmployeeId));
        num_EmployeeId.sendKeys("0442");
    }
    public void clickOnSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Search));
        btn_Search.click();
    }
}
