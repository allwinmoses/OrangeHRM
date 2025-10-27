package com.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtendReport {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {
        if (extent == null) {

            String path = System.getProperty("user.dir") + "/reports/extentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            spark.config().setReportName("OrangeHRM Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports(); //  assign to the class-level variable
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Allwin");
        }
        return extent;
    }
}