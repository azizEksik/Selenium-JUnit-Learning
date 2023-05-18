package day10_actionsClass_Faker_FileTestleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C10_Waits {

    @Test
    public void test01(){

        // implicitly wait'in rolünü görebilmek için
        // baslangic ayarlarini bu test methodunda yapalim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        WebElement removeButtonElement = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButtonElement.click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElement = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElement.isDisplayed());

        //6. Add buttonuna basin
        WebElement addButtonElement = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        addButtonElement.click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElement.isDisplayed());

        driver.quit();
    }
}
