import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends ChromeDriver implements Driver{
    public static final String PATH = "C:\\Users\\Daniel\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";

    @Override
    public void Setproperty() {
        System.setProperty("webdriver.chrome.driver",Chrome.PATH);

    }
    Chrome(){
        Setproperty();
    }
}
