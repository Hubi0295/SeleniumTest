import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends FirefoxDriver implements Driver{
    public static final String PATH = "C:\\Users\\Daniel\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe";

    @Override
    public void Setproperty() {
        System.setProperty("webdriver.gecko.driver",Firefox.PATH);

    }
    Firefox(){
        Setproperty();
    }
}
