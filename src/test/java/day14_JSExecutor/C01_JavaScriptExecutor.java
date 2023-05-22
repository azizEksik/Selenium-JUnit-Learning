package day14_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class C01_JavaScriptExecutor extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        // asagiya inerek Software Development Engineer in Test - SDET
        // kursunda Explore the Course butonuna basın
        WebElement exploreButtonElement = driver.findElement(By.xpath("(//div[@class='box-footer'])[2]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // jse ile buttona kadar scroll yapalim
        jse.executeScript("arguments[0].scrollIntoView();",exploreButtonElement); // element görünene kadar scroll yap

        // jse ile click yapalim

        jse.executeScript("arguments[0].click();",exploreButtonElement);

        //jse ile alert olsuturma

        jse.executeScript("alert('Bu is bu kadar');",exploreButtonElement);

        Thread.sleep(5000);
    }
}
