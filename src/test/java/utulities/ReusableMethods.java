package utulities;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReusableMethods {


    public static void screenShotWholeWindow(WebDriver driver, String screenshotName){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();

        String date ="WholeWindow__"+ldt.getYear()+"-"+
                        ldt.getMonthValue()+"-"+
                        ldt.getDayOfMonth()+"-"+
                        ldt.getHour()+"-"+
                        ldt.getMinute()+"-"+
                        ldt.getSecond();

        String path = "target/screenshot/"+date+"__"+screenshotName+".jpg";

        File wholeWindowPhoto = new File(path);

        File temporaryPhoto = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryPhoto,wholeWindowPhoto);
        } catch (IOException e) {

        }
    }

    public static void locatorScreenShot(WebDriver driver, String screenShotName, WebElement webElement){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();

        String date ="WebElement__"+ldt.getYear()+"-"+
                ldt.getMonthValue()+"-"+
                ldt.getDayOfMonth()+"-"+
                ldt.getHour()+"-"+
                ldt.getMinute()+"-"+
                ldt.getSecond();

        String path = "target/screenshot/"+date+"__"+screenShotName+".jpg";

        File locatorElementPhoto = new File(path);

        File temporaryLocatorElementPhoto = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryLocatorElementPhoto,locatorElementPhoto);
        } catch (IOException e) {

        }

    }
}
