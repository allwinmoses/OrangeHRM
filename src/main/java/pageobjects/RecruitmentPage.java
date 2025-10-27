package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecruitmentPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'oxd-text o') and text()='Recruitment']")
    WebElement lnk_Recruitment;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Job Title']/following::div[4]")
    WebElement drp_JobTitle;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='IT Manager']")
    WebElement opt_AutomationTester;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Vacancy']/following::div[4]")
    WebElement drp_Vacancy;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Senior QA Lead']")
    WebElement opt_SeniorQALead;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Status']/following::div[4]")
    WebElement drp_Staus;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Interview Passed']")
    WebElement opt_InterviewPassed;

    @FindBy(xpath = "//button[contains(@class,'oxd-button oxd') and text()=' Search ']")
    WebElement btn_Search;

    public void clickOnRecruitment(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_Recruitment));
        lnk_Recruitment.click();
    }

    public void selectJobTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(drp_JobTitle));
        drp_JobTitle.click();
        wait.until(ExpectedConditions.elementToBeClickable(opt_AutomationTester));
        opt_AutomationTester.click();
    }

    public void selectVacancy(){
        wait.until(ExpectedConditions.elementToBeClickable(drp_Vacancy));
        drp_Vacancy.click();
        wait.until(ExpectedConditions.elementToBeClickable(opt_SeniorQALead));
        opt_SeniorQALead.click();
    }

    public void selectStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(drp_Staus));
        drp_Staus.click();
        wait.until(ExpectedConditions.elementToBeClickable(opt_InterviewPassed));
        opt_InterviewPassed.click();
    }

    public void clickOnSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Search));
        btn_Search.click();
    }


}
