package pl.testy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FourthTest {
    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest(){
        System.out.println("I am first");
    }
    @Test(dependsOnMethods = {"thirdTest"})
    public void secondTest(){
        System.out.println("I am second");

    }
    @Test()
    public void thirdTest(){
        System.out.println("I am third");
    }
    @Test(dataProvider = "data")
    public void dpTest(String val, String val2){
        System.out.println(val+val2);
    }
    @DataProvider(name="data")
    public Object[][] dataProvider(){
        return new Object[][]{{"I am first","First"},{"I am second test","Second"},{"I am third test","Third"},{"I am fourth test","Fourth"}};

    }
}
