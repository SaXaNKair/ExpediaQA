package com.expedia;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by admin on 7/5/16.
 */
public class HomePage {
    WebDriver driver;
    public static final String URL = "https://www.expedia.com";
    private ExtentTest extentTest;

    public HomePage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        extentTest = test;

//        flightHotelTab = driver.findElement(By.xpath("//label[@id='package-fh-label']"));
//        flightHotelCarTab = driver.findElement(By.xpath("//label[@id='package-fhc-label']"));
//        flightCarTab = driver.findElement(By.xpath("//label[@id='package-fc-label']"));
//        hotelCarTab = driver.findElement(By.xpath("//label[@id='package-hc-label']"));
    }

    //Navigation Bar
    private WebElement flightTab;
    private WebElement hotelTab;
    private WebElement bundleDealsTab;

    //Bundle Deals Bar
    private WebElement flightHotelTab;
    private WebElement flightHotelCarTab;
    private WebElement flightCarTab;
    private WebElement hotelCarTab;

    //Fight Form Fields
    private WebElement flightOriginInput;
    private WebElement flightDestinationInput;
    private WebElement depDateInput;
    private WebElement retDateInput;
    private WebElement adultsSelect;
    private WebElement childrenSelect;

    //Search Button
    private WebElement searchButton;

    public void flightTabClick(){
       // if(flightTab == null)
            flightTab = driver.findElement(By.xpath("//a[@id='tab-flight-tab']"));
        flightTab.click();
        extentTest.log(LogStatus.INFO, "Flight Tab clicked");
    }

    public void hotelTabClick(){
        if (hotelTab == null)
            hotelTab = driver.findElement(By.xpath("//a[@id='tab-hotel-tab']"));
        hotelTab.click();
    }

    public void bundleDealsTabClick(){
        if (bundleDealsTab == null)
            bundleDealsTab = driver.findElement(By.xpath("//a[@id='tab-package-tab']"));
        bundleDealsTab.click();
    }

    public void flightOriginInputSendKeys(String origin){
        if (flightOriginInput == null)
            flightOriginInput = driver.findElement(By.xpath("//input[@id='flight-origin']"));
        flightOriginInput.clear();
        flightOriginInput.sendKeys(origin);
        extentTest.log(LogStatus.INFO, "Origin city set to " + origin);
    }

    public void flightDestinationInputSendKeys(String arrival){
        if (flightDestinationInput == null)
            flightDestinationInput = driver.findElement(By.xpath("//input[@id='flight-destination']"));
        flightDestinationInput.clear();
        flightDestinationInput.sendKeys(arrival);
        extentTest.log(LogStatus.INFO, "Arrival city set to " + arrival);
    }

    public void depDateInputSendKeys(String date){
        if (depDateInput == null)
            depDateInput = driver.findElement(By.xpath("//input[@id='flight-departing']"));
        depDateInput.clear();
        depDateInput.sendKeys(date);
        extentTest.log(LogStatus.INFO, "Origin date set to " + date);
    }

    public void retDateInputSendKeys(String date){
        if (retDateInput == null)
            retDateInput = driver.findElement(By.xpath("//input[@id='flight-returning']"));
        retDateInput.clear();
        retDateInput.sendKeys(date);
        extentTest.log(LogStatus.INFO, "Return date set to " + date);
    }

    public void adultsSelectSendKeys(String number){
        if (adultsSelect == null)
            adultsSelect = driver.findElement(By.xpath("//select[@id='flight-adults']"));
        adultsSelect.sendKeys(number);
        extentTest.log(LogStatus.INFO, "Number of adult passengers set to " + number);
    }

    public void childrenSelectSendKeys(String number){
        if (childrenSelect == null)
            childrenSelect = driver.findElement(By.xpath("//input[@id='flight-children']"));
        childrenSelect.sendKeys(number);
        extentTest.log(LogStatus.INFO, "Number of children set to " + number);
    }

    public void searchButtonClick(){
        if(searchButton == null)
            searchButton = driver.findElement(By.xpath("//button[@id='search-button']"));
        searchButton.click();
        extentTest.log(LogStatus.INFO, "Search button clicked");
    }
}
