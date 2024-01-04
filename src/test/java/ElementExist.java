import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementExist {
    @Test
    public void elementExist(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        System.out.println(isElementExist(By.tagName("p"),driver));
        System.out.println(isElementExist(By.id("topSecret"),driver));

        System.out.println(driver.findElement(By.cssSelector("[name='fname']")).isDisplayed());
        System.out.println(driver.findElement(By.cssSelector("[id='clickOnMe']")).isEnabled());
        System.out.println(driver.findElement(By.cssSelector("[type='checkbox']")).isSelected());

        String height = driver.findElement(By.tagName("img")).getAttribute("naturalHeight");
        Assert.assertNotEquals("0",height);

    }
    public boolean isElementExist(By el,WebDriver driver){
        try{
            driver.findElement(el);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

}
