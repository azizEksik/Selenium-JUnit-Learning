package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

import java.util.Set;

public class C03_ActionsClass extends TestBase {

    //1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    //3- Cizili alan uzerinde sag click yapin
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions =new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

        Thread.sleep(2000);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertText = "You selected a context menu";
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText,actualAlertText);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        /*
            Link'e tıkladığımızda yeni bir window degeri açıldığı için
            ilk windowHandle degereni almalıyız, linke tıklamadan önce
         */
        String firstWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> windowHandles = driver.getWindowHandles();
        String secondWindowHandle ="";
        for (String eachwh : windowHandles){
            if (!eachwh.equals(firstWindowHandle)){
                secondWindowHandle = eachwh;
            }
        }
        driver.switchTo().window(secondWindowHandle);
        WebElement h1TagElement = driver.findElement(By.tagName("h1"));
        String expectedTagText = "Elemental Selenium";
        String actualTagText = h1TagElement.getText();

        Assert.assertEquals(expectedTagText,actualTagText);

    }
}
