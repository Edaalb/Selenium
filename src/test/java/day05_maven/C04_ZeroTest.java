package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ZeroTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Go to http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com");

        //2. Click the Signin button
        driver.findElement(By.id("signin_button")).click();

        //3. Write “username” in the Login field
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Write “password” in the password field
        driver.findElement(By.id("user_password")).sendKeys("password");


        //5. Click the Sign in button
        driver.findElement(By.name("submit")).click(); // at first it did not work// if you want to check with xpath wheater
        // it is unique or not, you should use "*" for tag
        driver.navigate().back();

        //6. Go to the Pay Bills page
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();


        //7. Type any amount you want to deposit in the amount
        driver.findElement(By.id("sp_amount")).sendKeys("200");


        //8. Write “2020-09-10” on the 8th date part
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");


        //9. Click on the Pay button
        driver.findElement(By.id("pay_saved_payees")).click();

        //10. “The payment was successfully submitted.” test that  it appears

        WebElement message = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if (message.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        driver.close();

    }
}
