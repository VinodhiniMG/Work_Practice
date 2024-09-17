package ExtentReports;

import Baseclasses.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ExtentReportManager implements ITestListener, ISuiteListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;

    @Override
    public void onStart(ITestContext testContext) {
        System.out.println("ONtestmethod");
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.MM.hh.ss").format(new Date());
        repName = "Test-Reports-" + timestamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

        sparkReporter.config().setDocumentTitle("Automation Exercise");
        sparkReporter.config().setReportName("Automation functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Automation-Exercise");
        extent.setSystemInfo("Module", "Newuser");
        extent.setSystemInfo("Submodule", "Customers");
        extent.setSystemInfo("username", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        List<String> includedgroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedgroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedgroups.toString());
        }
    }
    @Override
        public void onTestSuccess(ITestResult result){
        System.out.println("ONtestsuccess");
            test= extent.createTest(result.getTestClass().getName());
            test.assignCategory(result.getMethod().getGroups());
            test.log(Status.PASS,result.getName()+"got successfully executed");
        }
        public void onTestFailure(ITestResult result){
            System.out.println("ONtestfailure");
        test= extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL,result.getName()+"got failed");
        test.log(Status.INFO,result.getThrowable().getMessage());

            try {
                String imgpath = new BaseClass().captureScreen(result.getName());
                test.addScreenCaptureFromPath(imgpath);
            } catch (IOException e1) {
               e1.printStackTrace();
            }

        }
        @Override
        public void onTestSkipped(ITestResult result){
            System.out.println("ONTestSkipped");
        test= extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP,result.getName()+"got skipped");
        test.log(Status.INFO,result.getThrowable().getMessage());
        }
        @Override
    public void onFinish(ITestContext testContext){
        System.out.println("ONFinish");
        extent.flush();
        String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
        System.out.println("the path of the file:"+pathOfExtentReport);
        File extentreport= new File(pathOfExtentReport);

        try{
            Desktop.getDesktop().browse(extentreport.toURI());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    }

