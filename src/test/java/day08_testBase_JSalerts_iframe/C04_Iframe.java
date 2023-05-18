package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class C04_Iframe extends TestBase {

    //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    //2 ) Bir metod olusturun: iframeTest
    //    - “An IFrame containing….” textinin erisilebilir oldugunu test edin konsolda yazdirin.
    //    - Text Box’a “Merhaba Dunya!” yazin.
    //    - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
    //      gorunur oldugunu dogrulayin ve konsolda yazdirin.

    @Test
    public void iframeTest(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //    - “An IFrame containing….” textinin görünür oldugunu test edin konsolda yazdirin.
        WebElement iframeText = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(iframeText.isDisplayed());
        System.out.println(iframeText.getText());
        //    - Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElement= driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(frameElement);

        WebElement textBoxElement = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElement.clear();
        textBoxElement.sendKeys("Merhaba Dunya!");

        //    - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //      gorunur oldugunu dogrulayin ve konsolda yazdirin.

        /*
            iframe'e gecis yapilinca
            driver'i oradan cıkıs yaptırana kadar driver iframe'in icinde kalır

            driver.switchTo().parentFrame() : ic ice birden fazla iframe varsa bir üste cikar

            driver.switchTo().defaultContent() : direkt anasayfaya cikar
         */

        driver.switchTo().defaultContent();

        WebElement elementalSeleniumLink = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumLink.isDisplayed());
        System.out.println(elementalSeleniumLink.getText());


    }
}
