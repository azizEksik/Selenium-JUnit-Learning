package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ornekTestBestBuyAssertions {

    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    //asagidaki testleri yapin
    //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    WebDriver driver;

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bestbuy.com/ ");
    }

    @Test
    public void urlTest(){
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        mahserin4Atlisi();

        String expectedIcerik = "https://www.bestbuy.com/";
        String actualIcerik = driver.getCurrentUrl();

        Assert.assertEquals(expectedIcerik,actualIcerik);

        driver.close();

    }

    @Test
    public void titleTest(){
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        mahserin4Atlisi();

        String UnexpectedIcerik = "Rest";
        String actulaIcerik = driver.getTitle();

        Assert.assertFalse(actulaIcerik.contains(UnexpectedIcerik));

        driver.close();
    }

    @Test
    public void logoTest(){
        //○ logoTest => BestBuy logosunun görüntülendigini test edin

        mahserin4Atlisi();

        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(bestBuyLogo.isDisplayed());

        driver.close();
    }

    @Test
    public void francaisLinkTest(){
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        mahserin4Atlisi();

        WebElement francaisLinkElement = driver.findElement(By.xpath("//button[@lang='fr']"));

        Assert.assertTrue(francaisLinkElement.isDisplayed());

        driver.close();
    }
}
