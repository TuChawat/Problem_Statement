/**
 * Description : MakemytripTest.java is the test file having test case for Make My Trip.
 * Author      : Tushar Chawat
 * Date        : 04/06/2021
 */

package com.bridgelabz.selenium.Page;

import com.bridgelabz.selenium.Base.Base;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Create_Makemytrip {
    @FindBy(xpath = "//span[@class = 'chNavIcon appendBottom2 chSprite chFlights active']")
    WebElement Flight;

    @FindBy(xpath = "//p[text() = 'Login or Create Account']")
    WebElement Account;

    @FindBy(xpath = "//label[text() = 'Login with Phone/Email']")
    WebElement Login;

    @FindBy(xpath = "//input[@placeholder = 'Enter email or mobile number']")
    WebElement Number;

    @FindBy(xpath = "//i[@class = 'drop-down down']")
    WebElement Drop;

    @FindBy(xpath = "//span[text() = 'US']")
    WebElement UnSt;

    @FindBy(xpath = "//span[text() = 'Continue']")
    WebElement Continue;

    @FindBy(xpath = "//input[@placeholder = 'Enter OTP']")
    WebElement EnterOTP;

    @FindBy(xpath = "//span[text() = 'Login']")
    WebElement Verify;

    private String Account_SID = "ACeacd7b57e908e0c417409fbb0c7a7eab";
    private String Auth_Token = "de45dc77e259b9da2c3ba1659ac780f9";

    public Create_Makemytrip(WebDriver driver) {
        PageFactory.initElements(Base.driver, this);
    }

    public Round_Trip loggedin() throws InterruptedException {
//        Flight.click();
//        Account.click();
        Login.click();
        Number.clear();
        Number.sendKeys("4158861586");
        Drop.click();
        UnSt.click();
        Continue.click();
        Twilio.init(Account_SID,Auth_Token);
        Thread.sleep(1000);
        String sms = getMessage();
        System.out.println(sms);

        String otp = sms.replaceAll("[^-?0-9]+", "");
        System.out.println(otp);
        EnterOTP.sendKeys(otp);
        Verify.click();
        Thread.sleep(1000);
        return new Round_Trip();
    }

    public String getMessage() {
        return getMessages()
                .filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(m -> m.getTo().equals("+14158861586"))
                .map(Message::getBody)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private Stream<Message> getMessages(){
        ResourceSet<Message> message = Message.reader(Account_SID).read();
        return StreamSupport.stream(message.spliterator(), false);
    }
}

