package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_DosyaYolunuDinamikYapma {


    @Test
    public void test01(){
        // herkesin bilgisayarinda farklı bir dosya hiyerarşisi oldugundan
        // herkesin dosaya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardım alacağız

        System.out.println(System.getProperty("user.dir"));
        // projenin oldugu dosya yolunu verir
        // C:\Users\90545\IdeaProjects\com.Team113Junit

        System.out.println(System.getProperty("user.home"));
        // C:\Users\90545


        /*
            Biz Downloads'a indirdigimiz dodsyanın dosya yolunu ikiye böleceğiz
            C:\Users\90545\                       IdeaProjects\com.Team113Junit
            herkesin bilgisayarında               herkeste ayni
            farklı
            System.getProperty("user.home")
         */

        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluHerkesteAyniOlanKisim = "/Downloads/logo.png";

        String dosyaYolu =  dosyaYoluDegisenKisim + dosyaYoluHerkesteAyniOlanKisim;
        // C:\Users\90545\Downloads\logo.png

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // ayni islemi projemizin altındaki deneme.txt icin yapsak

        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        dosyaYoluHerkesteAyniOlanKisim = "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";

        dosyaYolu = dosyaYoluDegisenKisim+dosyaYoluHerkesteAyniOlanKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
