package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewProductPage extends Basepage{
    public WebDriver driver;
    public ViewProductPage(WebDriver driver){
        this.driver=driver;
    }
    public String getproductname(){
        String getname=driver.findElement(By.xpath(properties.getProperty("product_name"))).getText();
        return getname;
    }
    public String getCategory(){
        String cat= driver.findElement(By.xpath(properties.getProperty("prod_category"))).getText();
        return cat;
    }
    public String getavail(){
        String avail= driver.findElement(By.xpath(properties.getProperty("prod_avail"))).getText();
        return avail;
    }
    public String getprice(){
        String price=driver.findElement(By.xpath(properties.getProperty("prod_cost"))).getText();
        return price;
    }
    public String getcondition(){
        String con= driver.findElement(By.xpath(properties.getProperty("prod_condtn"))).getText();
        return con;
    }
    public String getbrand(){
        String brand=driver.findElement(By.xpath(properties.getProperty("prod_brand"))).getText();
        return brand;
    }
}
