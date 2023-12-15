import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
    @Test
    public void openGooglePage(){
        String path = "C:\\Users\\Daniel\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.pl/");
        driver.close();
    }
}
