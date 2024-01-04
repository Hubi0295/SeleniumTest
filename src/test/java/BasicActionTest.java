import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
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
        System.out.println(username.getAttribute("value"));
        username.sendKeys(Keys.ENTER);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().alert().accept();


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
        System.out.println("Input your value here: ");
        String val = "Audi";
        for(WebElement car:carsAll){
            System.out.println(car.getText());
        }
        checkValuesOfSelect(carsAll,val);

        WebElement pararaphHidden = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println(pararaphHidden.getAttribute("textContent"));


    }
    @Test
    public void checkValuesOfSelect(List<WebElement> list,String s){
        boolean result=false;
        for(WebElement w:list){
            if(w.getText().equals(s)){
                result=true;
            }
        }
        System.out.println("Result of searching in select: "+result);
    }
}

