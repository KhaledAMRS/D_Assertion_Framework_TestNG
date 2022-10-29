package withTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C03_loginTestCases {
    // Declaration with null value
    WebDriver driver = null;

    @BeforeMethod
    public void OpenBrowser()
    {
     //1- Define setProperty
 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");

 //2- set ChromeDriver Constructor
driver = new ChromeDriver();

//3- Configuration
    //3.1- Maximize Browser
    driver.manage().window().maximize();

    //3.2- Set implicit wait
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //4- navigate to url
    driver.navigate().to("https://the-internet.herokuapp.com/");

    driver.findElement(By.linkText("Form Authentication")).click();

	

    }

    @Test(priority = 1)
    public void validlogin()
    {

  driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("tomsmith");
  driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("SuperSecretPassword!");
  driver.findElement(By.xpath("//button[@class=\"radius\"][@type=\"submit\"]")).click();

  //1- user directed to secure url    https://the-internet.herokuapp.com/secure
  String actualUrl = driver.getCurrentUrl();
  System.out.println(actualUrl);
  Assert.assertEquals(actualUrl,"https://the-internet.herokuapp.com/secure");


  //2- success message contain  "You logged into a secure area!"
  String actualMsg =  driver.findElement(By.id("flash")).getText();
  System.out.println(actualMsg);
  System.out.println(actualMsg.contains("You logged into a secure area"));
  Assert.assertTrue(actualMsg.contains("You logged into a secure area"));


  //3.1- success message background is green
String actualBackgroundColorRGBA = driver.findElement(By.id("flash")).getCssValue("background-color");
Assert.assertTrue(actualBackgroundColorRGBA.contains("rgba(93, 164, 35, 1)"));

//3.2- you could change format from rgba to hex  (both ways are right)
String actualBackgroundColorHex = Color.fromString(actualBackgroundColorRGBA).asHex();
Assert.assertTrue(actualBackgroundColorHex.contains("#5da423"));

  //4- logout button is visible (isDisplayed)
boolean status = driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed();
Assert.assertTrue(status);
    //Note: this is to verify that the element is visible (eye could see it on UI). There's another action to verify the element is exist on DOM Page, we will take it later

    }

    @Test(priority = 2)
    public void invalidLogin()
    {
    //task
        //1- user still on login url    https://the-internet.herokuapp.com/login

        //2- Error message contain  "Your username is invalid!"

        //3.1- Error message background is red

        //3.2- change format from rgba to hex

        //4- login button is displayed


    }

    @AfterMethod
    public void quitDriver()
    {
        driver.quit();
    }
}
