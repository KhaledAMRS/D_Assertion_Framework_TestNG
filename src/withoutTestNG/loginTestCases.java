package withoutTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.util.concurrent.TimeUnit;

public class loginTestCases {

    public static void main(String[] args) throws InterruptedException {
    // 1- Bridge between the code and the browser
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");

    // 2- create new object from chrome driver
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        String url = "http://the-internet.herokuapp.com/login";
        driver.navigate().to(url);

        // Test Case 1: valid login
 System.out.println("Test Case 1 valid login*******************");
    driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("tomsmith");
   driver.findElement(By.xpath("//input[contains(@id,\"passwor\")]")).sendKeys("SuperSecretPassword!");
   driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

   Thread.sleep(2000);
   // compare expected result with actual result
    // 1- logout button should be displayed (visible)
    boolean logoutstatus = driver.findElement(By.partialLinkText("ogout")).isDisplayed();
        System.out.println("logoutstatus..  "+logoutstatus);

    // 2- success message is displayed "You logged into a secure area!"
    String successMsg = driver.findElement(By.id("flash")).getText();
    boolean successTestStatus = successMsg.contains("You logged into a secure");
        System.out.println("successMsg..  "+successMsg);
        System.out.println("successTestStatus..  "+successTestStatus);

    // 3- success message background is green
   String backgroundColor =  driver.findElement(By.id("flash")).getCssValue("background-color");
   System.out.println("rgba color..  "+backgroundColor);
   System.out.println("rgb color..  "+Color.fromString(backgroundColor).asRgb());
   System.out.println("hex color..  "+Color.fromString(backgroundColor).asHex());

    // 4- url changed to /secure
    String currentUrl = driver.getCurrentUrl();
    boolean urlStatus  = currentUrl.contains("/secure");
        System.out.println("currentUrl..  "+currentUrl);
        System.out.println("urlStatus..  "+urlStatus);

   // Reset url
   driver.findElement(By.partialLinkText("ogout")).click();

  // Test Case 2: invalid username
    System.out.println("Test Case 2 invalid username*******************");
    driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys("wrongusername");
    driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("wrongpassword");
   driver.findElement(By.className("fa-sign-in")).click();

        // compare expected result with actual result

        // 1- error message is displayed "Your username is invalid!"
        String errorMsg = driver.findElement(By.id("flash")).getText();
        boolean errorTestStatus = errorMsg.contains("Your username is invalid!");
        System.out.println("errorMsg..  "+errorMsg);
        System.out.println("errorTestStatus..  "+errorTestStatus);

        // 2- error message background is red
        backgroundColor =  driver.findElement(By.id("flash")).getCssValue("background-color");
        System.out.println("rgba color..  "+backgroundColor);
        System.out.println("rgb color..  "+Color.fromString(backgroundColor).asRgb());
        System.out.println("hex color..  "+Color.fromString(backgroundColor).asHex());

        // 3- url doesn't changed  /login
        currentUrl = driver.getCurrentUrl();
        urlStatus  = currentUrl.contains("/login");
        System.out.println("currentUrl..  "+currentUrl);
        System.out.println("urlStatus..  "+urlStatus);

        driver.navigate().to("http://the-internet.herokuapp.com/login");

        // Test Case 3: invalid password
        System.out.println("Test Case 3 invalid password*******************");
        driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("wrongpassword");
        driver.findElement(By.className("fa-sign-in")).click();

        // compare expected result with actual result

        // 1- error message is displayed "Your password is invalid!"
        errorMsg = driver.findElement(By.id("flash")).getText();
        errorTestStatus = errorMsg.contains("Your password is invalid!");
        System.out.println("errorMsg..  "+errorMsg);
        System.out.println("errorTestStatus..  "+errorTestStatus);

        // 2- error message background is red
        backgroundColor =  driver.findElement(By.id("flash")).getCssValue("background-color");
        System.out.println("rgba color..  "+backgroundColor);
        System.out.println("rgb color..  "+Color.fromString(backgroundColor).asRgb());
        System.out.println("hex color..  "+Color.fromString(backgroundColor).asHex());

        // 3- url doesn't changed  /login
        currentUrl = driver.getCurrentUrl();
        urlStatus  = currentUrl.contains("/login");
        System.out.println("currentUrl..  "+currentUrl);
        System.out.println("urlStatus..  "+urlStatus);


        Thread.sleep(2000);

        driver.quit();
    }

}
