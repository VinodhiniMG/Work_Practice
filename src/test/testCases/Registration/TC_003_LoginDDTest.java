package Registration;

import Baseclasses.BaseClass;
import DataProviderUtility.Dataproviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageclass.Homepage;
import pageclass.LoggedInPage;
import pageclass.Signuppage;

public class TC_003_LoginDDTest extends BaseClass {
    @Test(dataProvider = "logindata", dataProviderClass = Dataproviders.class)
    public void VerifyloginDDT(String email, String password,String exp){

        try {
            hp = new Homepage(driver);
            hp.clicklogin();

            sp = new Signuppage(driver);
            Assert.assertEquals(sp.Logintext(), p.getProperty("logintext"));
            sp.enterloginemail(email);
            sp.Enterpassword(password);
            sp.clickLogin();

            lp = new LoggedInPage(driver);
            boolean targetpage = lp.islogoutdisplayed();
            System.out.println("the targetpage is displayed or not:"+targetpage);
            if (exp.equalsIgnoreCase("Valid")) {
                if (targetpage == true) {
                    Assert.assertEquals(lp.checkloggedinuser(), p.getProperty("loggedinuser"));
                    lp.logout();
                    Assert.assertTrue(true, "Login success");
                    Assert.assertEquals(sp.signuptext(), "New User Signup!");
                    Assert.assertEquals(sp.Logintext(), p.getProperty("logintext"));
                } else {
                    Assert.assertTrue(false);
                }

            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetpage == true) {
                    Assert.assertTrue(false, "Login should not be success");

                } else {
                    Assert.assertEquals(hp.loginShouldFail(),p.getProperty("invaliduser"));
                    Assert.assertEquals(sp.signuptext(), "New User Signup!");
                    Assert.assertEquals(sp.Logintext(), p.getProperty("logintext"));
                    Assert.assertTrue(true, "Login is failed as expected");
                }

            }
        }
        catch (Exception e){
            Assert.fail();
        }



    }
}
