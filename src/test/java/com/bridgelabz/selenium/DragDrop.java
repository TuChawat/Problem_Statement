/**
 * Description : DragDrop.java is the test file having test case for Dragging and dropping the items.
 * Author      : Tushar Chawat
 * Date        : 04/06/2021
 */

package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDrop {
    WebDriver driver;

    @Test
    public void DragnDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));

        WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

        Actions act=new Actions(driver);

        act.dragAndDrop(From, To).build().perform();
    }
}
