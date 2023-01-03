package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_AutomationExercise {
    public static void main(String[] args) {

        /*
                    Automation Exercise Link Testi
            1- Bir test class’i olusturun ilgili ayarlari yapin
            2- https://www.automationexercise.com/ adresine gidin
            3- Sayfada 147 adet link bulundugunu test edin.
            4- Products linkine tiklayin
            5- special offer yazisinin gorundugunu test edin
            6- Sayfayi kapatin
         */

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.

        //bunun için linkleri locate etmemiz gerekir
        //WebELementlerinden oluşan bir list oluştururuz.
        //birden fazla link bulacağımız için bir tane WebElement değil,
        //WebELementlerden oluşan bir liste oluştururuz. birden fazla elemeti
        //bulacağı için findElements kullanırız
        //bütün linklerin tag'ının a olduğunu bildiğimiz için burada tagName ile locate edebiliriz

        List<WebElement> linkList= driver.findElements(By.tagName("a"));

        if (linkList.size()==147){
            System.out.println("Link list test PASSED");
        }else{
            System.out.println("There is "+ linkList.size()+" link in the page, test FAILED");
        }

        //4- Products linkine tiklayin
        //önce manuel olarak yaparız. adrese gidip products'ı inspect ile locate ederiz
        //bu da bir link ve yazısı " Products" eğer LinkText ile yapacaksak baştaki boşluğu da almalıyız

        //products linkine sadece click yapacağımız için WebElement oluşturmamıza gerek yok
        driver.findElement(By.partialLinkText("Products")).click();

        //5- special offer yazisinin gorundugunu test edin

        //sayfaya gidip baktığımızda bunu     5526545490
        WebElement specialOfferElement= driver.findElement(By.id("sale_image"));

        if (specialOfferElement.isDisplayed()){ //görünür olup olmadığına bakarız
            System.out.println("Special offer test PASSED");
        }else {
            System.out.println("Special offer test FAILED");
        }

        /*
            NoSuchElementException driver findElement ile aradigi bir elementi
            bulamazsa olusur
         */
        //6- Sayfayi kapatin
        driver.close();
    }
}

