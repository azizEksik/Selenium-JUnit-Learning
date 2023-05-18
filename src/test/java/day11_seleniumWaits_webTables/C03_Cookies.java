package day11_seleniumWaits_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utulities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> allCookie = driver.manage().getCookies();
        for (Cookie eachSet : allCookie){
            System.out.println(eachSet.getName());
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCookieValue = 5;
        int actulaCookieValue = allCookie.size();

        Assert.assertTrue(actulaCookieValue>expectedCookieValue);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie eachSet : allCookie){
            if (eachSet.getName().equals("i18n-prefs")){
                Assert.assertEquals(eachSet.getValue(),"USD");
            }
        }
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("enSevdigimCookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(driver.manage().getCookies().contains(cookie));

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(driver.manage().getCookies().contains(driver.manage().getCookieNamed("skin")));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Set<Cookie> deletedAllCookies = driver.manage().getCookies();

        Assert.assertEquals(deletedAllCookies.size(),0);
    }
}
