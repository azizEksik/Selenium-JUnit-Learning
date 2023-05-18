package day06_JUnitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C04_AssertionMethodlari {


    @Test
    public void test01(){

        /*
            Eger testin sonucunu turkce olarak olumlu bir cumle ile sorduysa assertTrue
            olumsuz cümle kullanilmissa assertFalse tercih edilir
         */

        int sayi1 = 20;
        int sayi2 = 10;
        int sayi3 = 30;

        // sayi1'in sayi2'den büyük oldugunu test edin

        Assert.assertTrue(sayi1>sayi2); // PASSED

        // sayi1'in sayi3'den büyük olmadığını test edin

        Assert.assertFalse(sayi1>sayi3);

        // sayi1'in sayi3'den kücük oldugunu test edin

        Assert.assertTrue(sayi1<sayi3);
    }
}
