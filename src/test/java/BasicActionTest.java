import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionTest {
    @Test
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();
//        WebElement button = driver.findElement(By.id("clickOnMe"));
//        button.click();
        WebElement inputArea = driver.findElement(By.id("fname"));
        inputArea.sendKeys("Blablabla");
        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("Admin");
//        username.sendKeys(Keys.ENTER);

        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        checkbox.click();
        checkbox.click();
        WebElement radioMale = driver.findElement(By.cssSelector("[value='male']"));
        radioMale.click();
        WebElement radioFemale = driver.findElement(By.cssSelector("[value='female']"));
        radioFemale.click();
        Assert.assertFalse(radioMale.isSelected());

        WebElement select = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(select);
        cars.selectByIndex(2);
        cars.selectByVisibleText("Audi");
        cars.selectByValue("volvo");
        List<WebElement> carsAll=cars.getOptions();
        List<WebElement> carsAllSelectedOptions=cars.getAllSelectedOptions();
        for(WebElement car:carsAll){
            System.out.println(car.getText());
        }
        for (WebElement car:carsAllSelectedOptions){
            System.out.println(car.getText());
        }
    }
}
