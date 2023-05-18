package day07_JUnit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class C04_DropdownMenu {

    //https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        // Element dropdown menu oldugu icin Select class'indan olusturacagimiz
        // obje ile igili methodlari kullanmaliyiz

        WebElement dropdownMenuElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(dropdownMenuElement);

        List<WebElement> allOption = select.getOptions();

        int expectedOption = 45;
        int actualOption = allOption.size();

        Assert.assertEquals(expectedOption,actualOption);

    }

    @Test
    public void test02(){
        //1. Kategori menusunden Books secenegini secin
        WebElement dropdownMenuElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownMenuElement);

        select.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        WebElement serachBoxElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        serachBoxElement.sendKeys("Java" + Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement resultElement = driver.findElement(By.xpath("//div[@class='sg-col-inner'][1]"));
        System.out.println(resultElement.getText());

        //4. Sonucun Java kelimesini icerdigini test edin

        Assert.assertTrue(resultElement.getText().contains("Java"));
    }
}
