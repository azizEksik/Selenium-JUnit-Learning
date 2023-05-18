package day08_testBase_JSalerts_iframe;

import day07_JUnit_dropdown.C01_BeforeAfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utulities.TestBase;

public class C01_TestBaseIlkClass extends TestBase{

    @Test
    public void test01(){
        // amazona gidelim
        driver.get("https://www.amazon.com");

        // Nutellaiçin arama yapalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        // arama sonuclarının nutella icerdigini test edelim
        String expectedIcerik = "Nutella";
        String actualAramaSonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();

        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));


    }

}
