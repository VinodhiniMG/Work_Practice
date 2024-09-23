package Baseclasses;

import ExtentReports.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import pageclass.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

@Listeners({ExtentReportManager.class})
public class BaseClass  {
    public static RemoteWebDriver driver;
    public Homepage hp;
    public Signuppage sp;
    public RegisterationPage rp;
    public LoggedInPage lp;
    public ProductPage pp;
    public ViewProductPage vp;
    public Properties p;


  //  @BeforeMethod(groups = {"Sanity","Regression","Master"})
    @BeforeMethod
   @Parameters("browser")
 public void Setup(String browsertype) throws IOException {
       // WebDriverManager.chromedriver().setup();
      //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\vmg\\Work_Practice\\drivers");
        p= new Properties();
        FileInputStream fs= null;
        fs = new FileInputStream("config.properties");
        p.load(fs);

     //   driver= new ChromeDriver();
       switch (browsertype.toLowerCase()){
            case "chrome":  driver= new ChromeDriver(); break;
            case "edge": driver= new EdgeDriver(); break;
            case "firefox": driver= new FirefoxDriver();break;
            default: System.out.println("Invalid browser type"); return;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("url"));
        driver.manage().window().maximize();
    }

    public String randomstring(){
        String get_string= RandomStringUtils.randomAlphabetic(5);
        return get_string;
    }
    public String randomNumber(){
        String get_number= RandomStringUtils.randomNumeric(10);
        return get_number;
    }
    public String randomAlphaNumeric(){
        String get_string= RandomStringUtils.randomAlphabetic(4);
        String get_number=RandomStringUtils.randomNumeric(3);
        return (get_string+"@$"+get_number);
    }

    //@AfterMethod(groups = {"Sanity","Regression","Master"})
    @AfterMethod
    public void Tear_down(){
        driver.close();
    }
    public String captureScreen(String tname) throws IOException
    {
        String timestamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot ts= (TakesScreenshot) driver;
        File srcpath= ts.getScreenshotAs(OutputType.FILE);

        String targetfilepath=System.getProperty("user.dir")+"\\Screenshots\\"+tname+"_"+timestamp+".png";
        File targetfile= new File(targetfilepath);
        srcpath.renameTo(targetfile);
        return targetfilepath;

    }

}
