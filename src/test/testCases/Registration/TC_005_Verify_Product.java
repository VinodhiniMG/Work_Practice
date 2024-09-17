package Registration;

import Baseclasses.BaseClass;
import ExtentReports.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageclass.*;

@Listeners({ExtentReportManager.class})
public class TC_005_Verify_Product extends BaseClass {
    @Test(groups = {"Regression","Master"})
    public void verifyproductdetail(){
        hp= new Homepage(driver);
        hp.clicklogin();

        sp= new Signuppage(driver);
        Assert.assertEquals(sp.Logintext(),p.getProperty("logintext"));
        sp.enterloginemail(p.getProperty("email"));
        sp.Enterpassword(p.getProperty("password"));
        sp.clickLogin();

        lp = new LoggedInPage(driver);
        lp.checkloggedinuser();
        lp.clickproduct();
        pp= new ProductPage(driver);
        Assert.assertEquals(pp.producttxt(),p.getProperty("producttxt"));
        pp.viewproduct();


        vp=new ViewProductPage(driver);
        System.out.println("ProductName:"+vp.getproductname());
        System.out.println("Product Category:"+vp.getCategory());
        System.out.println("ProductPrice:"+vp.getprice());
        System.out.println("Product Availability:"+vp.getavail());
        System.out.println("Product Condition:"+vp.getcondition());
        System.out.println("Product Brand:"+vp.getbrand());



    }
}
