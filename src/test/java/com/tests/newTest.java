package com.tests;

/**
 * Created by admin on 5/22/16.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class newTest {
    WebDriver driver;
    //Welcome Page
    WebElement linkToProductList;
    //List Products Page
    WebElement editLink;
    WebElement deleteLink;
    WebElement addButton;
    //Login Page
    WebElement userInputField;
    WebElement passwordInputField;
    WebElement loginButton;
    WebElement cancelButton;

    private static final String URL = "https://www.expedia.com/";//"http://localhost:8080/JSF-JPA-MusicStore/";
    private static final String WELCOME_TITLE = "Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares";
    private static final String WELCOME_LINK_TEXT = "View Products";
    private static final String LIST_TITLE = "List of Products";
    private static final String LIST_EDIT_LINK_TEXT = "Edit";
    private static final String LIST_DELETE_LINK_TEXT = "Delete";
    private static final String LIST_ADD_BUTTON_TEXT = "New Product";
    private static final String LOGIN_TITLE= "Login Page";
    private static final String EDIT_TITLE = "New Product";

    @BeforeTest
    public void setupDriver(){

        driver = new FirefoxDriver();

        //This adds implicit timeouts to the driver (instead of clickAndWait())
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(groups = "welcome")
    public void testTitle(){
        driver.get(URL);
        Assert.assertEquals(driver.getTitle(), WELCOME_TITLE);
    }
//
//    @Test(groups="welcome", dependsOnMethods = "testTitle")
//    public void testLink(){
//        linkToProductList = driver.findElement(By.xpath("//*[@id=\"j_idt9\"]/a"));
//        Assert.assertEquals(linkToProductList.getText(), WELCOME_LINK_TEXT);
//    }
//
//    @Test(groups="list", dependsOnGroups = {"welcome"})
//    public void testListPageTitle(){
//        linkToProductList.click();
//        Assert.assertEquals(driver.getTitle(), LIST_TITLE);
//    }
//
//    @Test(groups = "list", dependsOnMethods = "testListPageTitle")
//    public void testLinkEditText(){
//        editLink = driver.findElement(By.xpath("//*[@id=\"j_idt11\"]/table/tbody/tr[1]/td[4]/a"));
//        Assert.assertEquals(editLink.getText(), LIST_EDIT_LINK_TEXT);
//    }
//
//    @Test(groups = "list", dependsOnMethods = "testListPageTitle")
//    public void testLinkDeleteText(){
//        deleteLink = driver.findElement(By.xpath("//*[@id=\"j_idt11\"]/table/tbody/tr[1]/td[5]/a"));
//        Assert.assertEquals(deleteLink.getText(), LIST_DELETE_LINK_TEXT);
//    }
//
//    @Test(groups = "list", dependsOnMethods = "testListPageTitle")
//    public void testButtonAddText(){
//        addButton = driver.findElement(By.xpath("//*[@id=\"j_idt11\"]/input[2]"));
//        Assert.assertEquals(addButton.getAttribute("value"), LIST_ADD_BUTTON_TEXT);
//    }
//
//    @Test(groups = "login", dependsOnGroups = "list")
//    public void testLoginTitleAfterClickOnEdit(){
//        editLink.click();
//        String title = driver.getTitle();
//        cancelButton = driver.findElement(By.xpath("//*[@id=\"j_idt11:j_idt19\"]/span"));
//        cancelButton.click();
//        Assert.assertEquals(title, LOGIN_TITLE);
//    }
//
//
//    @Test(groups = "login", dependsOnMethods = "testLoginTitleAfterClickOnEdit")
//    public void testLoginTitleAfterClickOnDelete(){
//        deleteLink = driver.findElement(By.xpath("//*[@id=\"j_idt11\"]/table/tbody/tr[1]/td[5]/a"));
//        deleteLink.click();
//        String title = driver.getTitle();
//        cancelButton = driver.findElement(By.xpath("//*[@id=\"j_idt11:j_idt19\"]/span"));
//        cancelButton.click();
//        Assert.assertEquals(title, LOGIN_TITLE);
//    }
//
//    @Test(groups = "login", dependsOnMethods = "testLoginTitleAfterClickOnDelete")
//    public void testLoginTitleAfterClickOnNewProduct(){
//        addButton = driver.findElement(By.xpath("//*[@id=\"j_idt11\"]/input[2]"));
//        addButton.click();
//        String title = driver.getTitle();
//        cancelButton = driver.findElement(By.xpath("//*[@id=\"j_idt11:j_idt19\"]/span"));
//        cancelButton.click();
//        Assert.assertEquals(title, LOGIN_TITLE);
//    }


    @AfterTest
    public void tearDown(){
        //Shutdown the browser
        driver.quit();
    }
}
