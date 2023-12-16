import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
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

        return switch (driver) {
            case "chrome" -> new Chrome();
            case "firefox" -> new Firefox();
            case "edge" -> new Edge();
            default -> throw new WrongBrowserException("Wrong Browser name!");
        };

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
