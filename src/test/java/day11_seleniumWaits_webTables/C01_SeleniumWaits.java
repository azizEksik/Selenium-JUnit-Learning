package day11_seleniumWaits_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_SeleniumWaits {
    /*
        Otomasyon yaparken
        sayfanın yüklenmesi ve webelementlerin bulunması için gerekli süreyi
        implicitly wait ile ayarlariz

        Implicitly wait sayfanın yüklenmesi ve
        her bir webelementin bulunması için tanımlanan
        max. bekleme süresidir
        her işlem için sıfırdan başlar ve max süre doluncaya kadar
        görevi tamamlamaya calısır
        max süre içerisinde görev tamamlanamazsa
        exception verip calismayı durdurur

        Testlerin büyük çoğunluğunda
        implicitly wait süresi
        Senkronizasyonu sağlamak için yeterli olur

        ANCAK
        ozel bir görev için implicitly wait'de tanimlanan
        max bekleme süresinden daha fazla beklememiz gerekirse
        O GOREVE OZGUN, TEKSEFERLİK bir wait olusturabiliriz

     */

    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest(){

        // implicitly wait'in rolünü görebilmek için
        // baslangic ayarlarini bu test methodunda yapalim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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

    @Test
    public void explicitWaitTest(){
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

        /*
            Burada testi manuel olarak yapıp
            bir karar vermemiz gerekiyor
            1- test etmek istediğimiz webelement zaten görünüyorsa
               weblementi locate yapıp sonra özel beklmeyi tanımlarız

            2- test etmek istediğimiz elementin ulaşılabilir olması için
               beklemek gerekiyorsa,
               locator'ı veirp , bu locator ile bir element locate edene kadar
               "exception fırlatma bekle" diyebiliriz
         */

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement itsGoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        //6. Add buttonuna basin
        WebElement addButtonElement = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        addButtonElement.click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsBackElement.isDisplayed());

        driver.quit();
    }



}



















