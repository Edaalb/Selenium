package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com");

        //System.out.println(driver.getPageSource());
        //amazon sayfasına kendimiz gidip sap tık, Inspect diyerek html kodlarını görürüz
        //view page source ile yazdırdığımız bu kodları görebiliriz


        // test that if page source code has "MEOW" keyword
        // pageSource'un MEOW icerdigini test edin

        String pageSource= driver.getPageSource();

        String expectedKelime="MEOW";

        if (pageSource.contains(expectedKelime)){
            System.out.println("Test PASSED");
        } else{
            System.out.println("Test FAILED");

        }
        driver.close();
    }
}
