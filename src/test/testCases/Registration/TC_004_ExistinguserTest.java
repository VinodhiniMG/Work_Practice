package Registration;

import Baseclasses.BaseClass;
import ExtentReports.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageclass.Homepage;
import pageclass.Signuppage;

@Listeners({ExtentReportManager.class})
public class TC_004_ExistinguserTest extends BaseClass {

    @Test(groups = {"Sanity"})
    public void existuser(){
        hp= new Homepage(driver);
        hp.clicksignup();

        sp=new Signuppage(driver);
        Assert.assertEquals(sp.signuptext(),p.getProperty("signuptext"));
        sp.enterUsername(p.getProperty("username"));
        sp.enteremail(p.getProperty("email"));
        sp.clickSignup();
        Assert.assertEquals(sp.validateuser(),p.getProperty("existusertxt"),"Validtion success");
    }
}
