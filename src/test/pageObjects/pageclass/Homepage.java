package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage extends Basepage {
    public WebDriver driver;
    public Homepage(WebDriver driver) {
        this.driver=driver;
    }

public void clicklogin(){
        driver.findElement(By.xpath(properties.getProperty("signuplink"))).click();
}

    public void clicksignup(){
        driver.findElement(By.xpath(properties.getProperty("signuplink"))).click();
    }
    public String loginShouldFail() {
        String invaliduser = driver.findElement(By.xpath(properties.getProperty("invaliduser"))).getText();
      return invaliduser;
    }
}
