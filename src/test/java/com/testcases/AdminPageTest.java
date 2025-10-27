package com.testcases;

import com.java.BaseTest;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobjects.AdminPage;

import java.time.Duration;

public class AdminPageTest extends BaseTest {


    @Test
    public void AdminTest(){
        test = extent.createTest("Admin Page");
        AdminPage ad = new AdminPage(driver);

            ad.ClickOnAdmin();
            test.info("clicked on Admin");
            ad.EnterUsername();
            test.info("Entered Username");
            ad.selectUserRole();
            test.info("UserRole selected");
            ad.selectStatus();
            test.info("Status selected");
            ad.clickOnSearch();
            test.info("clicked on Search");

    }
}
