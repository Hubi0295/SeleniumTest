import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;

public class SelectorTest {
    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By buttonid = By.id("clickOnMe");
        By textArea = By.name("fname");
        By classParagraf = By.className("topSecret");
        By inputLocator = By.tagName("input");
        By linkText = By.linkText("Visit W3Schools.com!");
        By partialLink = By.partialLinkText("Visit");

        WebElement element = driver.findElement(buttonid);
        WebElement element1 = driver.findElement(textArea);
        WebElement element2 = driver.findElement(classParagraf);
        WebElement inputElement = driver.findElement(inputLocator);
        List<WebElement> inputs = driver.findElements(inputLocator);
        WebElement link = driver.findElement(linkText);


        for(WebElement w:inputs){
            System.out.println(w.toString());
        }

        element1.sendKeys("Blablabla");
        element1.clear();

        inputElement.sendKeys("Zmiana");
//        link.click();


        Assert.assertTrue(element.isEnabled());
        Assert.assertTrue(!element2.isDisplayed());
        element.click();


    }
}
