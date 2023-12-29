import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UploadTest {
    @Test
    public void upload() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Daniel\\Desktop\\HubertSzelepustaLab14.txt");
        TakesScreenshot take = (TakesScreenshot) driver;
        File file = take.getScreenshotAs(OutputType.FILE);
        String currentDateTime = new SimpleDateFormat("yyyy;MM;dd;;HH;mm;ss").format(new Date());
        String path = "src/test/resources/screen"+currentDateTime+".png";
        System.out.println(path);
        FileUtils.copyFile(file,new File(path));
    }
}
