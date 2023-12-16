import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends FirefoxDriver implements Driver{
    public static final String PATH = "D:\\geckodriver-v0.33.0-win64";

    @Override
    public void Setproperty() {
        System.setProperty("webdriver.gecko.driver",Firefox.PATH);

    }
    Firefox(){
        Setproperty();
    }
}
