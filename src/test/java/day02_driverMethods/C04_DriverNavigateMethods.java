package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //sayfa başında bu komut ile büyütelim

        driver.navigate().to("https://www.amazon.com");
        // get ile ayni islevi yapar
        // there is no difference from navigate() method if we are using it at the first line

        Thread.sleep(3000);
        driver.navigate().to("https://www.wisequarter.com"); //oradan başka bir sayfaya gidebiliriz

        Thread.sleep(3000);
        // yeniden amazon'a donelim
        driver.navigate().back();

        Thread.sleep(3000);
        // tekrar wisequarter.com'a gitmek istersek
        driver.navigate().forward();

        Thread.sleep(3000);
        driver.quit();
    }
}

