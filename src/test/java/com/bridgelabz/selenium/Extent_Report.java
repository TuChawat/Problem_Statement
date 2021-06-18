/**
 * Description : Extent_Report.java is the test file having test case for generating Extent Report.
 * Author      : Tushar Chawat
 * Date        : 02/06/2021
 */

package com.bridgelabz.selenium;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Extent_Report {
    static ExtentTest test;
    static ExtentReports report;
    public static WebDriver driver;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports("C:\\Users\\Admin\\Problem_Statement\\Extent_Report.html");
        test = report.startTest("Extent_Report");
    }
    @Test
    public void extentReportsDemo()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in");
        if(driver.getTitle().equals("Google"))
        {
            test.log(LogStatus.PASS, "Navigated to the specified URL");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed");
        }
    }
    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
