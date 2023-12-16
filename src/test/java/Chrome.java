import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends ChromeDriver implements Driver{
    public static final String PATH = "D:\\chromedriver-win64";

    @Override
    public void Setproperty() {
        System.setProperty("webdriver.chrome.driver",Chrome.PATH);

    }
    Chrome(){
        Setproperty();
    }
}
