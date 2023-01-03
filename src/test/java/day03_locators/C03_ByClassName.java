package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        /*
        Class attribute'u genelde ortak özelliklerdeki elementleri kategorize etmek için kullanılır
        Bu yüzden genelde className bir element bulmak için değil, aynı özelliklerdeki farklı elementleri
        bulmak için kullanırız
        */

        //NOTE: Class attribute'nun değerinde space varsa className ile Locate etmelerin çoğu başarısız
        //olabilir. Bu yüzden className ile arama yaparken space içermediğinden emin olmalıyız

        // amazon'a gidip nutella icin arama yapin
        // ilk sayfada cikan urunlerin icerisinde
        // en yuksek fiyati bulun

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement  amazonTextSearchBox= driver.findElement(By.id("twotabsearchtextbox"));
        amazonTextSearchBox.sendKeys("Nutella" + Keys.ENTER);

        //className a-price-whole olan 18 tane sonuç çıkıyor. 18 taneyi bir WebElement'e
        //yükleyemeyeceğimizi çin List oluşturuyoruz

        List<WebElement> priceList= driver.findElements(By.className("a-price-whole")) ;

        //WebElement bir obje oldugundan, direk yazdirilamaz.
        //Bu şekilde fiyatları yazdırmaz, bu geçersiz bir iştir
        System.out.println(priceList);

        //Bu elementler üzerindeki yazıları yazdırmak istiyoruz
        // Bunun icin for-each loop kullanarak
        // her bir webelement uzerindeki yazilari tek tek yazdirmaliyiz

        for (WebElement each: priceList
        ) {
            System.out.print(each.getText()+" "); //her bir WebElement üzerindeki text'i al ve yazdır
        }

        // en yuksek fiyati bulabilmek icin java bilgimizi kullanmaliyiz
        // 1- web elementlerden getText ile fiyati String olarak alin
        // 2- string fiyati kiyaslama yapabilmek icin Integer'a cevirin
        // 3- en yuksek fiyati bulup yazdirin

        //ihtiyacımmız olan variable'ları oluştururuz
        String priceStr;
        Integer priceInt;
        Integer highestPrice=0; //karşılaştırma yapacağımız için 0 olarak atıyoruz

        //gelen herbir element üzerindeki fiyatı String olarak alırız
        for (WebElement each: priceList
        ) {

            priceStr= each.getText(); //gelen herbir element üzerindeki text'i al
            priceInt=Integer.parseInt(priceStr); //string olan fiyatı ınteger fiyata çevir
            //artık elimizde integer olan bir fiyat var

            //bu fiyatı kontrol edelim
            //daha önce atadığımız en yüksek fiyattan(0) daha yüksekse yeni en yüksek yeni fiyat bu deriz
            if (priceInt>highestPrice){
                highestPrice=priceInt;
            }

        } //for loop bitince en yüksek fiyatı yazdırırız
        System.out.println("");
        System.out.println("The highest product price : " + highestPrice);

        Thread.sleep(3000);
        driver.close();
    }
}
