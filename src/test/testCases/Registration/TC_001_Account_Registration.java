package Registration;

import Baseclasses.BaseClass;
import ExtentReports.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageclass.Homepage;
import pageclass.RegisterationPage;
import pageclass.Signuppage;

import java.io.FileWriter;
import java.io.IOException;

@Listeners({ExtentReportManager.class})
public class TC_001_Account_Registration extends BaseClass {

@Test(groups = {"Regression","Master"})
  public void Create_account() throws IOException {

      hp= new Homepage(driver);
      hp.clicksignup();

       sp= new Signuppage(driver);
      String username=randomstring().toUpperCase();
      String emailID=randomstring()+"@gmail.com";
      Assert.assertEquals(sp.signuptext(),"New User Signup!");
      sp.enterUsername(username);
      sp.enteremail(emailID);
      sp.clickSignup();

       rp = new RegisterationPage(driver);
      Assert.assertEquals(rp.verifyaccounttext(),"ENTER ACCOUNT INFORMATION");
      rp.selectTitle();
      Assert.assertEquals(rp.verifyname(),sp.getusername());
      Assert.assertEquals(rp.verifyemail(),false);
      String password=randomAlphaNumeric();
      rp.enterPassword(password);
      rp.selectDay();
      rp.selectMonth();
      rp.selectYear();
      Assert.assertEquals(rp.verifyaddresstxt(),"ADDRESS INFORMATION");
      rp.enterfirstname(randomstring().toUpperCase());
      rp.enterlastname(randomstring());
      rp.enterCompany("EY");
      rp.enterAddress(randomstring()+"Dr.no:2/9");
    //  Assert.assertEquals(rp.verifyCountry(),"India");
      rp.enterState("Telangana");
      rp.enterCity("Hyderabad");
      rp.enterZipcode("12356");
      rp.enterMobilenum(randomNumber());
      rp.createbutton();
      String text= username+", "+emailID+", "+password;
    FileWriter fWriter = new FileWriter(
            "demo.txt");


    fWriter.write(text);

    // Printing the contents of a file
    System.out.println(text);

    // Closing the file writing connection
    fWriter.close();
    }



}
