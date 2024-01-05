package pl.testy;

import org.testng.annotations.*;

public class BaseTest {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am before suite");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am after suite");
    }
    @BeforeClass
    public void afterClass(){
        System.out.println("I am after class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am after test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
}
