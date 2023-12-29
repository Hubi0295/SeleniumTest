import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {
    @Test
    public void testNewWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        String currentWindow = driver.getWindowHandle();
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();
        WebElement buttonNewPage = driver.findElement(By.id("newPage"));
        buttonNewPage.click();

        Set<String> windowNames = driver.getWindowHandles();
        for(String s:windowNames){
            if(!s.equals(currentWindow)){
                driver.switchTo().window(s);
            }
        }
        WebElement searchBar = driver.findElement(By.name("q"));
        WebElement accept = driver.findElement(By.id("L2AGLb"));
        accept.click();
        searchBar.sendKeys("Try");
        driver.switchTo().window(currentWindow);
        driver.findElement(By.cssSelector("[type='checkbox']")).click();


    }
}
