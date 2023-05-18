package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utulities.TestBase;

import java.util.Set;

public class C02_SwitchingWindows extends TestBase {

    /*
        driver.switchTo().newWindow() kullanarak
        actıgımız window'a  driver otomatik oalrak geçer

        ANCAKKKK....
        biz newWindow() methodunu
        bir link tıkladigimizda yeni window aciliyorsa
        driver eski window'da kalir.
        Yeni windowa driver'i gecirebilmek için
        yeni window'un WindowHandle degerine ihtiyacımız vardir
     */
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstWindowHandle = driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.tagName("h3"));
        String expectedText = "Opening a new window";
        String actualText = text.getText();
        Assert.assertEquals(expectedText,actualText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actulaTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actulaTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        // 42. satir itibariyle yeni window acildi
        // artik 2 window'umuz var. eger driver.getWindowHandle() dersek ikisini de getirir.
        // o yüzden Set<> olusturacagiz

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
        Set<String> windowHandlesSet = driver.getWindowHandles();
        String ikinciSayfaWHD = "";
        for(String eachWh : windowHandlesSet){
            if (!eachWh.equals(firstWindowHandle)){
                ikinciSayfaWHD = eachWh;
            }
        }
        // artik  2. sayfanin windowHandle degerine sahibiz
        driver.switchTo().window(ikinciSayfaWHD);
        expectedTitle = "New Window";
        actulaTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actulaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expectedText = "New Window";
        actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedText,actualText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
        driver.switchTo().window(firstWindowHandle);
        expectedTitle = "The Internet";
        actulaTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actulaTitle);
    }
}
