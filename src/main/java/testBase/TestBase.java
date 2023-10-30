package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.*;
import reusableComponents.PropertiesOperations;

import java.util.concurrent.TimeUnit;

public class TestBase extends ObjectRepo {



    public void launchBrowserAndNavigate() throws Exception {
        String browser = PropertiesOperations.getPropertyValueByKey("browser");
        String url = PropertiesOperations.getPropertyValueByKey("url");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        launchBrowserAndNavigate();
        homePage = new HomePage();
        enterVehicleDataPage = new EnterVehicleDataPage();
        enterInsuranceDataPage = new EnterInsuranceDataPage();
        enterProductDataPage = new EnterProductDataPage();
        selectPriceOptionPage = new SelectPriceOptionPage();
    }
    @AfterMethod
    public void clenUpMethod(){
       driver.quit();
    }
}
