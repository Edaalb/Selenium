package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C04_RealiveLocators {


    //2 ) Locate Berlin with 3 different relative locators
    //3 ) Test that the Relative locators are working correctly

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1) Go to https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2 ) Locate Berlin with 3 different relative locators
        // we found the sailor webelement
        WebElement sailor = driver.findElement(By.xpath("//*[@id='pid11_thumb']"));

        WebElement boston = driver.findElement(By.xpath("//*[@id='pid6_thumb']"));

        WebElement nyc = driver.findElement(By.xpath("//*[@id='pid3_thumb']"));

        WebElement berlin = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor));

        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor).toRightOf(boston));

        WebElement berlin2 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor).toRightOf(boston).below(nyc));

        String expectedID = "pid7_thumb";
        String actualID = berlin2.getAttribute("id");

        if (actualID.equals(expectedID)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        driver.close();

    }
}
