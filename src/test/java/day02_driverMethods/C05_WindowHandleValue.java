package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_WindowHandleValue {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        // every tap in a browser has a different value,
        // we use these values to jump between taps
        System.out.println(driver.getWindowHandle()); // CDwindow-C98BA9BE4C20B7A6CF86FE120B09A887

        driver= new ChromeDriver(); //bir test içinde yeni bir sayfa açabiliriz
        driver.manage().window().maximize();

        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());

        Thread.sleep(3000);
        driver.quit();
    }
}
