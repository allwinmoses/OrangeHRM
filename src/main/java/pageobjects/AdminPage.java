package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

    public WebDriver driver;// this referring this.driver
    public WebDriverWait wait;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "//span[text() ='Admin']")
    WebElement btn_Admin;

   @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    WebElement txt_EnterUsername;

    @FindBy(xpath = "//label[text()='User Role']/following::div[contains(@class,'oxd-select-text-input')][1]")
    WebElement dropdown_UserRole;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Admin']")
    WebElement option_Admin;

    @FindBy(xpath = "//label[text()='Status']/following::div[@class='oxd-select-text-input']")
    WebElement dropdown_Status;

    @FindBy(xpath = "//div[@role='option']//span[text()='Enabled']")
    WebElement option_Enabled;

    @FindBy(xpath = "//button[contains(@class,'oxd-button') and text()=' Search ']")
    WebElement btn_Search;


   public void ClickOnAdmin(){

       wait.until(ExpectedConditions.elementToBeClickable(btn_Admin));
       btn_Admin.click();
    }

    public void EnterUsername(){
        wait.until(ExpectedConditions.visibilityOf(txt_EnterUsername));
        txt_EnterUsername.sendKeys("Admin");

    }
    public void selectUserRole(){
        wait.until(ExpectedConditions.elementToBeClickable(dropdown_UserRole)).click();
        wait.until(ExpectedConditions.elementToBeClickable(option_Admin)).click();
    }
    public void selectStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(dropdown_Status)).click();
        wait.until(ExpectedConditions.elementToBeClickable(option_Enabled)).click();
    }

    public void clickOnSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Search)).click();
    }




}
