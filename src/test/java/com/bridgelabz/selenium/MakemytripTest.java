/**
 * Description : MakemytripTest.java is the test file having test case for Make My Trip.
 * Author      : Tushar Chawat
 * Date        : 04/06/2021
 */

package com.bridgelabz.selenium;

import com.bridgelabz.selenium.Base.Base;
import com.bridgelabz.selenium.Page.Create_Makemytrip;
import com.bridgelabz.selenium.Page.Radio_Button;
import com.bridgelabz.selenium.Page.Round_Trip;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.bridgelabz.selenium.utilities.Screenshot.capture;

public class MakemytripTest extends Base {
    public Create_Makemytrip Create;
    public Round_Trip Trip;
    public Radio_Button Radio;

    @Test(priority = 0)
    public void Login_Makemytrip() throws InterruptedException, IOException {
        Create = new Create_Makemytrip(driver);
        Create.loggedin();
        String Name = driver.findElement(By.xpath("//p[text() = 'Hey Traveller']")).getText();
        Assert.assertEquals("Hey Traveller", Name);
        if (Name.equals("My Zoopla")){
            test.log(LogStatus.PASS, "Navigated to My account");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

    @Test(priority = 1)
    public void Round_Trip() throws InterruptedException, IOException {
        Trip = new Round_Trip(driver);
        Trip.round();
        String Search = driver.findElement(By.xpath("//div[text() = 'Round Trip']")).getText();
        Assert.assertEquals("Round Trip", Search);
        if (Search.equals("My Zoopla")){
            test.log(LogStatus.PASS, "Navigated to My account");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

    @Test(priority = 2)
    public void printDepartureFlights() {
        java.util.List<WebElement> products = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]"));

        for (WebElement product : products) {
            System.out.println("The Departure Flights From Mumbai are");
            System.out.println(product.getText());
        }
    }

    @Test(priority = 3)
    public void printReturnFlights() {
        java.util.List<WebElement> products = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]"));

        for (WebElement product : products) {
            System.out.println("The Return Flights from Banglore are");
            System.out.println(product.getText());
        }
    }

    @Test(priority = 4)
    public void printNonStopDepartureFlights() {
        driver.findElement(By.xpath("//span[text() = 'Non Stop']")).click();
        java.util.List<WebElement> products = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]"));

        for (WebElement product : products) {
            System.out.println("The Departure Flights From Mumbai with no stops are");
            System.out.println(product.getText());
        }
    }

    @Test(priority = 5)
    public void printNonStopReturnFlights() {
        java.util.List<WebElement> products = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]"));

        for (WebElement product : products) {
            System.out.println("The Return Flights from Banglore with no stops are");
            System.out.println(product.getText());
        }
    }

    @Test(priority = 6)
    public void radioButton() {
        Radio = new Radio_Button(driver);
        Radio.radioButton();
    }
}
