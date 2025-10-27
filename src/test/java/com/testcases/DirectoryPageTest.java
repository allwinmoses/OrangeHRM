package com.testcases;

import com.java.BaseTest;
import org.testng.annotations.Test;
import pageobjects.DirectoryPage;

public class DirectoryPageTest extends BaseTest {

    @Test
    public void DirectoryTest(){
        test = extent.createTest("Directory Page Test");
        DirectoryPage DPage = new DirectoryPage(driver);

            DPage.clickOnDirectory();
            test.info("clicked on Directory");
            DPage.EnterEmployeeName();
            test.info("Entered Employee Name");
            DPage.selectJobTitle();
            test.info("Selected Job Title");
            DPage.selectLocation();
            test.info("selected Location");
            DPage.clickOnSearch();

        }
    }