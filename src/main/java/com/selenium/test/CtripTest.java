package com.selenium.test;

import org.apache.http.client.utils.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CtripTest {
    static WebDriver driver;
    static String baseUrl = "http://english.ctrip.com";
//STATUS COMPLETE


    public static void main(String[] args) {
        //get today date
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("YYYY-MM-dd");
        String dateToday = dateFormat.format(today);


        File pathToBinary = new File("C:\\Users\\ygong1\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);

        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#hotelsCity")));


        WebElement hotelNameTextField = driver.findElement(By.cssSelector("#hotelsCity"));
        hotelNameTextField.click();
        WebElement beijingLink = driver.findElement(By.linkText("Beijing"));
        beijingLink.click();
        WebElement checkInTextField = driver.findElement(By.cssSelector("#txtCheckInDisplay"));
        checkInTextField.click();


        String todayLinkSelector = "div[data-id='" + dateToday + "']";
        WebElement todayLink = driver.findElement(By.cssSelector(todayLinkSelector));

        WebElement previousMonth = driver.findElement(By.cssSelector("#prev-month"));
        WebElement nextMonth = driver.findElement(By.cssSelector("#next-month"));

        todayLink.click();

        List<WebElement> starCheckBoxes = driver.findElements(By.cssSelector("label[class='ui_checkbox']"));
        for (WebElement element:starCheckBoxes
             ) {
            if(element.findElement(By.cssSelector("label[value='2']")).isDisplayed()) {
                element.findElement(By.cssSelector("label[value='2']")).click();

            }
        }





        WebElement searchHotelsButton = driver.findElement(By.cssSelector("#homesearch-btn"));
        searchHotelsButton.click();


    }


}
