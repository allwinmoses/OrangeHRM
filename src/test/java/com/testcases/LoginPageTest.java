package com.testcases;

import com.java.BaseTest;
import com.poiji.bind.Poiji;
import data.ExcelDataObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class LoginPageTest extends BaseTest {


    @Test
    public void loginTest(){
        // Create Extent test node
        test = extent.createTest("Login Test - OrangeHRM");

        // Step 1: Read Excel data into list
        List<ExcelDataObject> data = Poiji.fromExcel(
                new File("./src/test/resources/Excel/Testdata.xlsx"), ExcelDataObject.class);
        // Step 2: Iterate through each row of Excel
        for (ExcelDataObject row : data) {
            try {
                LoginPage loginPage = new LoginPage(driver);
                // Step 3: Use username & password from ExcelDataObject
                loginPage.enterUsername(row.UserName);
                loginPage.enterPassword(row.Password);
                loginPage.clickLogin();
                test.pass("Login Successful with user :" + row.UserName);
            } catch (Exception e){
                test.fail("Login failed for user: " + row.UserName + " | Error: " + e.getMessage());
            }
        }
    }

}

