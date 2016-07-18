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
import utilities.Reporter;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 7/18/16.
 */
public class FlightPageAdults {

    private WebDriver driver;
    private HomePage page;
    private ExtentReports reports;
    private ExtentTest test;

    @BeforeClass
    public void setDriver(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        reports = new ExtentReports("//Users//Admin//Desktop//College//testMusicStore//reports//LEDtoSFOtest5Adults.html");
        test = reports.startTest("FlightPageAdults5");
    }

    @BeforeMethod
    public void setUp() throws Exception {
        //driver.manage().deleteAllCookies();
        driver.get(HomePage.URL);
        page = new HomePage(driver, test);
    }

    @Test
    public void testName() throws Exception {
        String [] dates = DateProducer.getDates(5);
        page.flightTabClick();
        page.flightOriginInputSendKeys("LED");
        page.flightDestinationInputSendKeys("SFO");
        page.depDateInputSendKeys(dates[0]);
        page.retDateInputSendKeys(dates[1]);
        page.adultsSelectSendKeys("5");
        page.searchButtonClick();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle().substring(11), "Flights | Expedia");    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws Exception {
        Reporter.report(testResult, driver, test);
        reports.endTest(test);
        reports.flush();
    }

    @AfterClass
    public void close(){
        driver.close();
    }

}
