package com.testcases;

import com.java.BaseTest;
import org.testng.annotations.Test;
import pageobjects.Logout;

public class LogoutPageTest extends BaseTest {

    @Test
    public void LogoutTest(){
        test = extent.createTest("Logout Test");
        Logout logout = new Logout(driver);
            logout.clickOnLogout();
            test.pass("Logout Successful");
    }
}
