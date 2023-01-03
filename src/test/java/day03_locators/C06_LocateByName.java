package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C06_LocateByName {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement amazonTextSearchBox  = driver.findElement(By.name("field-keywords"));

        amazonTextSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        //List<WebElement> listOfSameClassName =driver.findElements(By.className("a-section aok-relative s-image-square-aspect"));
        // When you try to find a WebElement by using className locater, value should not have any space character
        List<WebElement> listOfSameClassName =driver.findElements(By.className("a-price-whole"));
        // we saved all webelements sharing same class name

        // we chould not be able to print them in for each loop, because each of them is a WebElement Object
        for (WebElement each:listOfSameClassName
        ) {
            System.out.print(each+" ");
        }

        System.out.println();
        // we can print texts of these each object
        for (WebElement each:listOfSameClassName
        ) {
            System.out.print(each.getText()+" ");
        }

        List<Integer> listOfStringNumbers= new ArrayList<>();

        for (WebElement each:listOfSameClassName
        ) {

            listOfStringNumbers.add(Integer.parseInt(each.getText()));

        }
        System.out.println(listOfStringNumbers);

        Collections.sort(listOfStringNumbers);
        System.out.println(listOfStringNumbers);
        System.out.println();

        // the highest value :
        System.out.println(listOfStringNumbers.get(listOfStringNumbers.size() - 1));

        driver.close();
    }
}
