package com.testcases;

import com.java.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LeavePage;

public class LeavePageTest extends BaseTest {

    @Test
    public void LeavePageTestMethod(){
        test = extent.createTest("Leave Page");
        LeavePage leavePage = new LeavePage(driver);

            leavePage.clickOnLeave();
            test.info("clicked on Leave");
            leavePage.EnterFromDate();
            test.info("Entered From Date");
            leavePage.EnterToDate();
            test.info("Entered To Date");
            leavePage.SelectLeaveWithStatus();
            test.info("selected Leave Stats");
            leavePage.clickOnSearch();
            test.info("clicked on Search");
    }
}
