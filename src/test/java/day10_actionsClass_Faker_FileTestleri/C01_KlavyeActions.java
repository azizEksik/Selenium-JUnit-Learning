package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C01_KlavyeActions extends TestBase {

    @Test
    public void test01(){
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve
        //Enter’a basarak arama yaptirin
        Actions actions = new Actions(driver);
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));

        actions.click(searchBoxElement)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER).perform();

        //4- aramanin gerceklestigini test edin
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String expectedResult = "Samsung A71";
        String actulaResult  = resultText.getText();

        Assert.assertTrue(actulaResult.contains(expectedResult));
    }
}
