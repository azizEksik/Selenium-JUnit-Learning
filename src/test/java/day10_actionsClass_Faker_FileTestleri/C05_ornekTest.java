package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class C05_ornekTest extends TestBase {

    //2- https://html.com/tags/iframe/ sayfasina gidelim
    //3- video’yu gorecek kadar asagi inin
    //4- videoyu izlemek icin Play tusuna basin
    //5- videoyu calistirdiginizi test edin

    @Test
    public void test01() throws InterruptedException {
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        WebElement homePageElement = driver.findElement(By.xpath("//body[@class='page-template-default single single-page postid-164 wp-custom-logo mega-menu-primary group-blog test-class-name html-feature element cookies-not-set']"));
        for (int i = 0; i < 25; i++) {
            homePageElement.sendKeys(Keys.ARROW_DOWN);
        }

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        Thread.sleep(3000);
        //5- videoyu calistirdiginizi test edin
        WebElement playButton = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        Assert.assertFalse(playButton.isDisplayed());
    }

}
