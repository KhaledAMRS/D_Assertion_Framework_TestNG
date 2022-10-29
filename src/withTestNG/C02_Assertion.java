package withTestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C02_Assertion {

    // In this class you will learn the difference between Hard & Soft Assertion


    @BeforeMethod
    public void OpenBrowser()
    {
        System.out.println("Before Method: open browser");
    }


    @Test(priority = 1)
    public void Hard_Assertion()
    {
        //Hard
        // assertion 1  background is red
        // assertion 2  error message is displayed

        Assert.assertTrue("red".contains("white"));
        Assert.assertTrue("Your username is invalid!".contains("invalid"));

        // in this case: the second assertion won't be executed because the first one is failed
        // but if the first assertion is passed then the second one will be executed normally and so on with assertion 3, 4,..
    }

    @Test(priority = 2)
    public void Soft_Assert()
    {
    //Soft
    // assertion 1  background is red
    // assertion 2  error message is displayed
    // assertion 3  login url will not be changed
    //assertAll     1 pass  2 pass    3 failed

        SoftAssert soft = new SoftAssert();
        soft.assertTrue("red".contains("white"));
        soft.assertTrue("Your username is invalid!".contains("wrong"));
        soft.assertTrue("http://the-internet.herokuapp.com/login".contains("/login"));
        soft.assertAll();

        // in this case: the third assertion will be executed however the first and second assertion is failed
        // It's very important to user assertAll(), without using it, the assertion result will not be validated and the test case will be passed however first and second assertions are failed

    }


    @AfterMethod
    public void quitDriver()
    {
        System.out.println("After Method: quit the driver");
    }

}