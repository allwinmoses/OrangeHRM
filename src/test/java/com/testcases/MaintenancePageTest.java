package com.testcases;

import com.java.BaseTest;
import com.poiji.bind.Poiji;
import data.ExcelDataObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.MaintenancePage;

import java.io.File;
import java.util.List;

public class MaintenancePageTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void MaintenanceTest() {
        test = extent.createTest("Maintenance Page Test");
        List<ExcelDataObject> data = Poiji.fromExcel(
                new File("./src/test/resources/Excel/Testdata.xlsx"), ExcelDataObject.class);
        for (ExcelDataObject row : data) {

            MaintenancePage MPage = new MaintenancePage(driver);
            MPage.clickOnMaintenance();
            test.info("Clicked on Maintenance");
            MPage.EnterPassword(row.Password);
            test.info("Entered Password");
            MPage.clickOnConfirm();
            boolean employeeEntered = MPage.EnterEmployeeName();
            if (employeeEntered) {
                test.info("Entered Employee Name");
            } else {
                test.fail("Failed to enter Employee Name");
                softAssert.fail("EnterEmployeeName failed");
                MPage.clickOnSearch();
            }
        }
    }
}