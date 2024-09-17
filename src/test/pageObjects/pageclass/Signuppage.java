package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signuppage extends Basepage{
    protected WebDriver driver;
    public String emailId;
    public Signuppage(WebDriver driver) {
        this.driver=driver;

    }

    //signuppage
    public String signuptext(){
        try {
            String signtext = driver.findElement(By.xpath(properties.getProperty("signuptext"))).getText();
            return signtext;
        } catch (Exception e) {
            return(e.getMessage());
        }

    }
    public void enterUsername(String name){
     driver.findElement(By.name(properties.getProperty("username"))).sendKeys(name);
    }
    //to use this method in registeration page
    public String getusername(){
        String user=driver.findElement(By.name(properties.getProperty("username"))).getAttribute("value");
        return user;
    }
    public void enteremail(String email){
        driver.findElement(By.xpath(properties.getProperty("signupemail"))).sendKeys(email);
    }

    public void clickSignup(){

        driver.findElement(By.xpath(properties.getProperty("signupbtn"))).click();
    }
    public String validateuser(){
        String validuser= driver.findElement(By.xpath(properties.getProperty("existemail"))).getText();
        return validuser;
    }

    //Loginpage
    public String Logintext(){
        try {
            String logintxt = driver.findElement(By.xpath(properties.getProperty("logintext"))).getText();
            return logintxt;
        }catch(Exception e){
            return (e.getMessage());
        }
    }
    public void enterloginemail(String emailId){
        driver.findElement(By.xpath(properties.getProperty("loginemail"))).sendKeys(emailId);
    }
    public void Enterpassword(String pass){
        driver.findElement(By.name(properties.getProperty("password"))).sendKeys(pass);
    }
    public void clickLogin(){

        driver.findElement(By.xpath(properties.getProperty("loginbtn"))).click();
    }
}
