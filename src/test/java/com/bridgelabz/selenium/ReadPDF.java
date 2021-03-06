/**
 * Description : ReadPDF.java is the test file having test case for Reading PDF file.
 * Author      : Tushar Chawat
 * Date        : 05/06/2021
 */

package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import java.net.URL;

public class ReadPDF {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.pdf995.com/samples/pdf.pdf");
        driver.manage().window().maximize();
        String Currentlink=driver.getCurrentUrl();
        URL url=new URL(Currentlink);
        InputStream is=url.openStream();
        BufferedInputStream fp=new BufferedInputStream(is);
        PDDocument document=null;
        document=PDDocument.load(fp);
        String pdfContent= new PDFTextStripper().getText(document);
        System.out.println(pdfContent);
        driver.quit();
    }
}
