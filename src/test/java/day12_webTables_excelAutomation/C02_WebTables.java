package day12_webTables_excelAutomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    //1. “https://demoqa.com/webtables” sayfasina gidin
    //2. Headers da bulunan basliklari yazdirin
    //3. 3.sutunun basligini yazdirin
    //4. Tablodaki tum datalari yazdirin
    //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
    //6. Tablodaki satir sayisini yazdirin
    //7. Tablodaki sutun sayisini yazdirin
    //8. Tablodaki 3.kolonu yazdirin
    //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
    //sayisini girdigimde bana datayi yazdirsin

    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerList = driver.findElements(By.xpath("//div[@role='row'][1]/div[@role='columnheader']"));
        for (WebElement headerEach : headerList){
            System.out.println(headerEach.getText());
            System.out.println("-----------------------------------");
        }
        //3. 3.sutunun basligini yazdirin
        String ucuncuStunBasligi = driver.findElement(By.xpath("//div[@role='row'][1]/div[@role='columnheader'][3]")).getText();
        System.out.println("==============================");
        System.out.println(ucuncuStunBasligi);

        //4. Tablodaki tum datalari yazdirin
        System.out.println("=================================");
        List<WebElement> allDatasElementList = driver.findElements(By.xpath("//div[@role='gridcell']"));
        for (WebElement dataEach : allDatasElementList){
            System.out.println(dataEach.getText());
            System.out.println("-----------------------------------");
        }

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("=====================================");
        int notEmptyData =0;
        for (WebElement dataEach : allDatasElementList){
            if (!dataEach.getText().isBlank()){
                notEmptyData++;
            }
        }
        System.out.println("Bos olmayan data sayisi : " + notEmptyData);

        //6. Tablodaki satir sayisini yazdirin
        System.out.println("=================================");
        List<WebElement> tableLineNumber = driver.findElements(By.xpath("//div[@role='rowgroup']"));
        System.out.println("tablodaki satir sayisi : " + tableLineNumber.size());

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("=================================");
        List<WebElement> tableColumnNumber = driver.findElements(By.xpath("(//div[@role='row'])[2]/div[@role='gridcell']"));
        System.out.println("tablodaki sutun sayisi : " + tableColumnNumber.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> tableColumn3 = driver.findElements(By.xpath("(//div[@role='row'])/div[@role='gridcell'][3]"));
        for (WebElement each : tableColumn3){
            System.out.println(each.getText());
            System.out.println("-------------------------");
        }
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("==================================");
        for (WebElement dataEach : allDatasElementList){
            if (dataEach.getText().contains("Kierra")){
                String salary = driver.findElement(By.xpath("(//div[@role='row'])[4]/div[@role='gridcell'][5]")).getText();
                System.out.println(salary);
            }
        }
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin

        dataYazdir(4,1);

    }

    public void dataYazdir(int satirNo, int sutunNo){

        String data = "(//div[@role='row'])["+satirNo+"]/div[@role='gridcell']["+sutunNo+"]";

        WebElement dataGetir = driver.findElement(By.xpath(data));

        System.out.println("girdiginiz kordinattaki data : " + dataGetir.getText());
    }
}
