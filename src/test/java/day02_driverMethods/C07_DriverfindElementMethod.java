package day02_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_DriverfindElementMethod {

    // 8 adet locator vardır
    // 6 tanesi html elementi üzerinde o özellik varsa kullanılır

    //burada searchBox için id attribute'u var olduğu için kullanıldı
    //yoksa başka özellikleri kullanılır

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.drivere","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        // We found a unique statement for the webelement to show it to our driver
        // Bu satırdan itibaren her searchBox dediğimizde artık driver'ın gideceği yer belli
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
                                                        //burası locator'dır
                                                        //id'sini tarif ettiğim elementi bul deriz


        searchBox.sendKeys("Java");
        //hem Java hem Nutella gönderirsek ikisini birlikte arar
        //bunu temizlemek için clear kullanırız. Java yazıp siler ve nutella ile devam eder
        searchBox.clear();
        Thread.sleep(3000);

        // by using webelement "searchbox" I wrote Nutella on the seachbox
        searchBox.sendKeys("Nutella");
        // by using sebelement I pressed enter
        searchBox.submit();
        //böylelikle nutella'ya bastıktan sonra enter diyerek aramayı yapmış olacak

        Thread.sleep(3000);
        driver.close();
    }
}
