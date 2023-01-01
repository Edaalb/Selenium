package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverManageMethods {
    public static void main(String[] args) {

        // system will wait for 15 seconds at most to find a webelement or until the page opens

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // implicitly wait --> gittigimiz sayfa acilincaya veya aradigimiz
        // webelement bulununcaya kadar driver'in bekleyebilecegi max sureyi belirler

        // system will wait for 15 seconds at most to find a webelement or until the page opens

        //bir web elementini driver'ımıza tarif etmek istersek
        //o driver'a HTML kodlarıyla o elementi tarif etmeliyiz

        //örneğin tag'ı input olarak dersek 57 tane çıkabilir.
        //Bunların içerisinden html kodlarına bakarak id'si .. olan şeklinde
        //spesifikleştirmemiz gerekir

        //araayı html kodları üzerindeyken Ctrl+F ile bulabiliriz
        //html kodları içerisinde unique olarak tarif etme işlemini yapmamız gerekir

        //tag: input (kırmızı)
        //attributes: (yeşil)
        //type, id, value, autocomplete, placeholder, class, tabindex, aria-label
        //Inspect - İncele
        //maviok tıklı iken gittiğimiz yerin html kodunu verir
    }
}
