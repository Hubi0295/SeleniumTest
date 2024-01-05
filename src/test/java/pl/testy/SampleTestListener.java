package pl.testy;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am starting Test");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
    }
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = MemoryDriver.getActualDriver();
        TakesScreenshot take = (TakesScreenshot)driver;
        File file = take.getScreenshotAs(OutputType.FILE);
        String currentDateTime = new SimpleDateFormat("yyyy;MM;dd;;HH;mm;ss").format(new Date());
        String path = "src/test/resources/screen"+currentDateTime+".png";
        System.out.println(path);
        try {
            FileUtils.copyFile(file,new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("I am taking screenshot");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }
    @Override
    public void onStart(ITestContext context) {
    }
    @Override
    public void onFinish(ITestContext context) {
    }
}
