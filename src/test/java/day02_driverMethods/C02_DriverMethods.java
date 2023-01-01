package day02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) throws InterruptedException {

        //açtığımız sayfanın boyutlarını belirlediğimiz ölçülerde değiştirebiliriz.
        //genelde maximize yaparak kullanırız

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        // enlarge the window
        // sayfayi tam ekran yapalim
        driver.manage().window().maximize();
        System.out.println("maximized window size: "+driver.manage().window().getSize());
        System.out.println("maximized window position : "+driver.manage().window().getPosition());

        Thread.sleep(3000);

        // Make it fullscreen
        driver.manage().window().fullscreen();
        System.out.println("fullscreen window size"+driver.manage().window().getSize());
        System.out.println("fullscreen window position"+driver.manage().window().getPosition());

        // let's change size and positions
        // browser'i istedigimiz konuma ve boyuta getirelim

        Thread.sleep(3000);

        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(300,300));

        Thread.sleep(3000);
        driver.close();
        //driver.quit(); - driver.close(); farkı:
         // test çalışırken birden fazla browser window'u ya da tab'ı açılmışsa quit
        // açılmış olan hepsini kapatır, close ise en son driver neredeysse o window'u kapatır


    }
}
