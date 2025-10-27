package com.testcases;

import com.java.BaseTest;
import org.testng.IResultMap;
import org.testng.annotations.Test;
import pageobjects.RecruitmentPage;

public class RecruitmentPageTest extends BaseTest {


    @Test
    public void RecruitmentTest(){
        test = extent.createTest("Recruitment Page Test");
        RecruitmentPage rp = new RecruitmentPage(driver);

            rp.clickOnRecruitment();
            test.info("clicked on Recruitment");
            rp.selectJobTitle();
            test.info("selected Job Title");
            rp.selectVacancy();
            test.info("selected Vacancy");
            rp.selectStatus();
            test.info("selected Status");
            rp.clickOnSearch();
            test.info("clicked on Search");

    }

}
