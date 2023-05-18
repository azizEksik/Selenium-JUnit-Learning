package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utulities.TestBase;

public class C01_NewWindow extends TestBase {

    /*
        Eger driver.switchTo().newWindow() kullanilirsa
        driver otomatik oalrak açılan yeni sayfaya gecer

        Eger görevimizde y4eni window'a gittikten sonra
        window'lar arası geçiş işlemi varsa
        üzerinde çalıştıgımız window'ların
        windowHandle degerlerini alıp kaydetmekte fayda var

     */

    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        String amazonwindowHandle = driver.getWindowHandle(); // tekrardan amazona dönecegimiz için kaydettik

        // tittle'in Amazon kelimesi icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        // yeni bir tab acarak wisequarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String wisequarterWindowHandle = driver.getWindowHandle(); // tekaradan yeni tab'e dönmemiz gerekirse diye

        // url'in wisequarter icerdigini test edin
        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // tekrar amazonun açık oldugu sayfaya geçin
        driver.switchTo().window(amazonwindowHandle);

        // Url'in amazon icerdigini test edin
        expectedUrl = "amazon";
        actualUrl = driver.getCurrentUrl();
        Thread.sleep(1000);

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
