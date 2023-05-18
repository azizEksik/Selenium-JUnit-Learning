package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assert {

    // Amazon'a gidip title'in AMAZON icerdigini test edin

    @Test
    public void test01(){

        /*
            JUnit calistirilan test methodlarinda kac tanesinin
            passed, failed veya ignore oldugunu otamatik olarak raporlar

            Eger JUnit'in test socularini dogru olarak raporlamasini istiyorsak
            Assert class'indan hazır methodlar kullanarak test yapmaliyiz

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        String expectedIcerik = "AMAZON";

        String actualIcerik = driver.getTitle();

        /*
        if (driver.getTitle().contains("AMAZON")){
            System.out.println("Amazon Title Test PASSED");
        }else {

            System.out.println("Amazon Title Test FAILED");
        }
         */

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        driver.close();
    }
}
