/**
 * Description : MakemytripTest.java is the test file having test case for Make My Trip.
 * Author      : Tushar Chawat
 * Date        : 04/06/2021
 */

package com.bridgelabz.selenium.Page;

import com.bridgelabz.selenium.Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Round_Trip {
    @FindBy(xpath = "//span[@class = 'chNavIcon appendBottom2 chSprite chFlights active']")
    WebElement Flight;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/ul/li[2]/span")
    WebElement Round;

    @FindBy(xpath = "//input[@id = 'fromCity']")
    WebElement From;

    @FindBy(xpath = "//p[text() = 'Mumbai, India']")
    WebElement BOM;

    @FindBy(xpath = "//input[@placeholder = 'To']")
    WebElement Input;

    @FindBy(xpath = "//p[text() = 'Bengaluru, India']")
    WebElement BLR;

    @FindBy(xpath = "//span[text() = 'DEPARTURE']")
    WebElement Departure;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[2]/div")
    WebElement Start;

    @FindBy(xpath = "//span[text() = 'RETURN']")
    WebElement Return;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[4]/div")
    WebElement End;

    @FindBy(xpath = "//a[text() = 'Search']")
    WebElement Search;

    public Round_Trip(WebDriver driver) {
        PageFactory.initElements(Base.driver, this);
    }

    public Round_Trip() {

    }

    public void round() throws InterruptedException {
        Flight.click();
        Round.click();
        From.sendKeys("Mumbai");
        Thread.sleep(2000);
        BOM.click();
        Thread.sleep(2000);
        Input.sendKeys("Bangalore");
        Thread.sleep(2000);
        BLR.click();
        Thread.sleep(2000);
        Departure.click();
        Start.click();
        Return.click();
        End.click();
        Thread.sleep(2000);
        Search.click();
    }
}
