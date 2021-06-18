/**
 * Description : Date_Format.java is the test file having test case for Date and Time Picker.
 * Author      : Tushar Chawat
 * Date        : 02/06/2021
 */

package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Date_Format {
    @Test

    public void dateTimePicker(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/test/");

        WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

        dateBox.sendKeys("09022013");

        dateBox.sendKeys(Keys.TAB);

        dateBox.sendKeys("0245PM");

    }
}
