package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Questions {
    public static void main(String[] args) {

        //1- Create a test class and set the relevant settings
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- Go to https://www.automationexercise.com/
        driver.get("https://www.automationexercise.com/");

        //3- Test that there are 147 links on the page.

        List linklist = driver.findElements(By.xpath("//a"));
        //System.out.println(linklist.size());
        if (linklist.size() == 147) {
            System.out.println("Link number test PASSED");
        } else {
            System.out.println("Link number test FAILED");
        }

        //4- Click on Products link
        WebElement productsLink = driver.findElement(By.xpath("//*[text()=' Products']"));
        productsLink.click();

        //5- Test that the special offer text appears
        WebElement spacialSalePicture = driver.findElement(By.xpath("//*[@id='sale_image']"));

        if (spacialSalePicture.isDisplayed()) {
            System.out.println("Special Sale test PASSED");
        } else {
            System.out.println("Special Sale test FAILED");
        }

        //6- Close the page

        driver.close();
    }
}
