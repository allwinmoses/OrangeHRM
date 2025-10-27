package com.testcases;

import com.java.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.ClaimPage;

public class ClaimPageTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void ClaimTest(){
        test = extent.createTest("ClaimPage Test");
        ClaimPage claimPage = new ClaimPage(driver);
            claimPage.clickOnClaim();
            test.info("clicked on Claim");

        boolean employeeEntered = claimPage.EnterEmployeeName();
        if(employeeEntered){
            test.pass("Entered Employee Name");
        } else {
            test.fail("Failed to enter Employee Name");
            softAssert.fail("EnterEmployeeName failed");

        }
            claimPage.selectStatus();
            test.info("Selected Status");
            claimPage.clickOnSearch();

        softAssert.assertAll();
    }
}
