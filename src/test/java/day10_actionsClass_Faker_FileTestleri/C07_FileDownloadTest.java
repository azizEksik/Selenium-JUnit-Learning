package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileDownloadTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        WebElement logoPngElement = driver.findElement(By.xpath("(//a[text()='logo.png'])"));
        logoPngElement.click();
        Thread.sleep(3000); // indirmek icin süreye ihtiyac olabilir

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // Dosyayı Downloads klasörüne indiricek

        String dosyaYolu = "C:\\Users\\90545\\Downloads\\logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // herkesin bilgisayarinda farklı bir dosya hiyerarşisi oldugundan
        // herkesin dosaya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardım alacağız

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));



    }
}
