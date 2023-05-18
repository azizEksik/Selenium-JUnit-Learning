package day10_actionsClass_Faker_FileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import utulities.TestBase;

public class C04_ornekTest extends TestBase {

    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2- Hover over Me First" kutusunun ustune gelin
    //3- Link 1" e tiklayin
    //4- Popup mesajini yazdirin
    //5- Popup'i tamam diyerek kapatin
    //6- “Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin

    @Test
    public void test01() throws InterruptedException {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        WebElement  hoverOverMeFirstElement = driver.findElement(By.xpath("//Button[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirstElement).perform();
        Thread.sleep(2000);
        //3- Link 1" e tiklayin
        WebElement homFirstLink1 = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='dropdown-content']")).below(By.tagName("a")));
        homFirstLink1.click();
        Thread.sleep(2000);
        //4- Popup mesajini yazdirin
        System.out.println("popup message : " + driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();

        Thread.sleep(2000);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("click and hold text : " + clickAndHold.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMeElement = driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(doubleClickMeElement).perform();

        Thread.sleep(2000);
    }
}
