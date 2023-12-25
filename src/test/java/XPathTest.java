import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XPathTest {
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

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);

        By byIdX = By.xpath("/html/body/button[@id='clickOnMe']");
        driver.findElement(byIdX);

        By byNameX = By.xpath("//input[@name='fname']");
        driver.findElement(byNameX);

        By byClassX = By.xpath("//p[@class='topSecret']");
        driver.findElement(byClassX);

        By ByLinkTextX = By.xpath("//a[text()='Visit W3Schools.com!']");
        driver.findElement(ByLinkTextX);

        By ByPartialLinkTextX = By.xpath("//a[contains(text(),'Visit')]");
        driver.findElement(ByPartialLinkTextX);

        By allX = By.xpath("//*");
        driver.findElement(allX);

        By secoundElement = By.xpath("(//input)[2]");
        driver.findElement(secoundElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementWithAttribute = By.xpath("//*[@name]");
        driver.findElement(elementWithAttribute);

        By elementWithAttributeContains = By.xpath("//*[contains(@name,'ame')]");
        driver.findElement(elementWithAttributeContains);

        By attributeStartsWith = By.xpath("//*[starts-with(@name,'user')]");
        driver.findElement(attributeStartsWith);

        By attributeEndsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('ame')+1)='ame']");
        driver.findElement(attributeEndsWith);

        By child = By.xpath("//div/child::ul");
        driver.findElement(child);

        By desc = By.xpath("//div/descendant::ul");
        driver.findElement(desc);

        By parent = By.xpath("//div/../..");
        driver.findElement(parent);

        By asc = By.xpath("//div/ancestor::*");
        driver.findElement(asc);

        By foll = By.xpath("//img/following::*");
        driver.findElement(foll);

        By follSibling = By.xpath("//img/following-sibling::*");
        driver.findElement(follSibling);

        By prec = By.xpath("//img/preceding::*");
        driver.findElement(prec);

        By precSibling = By.xpath("//img/preceding-sibling::*");
        driver.findElement(precSibling);

    }
}
