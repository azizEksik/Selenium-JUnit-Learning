package day13_ExcelAutomation_Screenshoot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {

        String filePath = System.getProperty("user.dir")+"/src/test/java/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath); // dosyayı getirmek için input olusturduk

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sayfa1");

        //4) 4.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sheet.getRow(0).createCell(4).setCellValue("Nufus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sheet.getRow(1).createCell(4).setCellValue("1500000");

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sheet.getRow(9).createCell(4).setCellValue("1500000");

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sheet.getRow(14).createCell(4).setCellValue("1500000");

        //9) Dosyayi kaydedelim
        FileOutputStream fileOutputStream = new FileOutputStream(filePath); // dosyayı kaydetmek için output olusturduk

        workbook.write(fileOutputStream); // write methodu ile outputu kaydettik

        //10)Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
