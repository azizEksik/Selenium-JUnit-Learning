package day10_actionsClass_Faker_FileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C02_KlavyeActions extends TestBase {

    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://tr-tr.facebook.com/");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[3]")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        actions.click(firstNameBox)
                .sendKeys("name")
                .sendKeys(Keys.TAB)
                .sendKeys("lastname")
                .sendKeys(Keys.TAB)
                .sendKeys("example@example.com")
                .sendKeys(Keys.TAB)
                .sendKeys("password")
                .perform();

        //4- Kaydol tusuna basalim
    }
}
