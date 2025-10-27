package com.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;


    @BeforeSuite
    public void setupSuite() throws IOException {
        extent = ExtendReport.getReportObject();
        // browser initialization
        Properties prop = new Properties();// class in Java
        File file = new File("./src/test/resources/properties/config.properties");
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void captureFailureScreenshot(ITestResult result) {
        try {
            // Always create test entry if not already created
            if (test == null) {
                test = extent.createTest(result.getName());
            }

            if (result.getStatus() == ITestResult.FAILURE) {
                // Take screenshot (this will overwrite the old one)
                String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());

                // Log failure in Extent Report and screenshot button
                test.fail("Test failed: " + result.getThrowable() +
                        "<br><a href='" + screenshotPath + "' target='_blank' " +
                        "style='display:inline-block; padding:5px 10px; background-color:#f44336; " +
                        "color:white; text-decoration:none; border-radius:5px; margin-top:5px;'>View Screenshot</a>");

            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass(result.getName() +" passed successfully");
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.skip("Test skipped: " + result.getThrowable());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterSuite
    public void teardownSuite() {
        if (extent != null) {
            extent.flush();
        }
        // Close browser only once after all tests
        if (driver != null) {
            driver.quit();
        }
    }
}
