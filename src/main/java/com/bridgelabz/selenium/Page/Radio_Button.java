package com.bridgelabz.selenium.Page;

import com.bridgelabz.selenium.Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Radio_Button {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/label[1]")
    WebElement Departure;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/label[1]/div/div[2]")
    WebElement Return;

    public Radio_Button(WebDriver driver) {
        PageFactory.initElements(Base.driver, this);
    }

    public void radioButton() {
        Departure.click();
        Return.click();
    }
}
