package day13_ExcelAutomation_Screenshoot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utulities.ReusableMethods;
import utulities.TestBase;

import java.io.IOException;

public class C04_WebElementScreenShot extends TestBase {

    @Test
    public void test01(){
        // amazon ana sayfaya gidelim
        driver.get("https://www.amazon.com");

        // Nutella aratalim
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("Nutella" , Keys.ENTER);

        // Sonuclarin Nutella içerdigini test edelim
        WebElement resultsElement = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        String expectedResults = "Nutella";
        String actualResults = resultsElement.getText();

        Assert.assertTrue(actualResults.contains(expectedResults));

        // rapora eklenmek üzere sonuç elementinin ekran görüntüsünü alalım

        ReusableMethods.locatorScreenShot(driver,"NutellaElementTest",resultsElement);

    }
}
