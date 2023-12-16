import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest{
    public static WebDriver getDriver(String browser) throws WrongBrowserException{
        switch (browser){
            case "chrome" :WebDriverManager.chromedriver().setup(); return new ChromeDriver();
            case "firefox" :WebDriverManager.firefoxdriver().setup();return new FirefoxDriver();
            case "edge" :WebDriverManager.edgedriver().setup();return new EdgeDriver();
            default :throw new WrongBrowserException("Wrong browser");
        }
    }

}
