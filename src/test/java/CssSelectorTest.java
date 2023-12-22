import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CssSelectorTest {
    @Test
    public void CssTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("Pierwszy znaleziony");

        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        By cssClass2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);

        By all = By.cssSelector("*");
        List<WebElement> w = driver.findElements(all);
        System.out.println(w.size());

        By ulInsideDiv = By.cssSelector("div ul");
        driver.findElement(ulInsideDiv);

        By trInsideTable = By.cssSelector("table tr");
        driver.findElement(trInsideTable);

        By firstChildUlInDiv = By.cssSelector("div>ul");
        driver.findElement(firstChildUlInDiv);

        By firstChildTrInTbodyinTable = By.cssSelector("table>tbody>tr");
        driver.findElement(firstChildTrInTbodyinTable);

        By firstFormAfterLabel = By.cssSelector("label + form");
        driver.findElement(firstFormAfterLabel);

        By allFormAfterLabel = By.cssSelector("label ~ form");
        List<WebElement> listOfForms = driver.findElements(allFormAfterLabel);

        By nameContainsAme = By.cssSelector("input[name*='me']");
        driver.findElement(nameContainsAme);

        By nameStartsWithUs = By.cssSelector("input[name*='us']");
        driver.findElement(nameStartsWithUs);

        By nameEndsWithMe = By.cssSelector("input[name$='me']");
        driver.findElement(nameEndsWithMe);

        By firstChildLi = By.cssSelector("li:first-child");
        driver.findElement(firstChildLi);

        By lastChildLi = By.cssSelector("li:last-child");
        driver.findElement(lastChildLi);

        By nChildLi = By.cssSelector("li:nth-child(2)");
        driver.findElement(nChildLi);
    }
}
