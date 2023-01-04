package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Question_GiftCard {

    public static void main(String[] args) {

        //1- create a class and set the properties
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3- Make the browser full page
        driver.manage().window().maximize();

        //4- Refresh the page
        driver.navigate().refresh();

        //5- Test if the page title contains the phrase “Spend less”
        String expectedWord = "Spend less";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedWord)){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED");
        }

        //6- Press the Gift Cards tab

        WebElement giftCardsTab = driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_2']"));
        giftCardsTab.click();

        //7- Press the Birthday button
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();

        //8- Click the first product from the Best Seller section
        driver.findElement(By.xpath("(//li[@class='a-carousel-card acswidget-carousel__card'])[18]")).click();


        //9- Select $25 from Gift card details
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();

        //10-Test the product price is $25
        WebElement priceElement = driver.findElement(By.xpath("(//span[text()='$25.00'])[1]"));

        String expectedPrice = "$25.00";
        String actualPrice = priceElement.getText();
        //System.out.println(actualPrice);  // to see de actual price, we printed it.

        if (actualPrice.equals(expectedPrice)){
            System.out.println("Price test PASSED");
        }else {
            System.out.println("Price test FAILED");
        }

        //11-Close the page
        driver.close();

    }
}
