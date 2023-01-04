package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_MavenFirstTest {

    public static void main(String[] args) {

        //ClassWork Amazon Search Test
        //
        //1- Go to https://www.amazon.com/
        //2- let's locate the search box
        //3- Let's search with "Samsung headphones"
        //4- Let's print the number of results found
        //5- Let's click the first product
        //6- Let's print all the titles on the page


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2- let's locate the search box
        WebElement amazonSeachBox = driver.findElement(By.id("twotabsearchtextbox"));

        //3- Let's search with "Samsung headphones"
        amazonSeachBox.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Let's print the number of results found
        WebElement results = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(results.getText());

        //5- Let's click the first product
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        //6- Let's print all the titles on the page
        driver.navigate().back();
        List<WebElement> leftSideTitles=driver.findElements(By.xpath("//span[@class='a-list-item']"));

        for (WebElement each:leftSideTitles
        ) {
            System.out.println(each.getText());
        }

        driver.close();
    }
}
