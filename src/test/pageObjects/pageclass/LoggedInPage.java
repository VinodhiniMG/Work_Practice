package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPage extends Basepage{
    public WebDriver driver;
    public LoggedInPage(WebDriver driver){
        this.driver=driver;
    }

    public String checkloggedinuser(){
        String loggeduser=driver.findElement(By.xpath(properties.getProperty("LoggedInuser"))).getText();
        String[] logintext = loggeduser.split(" ");
        String exptext = "";
        for (int i = 0; i < logintext.length - 1; i++) {
            exptext = exptext + logintext[i] + " ";
        }
        String exptext1 = exptext.trim();
        System.out.println(loggeduser);
        System.out.println("The expected text to compare is" + exptext1);
        return exptext1;
    }
    public boolean islogoutdisplayed(){
        try {
            boolean logoutele = driver.findElement(By.xpath(properties.getProperty("logout_ex"))).isDisplayed();
            return logoutele;
        }
        catch (Exception e){
            return false;
        }
    }
    public void logout(){
        driver.findElement(By.xpath(properties.getProperty("logout"))).click();
    }
    public void clickproduct(){
      driver.findElement(By.xpath(properties.getProperty("product"))).click();
    }
}
