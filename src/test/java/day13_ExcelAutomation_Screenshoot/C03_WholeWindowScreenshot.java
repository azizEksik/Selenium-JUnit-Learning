package day13_ExcelAutomation_Screenshoot;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utulities.ReusableMethods;
import utulities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_WholeWindowScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {
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

        // rapora eklenmek üzere tüm sayfanın ekran görüntüsünü alalım

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver; // screenshot alabilmek için objemizi olusturduk

        File wholeWindowPhoto = new File("target/screenshot/wholeWindowPhoto.jpg"); // bunu yazarak projemizde
                                                                                             // target klasörü altında
                                                                                             // screenshot isimli bir dosya olusturduk

        File temporaryPhoto = takesScreenshot.getScreenshotAs(OutputType.FILE); // geçici foto olusturduk

        FileUtils.copyFile(temporaryPhoto,wholeWindowPhoto); // geçici fotoyu olusturdugumuz dosyaya kopyaladık

        ReusableMethods.screenShotWholeWindow(driver,"NutellaTest");

    }
}
