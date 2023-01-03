package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ByLinkText {
    public static void main(String[] args) throws InterruptedException {

        // amazon anasayfaya gidin
        // Gift Cards linkini tiklayin
        // Gift Cards sayfasina gittigini test edin

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        Thread.sleep(4000);

        // WebElement giftCardLinki= driver.findElement(By.linkText("Gift Cards"));

        //bazen tüm link text'i yazmasak da locate edebiliriz
        //yalnızca link'in bir part'ını yazarak locate edebiliriz
        WebElement giftCardLink=driver.findElement(By.partialLinkText("Gift"));
        giftCardLink.click();

        // istenen sayfaya gittigini test etmek icin
        // title'in Gift Card icerdigini test edebiliriz

        String expectedWord="Gift Cards";
        String actualTitle=driver.getTitle(); //actualTitle her zaman driver'ın aldığı değerdir

        //testi yapalım
        if (actualTitle.contains(expectedWord)){
            System.out.println("Gift Cards test PASSED");
        }else {
            System.out.println("Gift Card test FAILED");
        }
        driver.close();
    }
}
