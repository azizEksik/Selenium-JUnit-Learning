package day12_webTables_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        // bilgisayarımızda olan bir dosyaya erişebilmek için FileInputStream Class'indan obje olusuturalim
        String filePath = System.getProperty("user.dir") + "/src/test/java/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        // projemize eklediğimiz POI kutuphanelerini kullanarak
        // class'imizin içinde istenen excel'in bir kopyasını olusturalim

        Workbook workbook = WorkbookFactory.create(fis); // excel kopyasini olusturduk
        Sheet sheet = workbook.getSheet("Sayfa1"); // gideceği sayfayı belirler
        Row row = sheet.getRow(0); // gideceği satırı giriyoruz // index gibi kabul ettiği için 0 dan başlar
        Cell cell = row.getCell(2); // gideceği datayı giriyoruz // index gibi kabul ettiği için 0 dan başlar

        System.out.println(cell);

        // 5. indexteki satirin 1. indexindeki datanın "Luanda" oldugunu test edin

        row = sheet.getRow(5);
        cell = row.getCell(1);

        String expected = "Luanda";
        String actual = cell.toString();

        Assert.assertEquals(expected,actual);

        // 12. satir 2. sutundaki bilginin "Baku" oldugunu test edin

        String expectedData= "Baku";
        String actulaData = sheet.getRow(11).getCell(1).toString();

        Assert.assertEquals(expectedData, actulaData);

    }
}
