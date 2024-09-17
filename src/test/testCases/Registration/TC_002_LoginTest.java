package Registration;

import Baseclasses.BaseClass;
import ExtentReports.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageclass.Homepage;
import pageclass.LoggedInPage;
import pageclass.Signuppage;

@Listeners({ExtentReportManager.class})
@Test
public class TC_002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity"})
    public void loginuser(){
        hp= new Homepage(driver);
        hp.clicklogin();

        sp= new Signuppage(driver);
        Assert.assertEquals(sp.Logintext(),p.getProperty("logintext"));
        sp.enterloginemail(p.getProperty("email"));
        sp.Enterpassword(p.getProperty("password"));
        sp.clickLogin();

        lp = new LoggedInPage(driver);
        lp.checkloggedinuser();
        lp.logout();
        Assert.assertEquals(sp.signuptext(),"New User Signup!");
        Assert.assertEquals(sp.Logintext(),p.getProperty("logintext"));

    }
}
