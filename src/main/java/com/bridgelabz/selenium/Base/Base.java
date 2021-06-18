/**
 * Description : MakemytripTest.java is the test file having test case for Make My Trip.
 * Author      : Tushar Chawat
 * Date        : 04/06/2021
 */

package com.bridgelabz.selenium.Base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Base {
    public static WebDriver driver;
    public static ExtentTest test;
    public static ExtentReports report;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    @BeforeTest
    public static void setup() {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
        } catch (MalformedURLException e) {
            System.out.println("Internet is not connected");
        } catch (IOException e) {
            System.out.println("Internet is not connected");
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        tdriver.set(driver);
        driver.get("https://www.makemytrip.com/");
        report = new ExtentReports("C:\\Users\\Admin\\Zoopla_Mevan\\Extent_Report.html");
        test = report.startTest("Extent_Report");
    }

    public static WebDriver getDriver() {
        return tdriver.get();
    }

    @AfterMethod
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
