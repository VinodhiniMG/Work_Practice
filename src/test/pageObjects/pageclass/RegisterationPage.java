package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterationPage extends Basepage {
    public WebDriver driver;
    public RegisterationPage(WebDriver driver) {
        this.driver=driver;
    }

    public String verifyaccounttext(){

        String accounttxt=driver.findElement(By.xpath(properties.getProperty("Accounttext"))).getText();
        return accounttxt;
    }
    public void selectTitle(){

        driver.findElement(By.id(properties.getProperty("gender"))).click();
    }
    public String verifyname(){
        WebElement name=driver.findElement(By.name(properties.getProperty("username")));
        String actname= name.getAttribute("value");
        return actname;
    }
    public String getemailID(){
        String mailid=driver.findElement(By.name(properties.getProperty("emailaddress"))).getText();
        return mailid;
    }
    public boolean verifyemail(){
        boolean emailID= driver.findElement(By.name(properties.getProperty("emailaddress"))).isEnabled();
        if(!emailID){
            System.out.println("EmailID is disabled as expected");
        }
        return emailID;
    }

    public void enterPassword(String pass){
        driver.findElement(By.name(properties.getProperty("password"))).sendKeys(pass);
    }
    public void selectDay(){
        Select day = new Select(driver.findElement(By.id(properties.getProperty("Day"))));
        day.selectByValue("18");
    }
    public void selectMonth(){
        Select month = new Select(driver.findElement(By.id(properties.getProperty("Month"))));
        month.selectByVisibleText("July");
    }
    public void selectYear(){
        Select year = new Select(driver.findElement(By.id(properties.getProperty("Year"))));
        year.selectByIndex(12);
    }
    public String verifyaddresstxt(){
      String addresstxt=driver.findElement(By.xpath(properties.getProperty("Addresstxt"))).getText();
      return addresstxt;
    }
    public void enterfirstname(String fname){
     driver.findElement(By.name(properties.getProperty("firstname"))).sendKeys(fname);
    }
    public void enterlastname(String lname){
        driver.findElement(By.id(properties.getProperty("lastname"))).sendKeys(lname);
    }
    public void enterCompany(String comp){
        driver.findElement(By.id(properties.getProperty("Company"))).sendKeys(comp);
    }
    public void enterAddress(String addr){
      driver.findElement(By.name(properties.getProperty("address"))).sendKeys(addr);
    }
    public String verifyCountry(){
     String coun=driver.findElement(By.name(properties.getProperty("country"))).getText();
     System.out.println(coun);
     return coun;
    }
    public void enterState(String state){
     driver.findElement(By.name(properties.getProperty("state"))).sendKeys(state);
    }
    public void enterCity(String city){
     driver.findElement(By.name(properties.getProperty("City"))).sendKeys(city);
    }
    public void enterZipcode(String zip){
     driver.findElement(By.name(properties.getProperty("Zipcode"))).sendKeys(zip);
    }
    public void enterMobilenum(String number){
        driver.findElement(By.id(properties.getProperty("Mobile"))).sendKeys(number);
    }
    public void createbutton(){
        driver.findElement(By.xpath(properties.getProperty("createbtn"))).click();
    }
}

