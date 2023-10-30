package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

import java.util.HashMap;
import java.util.List;

public class EnterProductDataPage extends TestBase {

    @FindBy(id = "startdate")
    WebElement txt_startDate;

    @FindBy(id = "insurancesum")
    WebElement dd_insuranceSum;

    @FindBy(id = "meritrating")
    WebElement dd_meritRating;

    @FindBy(id = "damageinsurance")
    WebElement dd_damageInsurance;

    @FindBy (xpath = "//input[@name='Optional Products[]']/parent::label")
    List<WebElement> rdo_optionlaProducts;

    @FindBy(id = "courtesycar")
    WebElement dd_courtesyCar;

    @FindBy(id = "nextselectpriceoption")
    WebElement btn_next;

    @FindBy(id = "preventerinsurancedata")
    WebElement btn_prev;

    public EnterProductDataPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterProductData(HashMap<String,String> testData) throws Exception {
        commonActions.enterText(txt_startDate,testData.get("Product_startdate"));
        commonActions.selectByVisibleValue(dd_insuranceSum,testData.get("Product_insurancesum"));
        commonActions.selectByVisibleValue(dd_damageInsurance,testData.get("Product_damageinsurance"));
        commonActions.selectCheckBoxes(rdo_optionlaProducts,testData.get("Product_OptionalProducts"));
    }

    public void clickNext(){
        btn_next.click();
    }
}
