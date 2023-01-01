package day01_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driver_get {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        //for Windows we need to use .exe

        // The driver we wish to use in our project
        WebDriver driver = new ChromeDriver();

        // we have created driver object
        driver.get("https://www.amazon.com");

        /*
        >We have installed Selenium jar files nad chrome driver to our project
        >Selenium jar dosyalarını ve chromedriver driver'ını manuel olarak sisteme tanıttık

       >If I want to use different browser I need to download their drivers from the website and
        show them to the project( exp: line 10)
        >Eğer firefox veya safari ile çalışmamız gerekirse, onların driver'larını indirerek
        manuel olarak 10. satırda o driver'ları tanımlamalıyız.

       >Line 14: we have created an object from ChromeDriver() constructor.
        Oluşturduğumuz bu object'i kullanmasak bile bu satırdan dolayı boş bir browser açılır

       >line 17 : we may delete www part but we can not delete https:// part
       >driver.get(url) driver'ı yazdığımız url'e götürür.
                                                                                             */
    }
}
