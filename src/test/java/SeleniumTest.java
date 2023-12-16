import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.Scanner;
public class SeleniumTest {

    public void OpenGooglePage(String browser){
        String address = "google.com/";
        try{
            WebDriver driver = getDriver(browser);
            driver.get("https://www."+address);
            driver.close();
        }
        catch (WrongBrowserException e){
            System.err.println(e.getMessage());
        }


    }

    public WebDriver getDriver(String driver) throws WrongBrowserException{
        driver = driver.toLowerCase();
        if(driver.equals("chrome")){
            return new Chrome();
        }
        else if(driver.equals("firefox")){
            return new Firefox();

        } else if (driver.equals("edge")) {
            return new Edge();

        }
        else{
            throw new WrongBrowserException("Wrong Browser name!");
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
