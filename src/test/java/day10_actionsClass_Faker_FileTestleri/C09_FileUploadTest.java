package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class C09_FileUploadTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        /*
            Driver ile gittigimiz bir web sayfasında
            bilgisayarımızdaki bir dosyayı upload etmek istersek

            bigisayarımızdaki klasörlere erismemiz gerekir
            Selenium webdriver bilgisayardaki dosyalara erişemez

            bunun yerine 3 adimla su ilemleri yaparız
            1- choose file buttonunu locate edelim
            2- bilgisayarımızdan yüklemek istediğimiz dosyanın dosya yolunu olusturalım
               (Mumkünse dinamik dosya yolu olsun)
            3- chooseButton.sendKeys(dosya yolu) ile dosya yolunu sisteme tanitalım
         */


        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        //4. deneme.txt dosyasını seçelim secelim.
        String filePath = System.getProperty("user.dir")+"/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        chooseFileButton.sendKeys(filePath);
        Thread.sleep(3000);
        //5. Upload butonuna basalim.
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadTextElement = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

        Assert.assertTrue(fileUploadTextElement.isDisplayed());

        Thread.sleep(2000);

    }
}
