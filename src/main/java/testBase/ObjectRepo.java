package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import reusableComponents.CommonActions;

public class ObjectRepo {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static HomePage homePage;
    public static EnterVehicleDataPage enterVehicleDataPage;
    public static EnterInsuranceDataPage enterInsuranceDataPage;
    public static EnterProductDataPage enterProductDataPage;
    public static SelectPriceOptionPage selectPriceOptionPage;
    public CommonActions commonActions = new CommonActions();
}
