package com.expedia.tests;

import com.expedia.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.DateProducer;
import utilities.ExcelUtility;
import utilities.Reporter;
import utilities.Screenshots;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 7/5/16.
 */
public class HomePageTest1 {

    private WebDriver driver;
    private HomePage page;
    private ExtentReports reports;
    private ExtentTest extentTest;
    private String [] dates;

    @BeforeTest
    public void setUp() throws Exception {
        ExcelUtility.setExcelFile("//Users//Admin//Desktop//College//testMusicStore//resources//DataProvider.xlsx", "Лист1");
        reports = new ExtentReports("//Users//Admin//Desktop//College//testMusicStore//reports//LEDtoBCNtest.html");
        extentTest = reports.startTest("LED to BCN round trip flight");
        driver = new FirefoxDriver();
        extentTest.log(LogStatus.INFO, "Browser opened");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void goToHomePage(){
        driver.manage().deleteAllCookies();
        driver.get(HomePage.URL);
        extentTest.log(LogStatus.INFO, "Directed to " + HomePage.URL);
        page = new HomePage(driver, extentTest);
        dates = DateProducer.getDates(2);
    }

    /*
    * Test Case: test1
    * Feature: Flight Search
    * Scenario: Successful search for flight from LED to BCN
    * Given User is on Home page
    * Background: Click flight tab
    *   When User inputs "Saint-Petersburg, Russia" in departing field
    *   And User inputs "Barcelona, Spain" in arriving field
    *   And sets departure date to tonight and returning date to 2 day after
    *   And Click Submit Button
    *   Then User get redirected to LED to BRC page
    *
    *  DataProvider user for DDT
    * */

    @DataProvider(name = "cityData")
    public Object[][] dataProvider() {
        return ExcelUtility.getTestData("Flight_Test");
    }
    @Test(dataProvider = "cityData")
    public void testCase1(String originCity, String arrivalCity) throws InterruptedException {
        page.flightTabClick();
        page.flightOriginInputSendKeys(originCity);
        page.flightDestinationInputSendKeys(arrivalCity);
        page.depDateInputSendKeys(dates[0]);
        page.retDateInputSendKeys(dates[1]);
        page.searchButtonClick();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle().substring(11), "Flights | Expedia");
    }

    @Test(dependsOnMethods = {"testCase1"})
    public void testCase2() throws InterruptedException {
        page.flightOriginInputSendKeys("LED");
        page.flightDestinationInputSendKeys("MOW");
        page.depDateInputSendKeys(dates[0]);
        page.retDateInputSendKeys(dates[1]);
        page.adultsSelectSendKeys("2");
        page.searchButtonClick();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle().substring(11), "Flights | Expedia");
    }


    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        Reporter.report(testResult, driver, extentTest);
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}
