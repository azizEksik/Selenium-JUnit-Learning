package day07_JUnit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterClass {

    // 1) Bir class oluşturun: YoutubeAssertions
    // 2) https://www.youtube.com adresine gidin
    // 3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    // ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com/");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    // 3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    @Test
    public void titleTest(){
        // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expected = "YouTube";
        String actual = driver.getTitle();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void imageTest(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logoIcon = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));

        Assert.assertTrue(logoIcon.isDisplayed());
    }

    @Test
    public void searchBox(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("(//input[@id='search'])[1]"));

        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
       //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expected = "youtube";
        String actual = driver.getTitle();

        Assert.assertNotEquals(expected,actual);
    }


}
