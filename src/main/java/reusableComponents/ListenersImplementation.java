package reusableComponents;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.ObjectRepo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenersImplementation extends ObjectRepo implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        //before each test case
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+" is PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+" is FAILED");
        test.log(Status.FAIL,result.getThrowable());
       //add screenshot for failed test
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);
        String screenshotPath = System.getProperty("user.dir")+"/reports/screenshots/Screenshot_"+actualDate+".jpeg";
        File dest =new File(screenshotPath);
        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(screenshotPath,"Test Case Failure Screenshot");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        //set up method call
       extent =  ExtentSetUp.setupExtentReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        //close extent
        extent.flush();
    }
}
