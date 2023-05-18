package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C04_ActionsClass extends TestBase {

    // 1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01() throws InterruptedException {
        // 1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElement,dropHereElement).perform();

        Thread.sleep(2000);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedDropHereText = "Dropped!";
        String actualDropHereText = dropHereElement.getText();

        Assert.assertEquals(expectedDropHereText,actualDropHereText);

    }

}
