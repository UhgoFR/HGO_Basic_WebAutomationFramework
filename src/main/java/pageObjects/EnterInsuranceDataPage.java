package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

import java.util.HashMap;
import java.util.List;

public class EnterInsuranceDataPage extends TestBase {

    @FindBy(id = "firstname" )
    WebElement txt_firstName;

    @FindBy(id = "lastname" )
    WebElement txt_lastName;

    @FindBy(id = "birthdate" )
    WebElement txt_birthDate;

    @FindBy (xpath = "//input[@name='Gender']/parent::label")
    List<WebElement> rdo_gender;

    @FindBy(id = "streetaddress" )
    WebElement txt_streetAddress;

    @FindBy(id = "country" )
    WebElement dd_country;

    @FindBy(id = "zipcode" )
    WebElement txt_zipcode;

    @FindBy(id = "city" )
    WebElement txt_city;

    @FindBy(id = "occupation" )
    WebElement dd_occupation;

    @FindBy (xpath = "//input[@name='Hobbies']/parent::label")
    List<WebElement> rdo_hobbies;

    @FindBy(id = "website" )
    WebElement txt_website;

    @FindBy(id = "nextenterproductdata" )
    WebElement btn_next;

    @FindBy(id = "preventervehicledata" )
    WebElement btn_prev;

    public EnterInsuranceDataPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterInsuranceData(HashMap<String,String> testData) throws Exception {
        commonActions.enterText(txt_firstName, testData.get("Insurant_FirstName"));
        commonActions.enterText(txt_lastName, testData.get("Insurant_LastName"));
        commonActions.enterText(txt_birthDate, testData.get("Insurant_birthdate"));
        commonActions.selectRadioButtonOption(rdo_gender, testData.get("Insurant_gender"));
        commonActions.enterText(txt_streetAddress,testData.get("Insurant_StreetAddress"));
        commonActions.selectByVisibleValue(dd_country, testData.get("Insurant_country"));
        commonActions.enterText(txt_zipcode,testData.get("Insurant_zipcode"));
        commonActions.enterText(txt_city,testData.get("Insurant_city"));
        commonActions.selectByVisibleValue(dd_occupation, testData.get("Insurant_occupation"));
        commonActions.selectCheckBoxes(rdo_hobbies, testData.get("Insurant_Hobby"));

    }

    public void clicNext(){
        btn_next.click();
    }
}
