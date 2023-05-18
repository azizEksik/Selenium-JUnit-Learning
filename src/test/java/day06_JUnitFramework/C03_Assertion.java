package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {

    /*
        bir Assertion failed olursa
        Assertion'inin oldugu satirda exception olusur
        ve Assertion satirindan sonraki kodlar CALİSMAZ
     */

    WebDriver driver;

    @Test
    public void googleTest(){
        // 1- google ana sayfaya gidp url'in google icerdigini test edin

        mahserin4Atlisi();

        driver.get("https://www.google.com");

        Assert.assertTrue(driver.getCurrentUrl().contains("google1"));

        driver.close();
    }

    @Test
    public void wiseTest(){
        // wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin

        mahserin4Atlisi();

        driver.get("https://www.wisequarter.com");

        Assert.assertTrue(driver.getCurrentUrl().contains("wisequarter1"));

        driver.close();
    }

    @Test
    public void amazonTest(){
        // 3- amazon anasayfaya gidip, amazon logosunun göründügünü test edin

        mahserin4Atlisi();

        driver.get("https://www.amazon.com/");

        WebElement amazonLogo = driver.findElement(By.xpath("//div[@id='nav-logo']"));

        Assert.assertTrue(amazonLogo.isDisplayed());

        driver.close();
    }

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

}
