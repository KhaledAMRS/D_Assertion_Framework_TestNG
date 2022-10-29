package withTestNG;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class C01_Annotations {

    //The most common used annotations are @BeforeMethod, @AfterMethod, @Test, @BeforeTest, @AfterTest

    // Run before each test case
    @BeforeMethod
    public void OpenBrowser()
    {
        System.out.println("Before Method: open browser");
    }



    @Test(priority = 1)
    public void validLogin()
    {

        System.out.println("Test Case 1: login with valid username and password");
    }

    @Test(priority = 2)
    public void invalidUsername()
    {
        System.out.println("Test Case 2: login with invalid username");
    }

    @Test(priority = 3)
    public void invalidPassword()
    {
        System.out.println("Test Case 3: login with valid username and invalid password");
    }



    // Run after each test case
    @AfterMethod
    public void quitDriver()
    {
        System.out.println("After Method: quit the driver");
    }

}