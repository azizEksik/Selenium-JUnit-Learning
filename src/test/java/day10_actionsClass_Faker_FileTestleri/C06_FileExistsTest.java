package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C06_FileExistsTest {

    @Test
    public void test01(){

        // com.Team113JUnit projesi içerisinde
        // deneme.txt dosyasının var olduğunu test edin

        String dosyaYolu = "src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}