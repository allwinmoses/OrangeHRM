package com.testcases;

import com.java.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TimePage;

public class TimePageTest extends BaseTest {

    @Test
    public void TimeTest(){
        test = extent.createTest("TimePage Test");
        TimePage timePage = new TimePage(driver);
            timePage.clickOnTime();
            test.info("clicked on Time");
            timePage.EnterEmployeeName();
            test.info("Entered Employee Name");
            timePage.clickOnView();
            test.info("clicked on View");

        if (timePage.isTimesheetPageDisplayed()){
            test.info("Navigated to Timesheet page successfully");
            Assert.assertTrue(true,"Timesheet page is displayed");
        }else {
            test.info("Failed to navigate to Timesheet page");
            Assert.fail("Timesheet page is not displayed");
        }
    }

}
