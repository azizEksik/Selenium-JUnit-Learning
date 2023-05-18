package day10_actionsClass_Faker_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C03_FakerClass extends TestBase {
    /*
        Faker kütüphanesi
        feyk degerler olusturabilecegimiz bir kütüphanedir

        buradan deger uretebilmek için
        faker class'ından bir obje olusturmalıyız
     */

    @Test
    public void test01(){
        // twitter adresine git
        driver.get("https://twitter.com");

        // hesap olustur butonuna tıkla
        driver.findElement(By.xpath("//span[text()='Hesap oluştur']")).click();

        // isim telefon ve tarih giriniz ve ileri buttonuna tıklayın

        WebElement nameBox = driver.findElement(By.xpath("//input[@autocomplete='name']"));
        Actions actions = new Actions(driver);

        Faker faker = new Faker();

        actions.click(nameBox)
                .sendKeys(faker.howIMetYourMother().character())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Mayıs")
                .sendKeys(Keys.TAB)
                .sendKeys("22")
                .sendKeys(Keys.TAB)
                .sendKeys("1996").perform();

    }
}
