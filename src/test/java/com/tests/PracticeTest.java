package com.tests;

import org.testng.annotations.*;

/**
 * Created by admin on 7/15/16.
 */
public class PracticeTest {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Groups");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @Test(dependsOnGroups = {"g"}, groups = {"g2"})
    public void test1(){
        System.out.println("Test 1");
    }
    @Test(groups = {"g"})
    public void test2(){
        System.out.println("Test 2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}
