package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods {
    public static void main(String[] args) throws InterruptedException {

        // Biz browser'lari olusturdugumuz driver sayesinde otomate edebiliyoruz
        // Bunun icin her testin basinda mutlaka driver objesi olusturacagiz

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com");

        // --------------------Example---------------------
        // test If expected URL "https://www.amazon.com/" and actual URL are same
        // acilan sayfanin basliginin amazon icerdigini test edin

        String expectedWord= "amazon";
        String actualResult= driver.getTitle(); //driver kullanarak gittiğimiz sayfadan title alır

        // test if the title contains "amazon" keyword
        //actual result'ın bu kelimeyi içerdiğini kontrol ederiz

        if (actualResult.contains(expectedWord)){
            System.out.println("Title tests PASSED");
        }else {
            System.out.println("Title test FAILED");

            //neden içermediğini yazdırmak için bu komutu kullanırız
            System.out.println(driver.getTitle());
            //küçük harfle amazon yazdığımız için hata verir. Doğru title bize yazdırır
        }

        // test If expected URL "https://www.amazon.com/" and actual URL are same
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Url test PASSED");
        } else {
            System.out.println("Url test FAILED");
            System.out.println(driver.getCurrentUrl());
        }

        Thread.sleep(5000); //kodlar çok hızlı olabileceği için kullanırırz
                                 //siteye gider 5 sn bekler ve kapatır
        driver.close(); //açtığımız driver'ı kapatır
    }
}
