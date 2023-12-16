import org.openqa.selenium.edge.EdgeDriver;

public class Edge extends EdgeDriver implements Driver{
    public static final String PATH = "C:\\Users\\Daniel\\Downloads\\IEDriverServer_x64_4.14.0\\IEDriverServer.exe";

    @Override
    public void Setproperty() {
        System.setProperty("webdriver.ie.driver",Edge.PATH);


    }
    Edge(){
        Setproperty();
    }
}
