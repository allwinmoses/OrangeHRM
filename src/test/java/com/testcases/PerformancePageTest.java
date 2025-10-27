package com.testcases;

import com.java.BaseTest;
import org.testng.annotations.Test;
import pageobjects.PerformancePage;

public class PerformancePageTest extends BaseTest {

    @Test
    public void PerformanceTest(){
        test = extent.createTest("Performance Page Test");
        PerformancePage PPage = new PerformancePage(driver);

            PPage.clickOnPerformance();
            test.info("clicked on Performance");
            PPage.EnterEmployeeName();
            test.info("Entered Employee Name");
            PPage.JobTitle();
            test.info("Selected Job Title");
            PPage.ReviewStatus();
            test.info("Selected Review Status");
            PPage.clickOnSearch();
            test.info("clicked on Search");

    }
}
