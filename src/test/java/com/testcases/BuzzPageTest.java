package com.testcases;

import com.java.BaseTest;
import com.java.ScreenshotUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BuzzPage;

public class BuzzPageTest extends BaseTest {

    @Test
    public void BuzzTest() {
        test = extent.createTest("Buzz Page Test");
        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickOnBuzz();
        test.info("Clicked on BuzzPage link");

        if (buzzPage.isBuzzHeaderDisplayed()) {
            test.info("Navigated to Buzz page successfully");
            Assert.assertTrue(true, "Header is displayed in Buzz page");
        } else {
            test.info("Header is not displayed in Buzz page");
            Assert.fail("Header is not displayed in Buzz page");
        }
    }
}
