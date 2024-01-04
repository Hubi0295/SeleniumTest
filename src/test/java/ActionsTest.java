import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest {
    @Test
    public void ActionTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.id("myFile"))).perform();

        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");
        WebElement el = driver.findElement(By.id("bottom"));
        action.doubleClick(el).perform();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        el = driver.findElement(By.tagName("h1"));
        action.moveToElement(el).perform();
    }
}
