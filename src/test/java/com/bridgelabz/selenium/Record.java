/**
 * Description : Record.java is the test file having test case for recording Test cases.
 * Author      : Tushar Chawat
 * Date        : 02/06/2021
 */

package com.bridgelabz.selenium;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    WebDriver driver;
    ATUTestRecorder recorder;

    @BeforeMethod
    public void setUp() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        recorder = new ATUTestRecorder("D:\\Recording","Script_Video_" + dateFormat.format(date), false);
        recorder.start();
    }

    @Test
    public void testApp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
        driver.findElement(By.id("username")).sendKeys("tushar1chawat@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Wardha123");
        driver.findElement(By.xpath("//*[@id='organic-div']/form/div[3]/button")).click();
        Thread.sleep(5000);
        System.out.println("Login successful");
    }

    @AfterMethod
    public void tearDown() throws ATUTestRecorderException {
        driver.quit();
        recorder.stop();
    }
}
