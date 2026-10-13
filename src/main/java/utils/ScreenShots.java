package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShots {
    public static String capture(WebDriver driver, String testName) {

        //1 : give the source of screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2 : determine the path
        String path = "screenshots/" + testName + "_"
                + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg";

        File Dest = new File(path);

        //3 : Copying
        try {
            FileUtils.copyFile(src,Dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4 : return path
        return path;
    }
}


