import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitTest {
    @Test
    public void WaitTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();

        //Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        //driver.findElement(By.cssSelector("p"));
        waitforElement(By.cssSelector("p"),driver);
    }
    public void waitforElement(By loc, WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until((WebDriver driver1) -> {
            List<WebElement> el = driver1.findElements(loc);
            if(el.size()>0){
                System.out.println("Element jest na stronie");
                return true;
            }
            else{
                System.out.println("Brak elementu");
                return false;
            }
        });
//        wait.until(new Function<WebDriver, Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                List<WebElement> el = driver.findElements(loc);
//                if(el.size()>0){
//                    System.out.println("Element jest na stronie");
//                    return true;
//                }
//                else{
//                    System.out.println("Brak elementu");
//                    return false;
//                }
//            }
//
//        });
    }
}
