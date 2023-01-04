package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XpathLocate {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- Go to https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Press the Add Element button
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();

        //3- Test that the Delete button is visible
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Delete Button Test PASSED");
        }else {
            System.out.println("Delete Button Test FAILED");
        }

        //4- Press the delete button
        deleteButton.click();

        //5- Test that the text “Add/Remove Elements“ is visible
        WebElement addRemoveText = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveText.isDisplayed()){
            System.out.println("addRemoveText test PASSED");
        }else {
            System.out.println("addRemoveText test FAILED");
        }

        Thread.sleep(5000);
        driver.close();
    }
}
