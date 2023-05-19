package day12_webTables_excelAutomation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;
import utulities.TestBaseBeforeAfterClass;

import java.util.List;

public class C01_WebTables extends TestBase {

    //1."https://www.amazon.com" adresine gidin
    //2.Sayfanin en altina inin
    //3.Web table tum body’sini yazdirin
    //4.Web table’daki satir sayisinin 9 oldugunu test edin
    //5.Tum satirlari yazdirin
    //6. Web table’daki sutun sayisinin 13 olduğunu test edin
    //7. 5.sutunu yazdirin
    //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
    //döndüren bir method olusturun

    @Test
    public void test01() throws InterruptedException {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        //3.Web table tum body’sini yazdirin
        WebElement allTableBody = driver.findElement(By.xpath("//table/tbody"));
        System.out.println(allTableBody.getText());
        /*
            tüm body'i tek element olarak locate etmek
            body icinde gecen bir metnin varlıgını tyest etmek gibi görevler icin kullanılabilir
         */

        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> lineNumberElement = driver.findElements(By.xpath("//table/tbody/tr"));
        int expectedLineNumber = 9;
        int actualLineNumber = lineNumberElement.size();
        Assert.assertEquals(expectedLineNumber,actualLineNumber);

        //5.Tum satirlari yazdirin
        System.out.println("=============================");
        for (WebElement eachLineList : lineNumberElement){
            System.out.println(eachLineList.getText());
        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        lineNumberElement = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        int expectedColumnNumber = 13;
        int actualColumnNumber = lineNumberElement.size();
        Assert.assertEquals(expectedColumnNumber,actualColumnNumber);

        //7. 5.sutunu yazdirin
        System.out.println("====================================");
        lineNumberElement = driver.findElements(By.xpath("//table/tbody/tr/td[5]"));
        for (WebElement eachColumnList : lineNumberElement){
            System.out.println(eachColumnList.getText());
        }
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("==============================");

        System.out.println(hucreBilgisiDonderenMethod("3", "7").getText());

    }

    public WebElement hucreBilgisiDonderenMethod(String satirSayisi, String sutunSayisi){

        String satirArtiSutun= "//table/tbody/tr"+"["+satirSayisi+"]"+"/td"+"["+sutunSayisi+"]";

        WebElement satirSutunBilgisi = driver.findElement(By.xpath(satirArtiSutun));

        return satirSutunBilgisi;
    }

}
