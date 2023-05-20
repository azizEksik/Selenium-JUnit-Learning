package day13_ExcelAutomation_Screenshoot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        // ülkeler.xlsx dosyasında 16. satirdaki ulkenin
        // turkce isminin Barbados oldugunu test edin

        String filepath = System.getProperty("user.dir")+"/src/test/java/day12_webTables_excelAutomation/ulkeler.xlsx";

        FileInputStream  fis = new FileInputStream(filepath);

        Workbook  workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row  = sheet.getRow(15);

        Cell cell = row.getCell(2);

        Assert.assertEquals("Barbados",cell.toString());

        // diger yol

        String expected = "Barbados";
        String actual = workbook.getSheet("Sayfa1").getRow(15).getCell(2).toString();

        Assert.assertEquals(expected,actual);

        // Excel'de ingilizce ismi Benin olan bir ülke
        // olup olmadıgını test tedin


        /*
        Benim yöntem

        List<String> ulkeIsimList = new ArrayList<>();

        for (int i = 0; i < 191; i++) {
            ulkeIsimList.add(workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString());
        }
        String expectedIsim = "Benin";
        String actualIsim = "";

        for (int i = 0; i < ulkeIsimList.size(); i++) {
            if (ulkeIsimList.get(i).equals("Benin")){
                actualIsim = ulkeIsimList.get(i);
            }
        }
        Assert.assertEquals(expectedIsim,actualIsim);

        System.out.println(actualIsim);

         */

        // Excel'de ingilizce ismi Benin olan bir ülke
        // olup olmadıgını test tedin

        int sonSatirNo = workbook.getSheet("Sayfa1").getLastRowNum(); // 190 // 191 vemedi çünkü index veriyor
        String actualUlkeIsim = "";
        boolean beninVarMi = false;
        for (int i = 0; i <= sonSatirNo; i++) {
            actualUlkeIsim = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            if (actualUlkeIsim.equalsIgnoreCase("Benin")){
                beninVarMi = true;
                break;
            }
        }

        Assert.assertTrue(beninVarMi);

        // sayfa 2 de kullanılan satır sayısının 14 oldugunu test edin

        int kullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        Assert.assertEquals(14,kullanilanSatirSayisi);

        // sayfa1'deki tüm ülke isimlerini
        // ve tüm bilgileri bir Map olarak kaydedin

        // ingilizce isim key, geriye kalanlar ise birlestirilerek value olsun

        Map<String,String> ulkelerMap = new TreeMap<>();

        String key= null;
        String  value = null;
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=satirSayisi ; i++) {

            key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+
                    ", "+workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+
                    ", "+workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);
        }

        // Ismi NetherLands olan ulke var mı Test edin

        Assert.assertTrue(ulkelerMap.containsKey("Netherlands"));

    }

}
