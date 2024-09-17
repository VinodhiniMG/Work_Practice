package pageclass;

import Baseclasses.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Basepage {
  public WebDriver driver;
  public ProductPage(WebDriver driver){
      this.driver=driver;
  }
    public String producttxt(){
        String prdtxt= driver.findElement(By.xpath(properties.getProperty("producttxt"))).getText();
        System.out.println(prdtxt);
        return prdtxt;
    }
    public void viewproduct(){
      driver.findElement(By.xpath(properties.getProperty("viewproduct"))).click();
    }
}
