package pageclass;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Basepage {
//    protected WebDriver driver;
//public  Basepage(WebDriver driver){
//      this.driver= driver;
//}


    Properties properties= new Properties();
      {
        try {
            properties.load(new FileInputStream("locator.properties"));

        } catch (IOException e) {
            e.getMessage();
        }
    }


}
