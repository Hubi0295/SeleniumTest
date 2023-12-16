import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public void OpenGooglePage(String browser){
        browser = browser.toLowerCase();
        String address = "google.com/";
        try{
            WebDriver driver = WebDriverManagerTest.getDriver(browser);
            driver.manage().window().maximize();
            driver.get("https://www."+address);
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
//            ((JavascriptExecutor)driver).executeScript("window.open('https://www.flashscore.pl/zawodnik/lewandowski-robert/MVC8zHZD/','blank','height=200','width=300')");
//            ((JavascriptExecutor)driver).executeScript("alert('Hej')");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
            agreeButton.click();
            WebElement searchField = driver.findElement(By.name("q"));
            searchField.sendKeys("never gonna give you up");
            searchField.sendKeys(Keys.ENTER);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement searchField1 = driver.findElement(By.xpath("//a[contains(@href,'youtube.com')]//h3"));
            searchField1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement result = driver.findElement(By.xpath("//button[contains(@aria-label, 'Zaakceptuj wykorzystywanie plików cookie i innych danych do opisanych celów')]"));
            result.click();
            Assert.assertTrue(result.isDisplayed());
            driver.quit();
        }
        catch (WrongBrowserException e){
            System.err.println(e.getMessage());
        }


    }
    @Test
    public void ChromeGooglePage(){
        OpenGooglePage("chrome");
    }
    @Test
    public void FirefoxGooglePage(){
        OpenGooglePage("firefox");
    }
    @Test
    public void EdgeGooglePage(){
        OpenGooglePage("Edge");
    }
    @Test
    public void WrongBrowserGooglePage(){
        OpenGooglePage("Edde");
    }
}
