package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBaseBeforeAfterClass;

public class C02_JSAlerts extends TestBaseBeforeAfterClass {
    /*
        Otomasyon yaparken iki türalert ile karsilasa bilriz
        1- HTML Alerts :
           HTML kodlari ile olusturulmus alert'lerdir
           HTML ile olusturuldugu için inspect edilebilir,
           locate edilebilir ve driver ile kullanılabilir

        2- JavaScript Alerts :
           Inspect yapilamaz, locate edilemez
           Testlerimiz sirasinda JS alert ile karsilasirsak
           driver.switchTo().alert() method'larini kullanarak
           alert'e gecis yapabilir ve alert üzerinde
           OK, Cancel, Alert yazisini alma getText()
           ve alert'e yazi yollama sendKeys()
           method'larini kullanabiliriz
     */

    //3 test method'u olusturup asagidaki gorevi tamamlayin
    //1. Test
    //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //- 1.alert'e tiklayin
    //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
    //- OK tusuna basip alert'i kapatin
    //2.Test
    //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //- 2.alert'e tiklayalim
    //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    //3.Test
    //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //- 3.alert'e tiklayalim
    //- Cikan prompt ekranina "Abdullah" yazdiralim
    //- OK tusuna basarak alert'i kapatalim
    //- Cikan sonuc yazisinin Abdullah icerdigini test edelim

    @Test
    public void test01(){
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertText,actualAlertText);

        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02(){
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();

        String expectedText = "You clicked: Cancel";
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void test03(){
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedText = "Abdullah";
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actualText.contains(expectedText));
    }

}
