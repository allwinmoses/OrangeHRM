package com.testcases;

import com.java.BaseTest;
import org.testng.annotations.Test;
import pageobjects.PIMPage;

public class PIMPageTest extends BaseTest {

    @Test
    public void PimPageTest(){
        test = extent.createTest("PIM Page");

        PIMPage pim = new PIMPage(driver);

            pim.ClickOnPIM();
            test.info("clicked on PIM");
            pim.EnterEmployeeName();
            test.info("Entered EmployeeName");
            pim.EnterEmployeeId();
            test.info("Entered EmployeeId");
            pim.clickOnSearch();
            test.info("clicked on Search");


    }
}
