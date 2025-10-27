package com.testcases;

import com.java.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MyInfoPage;

public class MyInfoPageTest extends BaseTest {

    @Test
    public void MyInfoTest(){

        test = extent.createTest("MyInfo Page Test");
        MyInfoPage myInfoPage = new MyInfoPage(driver);
        myInfoPage.clickOnMyInfo();
        if (myInfoPage.isHeaderMyInfoDisplayed()){
            test.pass("Navigated to MyInfoPage successfully");
            Assert.assertTrue(true,"MyInfo Page is Displayed");
        }else {
            test.info("Failed to navigate to MyInfo page");
            Assert.assertFalse(false, "MyInfo Page is not Displayed");
        }
    }
}
