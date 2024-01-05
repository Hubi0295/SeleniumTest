package pl.testy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pl.testy.BaseTest;

import java.time.Duration;
import java.util.List;

public class SecondTest extends BaseTest {
    @Test @Ignore
    public void firstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitforElement(By.cssSelector("p"),driver);
        String pTest = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(pTest,"Dopiero się pojawiłem!");
        driver.quit();
    }
    @Test
    public void secondTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitforElement(By.cssSelector("p"),driver);
        String pTest = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(pTest,"Dopiero się pojawiłem!");
        driver.quit();
    }
    public void waitforElement(By loc, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until((WebDriver driver1) -> {
            List<WebElement> el = driver1.findElements(loc);
            if (el.size() > 0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Brak elementu");
                return false;
            }
        });
    }
}
