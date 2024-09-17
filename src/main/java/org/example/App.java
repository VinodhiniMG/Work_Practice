package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
@Test
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
      //  System.out.println( "Hello World!" );
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
       //driver.findElement(By.id("APjFqb")).sendKeys("amazon");
        driver.close();
    }
}
