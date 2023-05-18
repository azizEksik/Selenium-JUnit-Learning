package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {

    /*
        Bu class icerisinde 3 test calistiralim
        1- google ana sayfaya gidp url'in google icerdigini test edin
        2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        3- amazon anasayfaya gidip, amazon logosunun göründügünü test edin
     */

    /*
        JUnit'in bize sagladigi ilk ve belki de en onemli ozellik
        test methodlarinin bagimsiz olarak calistirilabilmesini saglayan
        @Test notasyonudur

        JUnit ile class level'dan birden fazla test methodu calistirirsak
        hangi sirlama  ile calistiracagini ongoremeyiz ve yonetemeyiz

        Diyelim ki bir test methodu üzerinde çalışıyorsunuz
        ve o methodun toplu calistirilmalarda kullanilmasini istemiyorsunuz
        bu durumda @Ignore kullanılabilir
     */


    WebDriver driver;

    @Test @Ignore
    public void googleTest(){
        // 1- google ana sayfaya gidp url'in google icerdigini test edin

        mahserin4Atlisi();

        driver.get("https://www.google.com");

        if (driver.getCurrentUrl().contains("google")){
            System.out.println("Google Url Test PASSED");
        }else {
            System.out.println("Google Url Test FAILED");
        }

        driver.close();
    }

    @Test
    public void wiseTest(){
        // wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin

        mahserin4Atlisi();

        driver.get("https://www.wisequarter.com");

        if (driver.getCurrentUrl().contains("wisequarter")){
            System.out.println("Wise Test PASSED");
        }else {
            System.out.println("Wise Test FAILED");
        }

        driver.close();
    }

    @Test
    public void amazonTest(){
        // 3- amazon anasayfaya gidip, amazon logosunun göründügünü test edin

        mahserin4Atlisi();

        driver.get("https://www.amazon.com/");

        WebElement amazonLogo = driver.findElement(By.xpath("//div[@id='nav-logo']"));

        if (amazonLogo.isDisplayed()){
            System.out.println("Amazon logo Test PASSED");
        }else {
            System.out.println("Amazon logo Test FAILED");
        }

        driver.close();
    }


    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
