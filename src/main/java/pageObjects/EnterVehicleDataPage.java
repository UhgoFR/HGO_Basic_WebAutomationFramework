package pageObjects;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import reusableComponents.CommonActions;
import testBase.TestBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnterVehicleDataPage extends TestBase {

    @FindBy(id ="make" )
    WebElement dd_make;

    @FindBy(id ="model" )
    WebElement dd_model;

    @FindBy(id ="cylindercapacity" )
    WebElement txt_cylinderCapacity;

    @FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
    WebElement error_cylinderCapacity;

    @FindBy(id ="engineperformance" )
    WebElement txt_enginePerformance;

    @FindBy(id ="dateofmanufacture" )
    WebElement txt_dateOfManufacture;

    @FindBy(xpath = "//select[@id='numberofseatsmotorcycle' or @id='numberofseats']")
    WebElement dd_numberOfSeats;

    @FindBy(id ="fuel" )
    WebElement dd_fuelType;

    @FindBy(id ="listprice" )
    WebElement txt_listPrice;

    @FindBy(id ="licenseplatenumber" )
    WebElement txt_licensePlateNumber;

    @FindBy(id ="annualmileage" )
    WebElement txt_annualMileage;

    @FindBy(id ="nextenterinsurantdata" )
    WebElement btn_next;


    public EnterVehicleDataPage (){
        PageFactory.initElements(driver, this);
    }

    public void enterCylinderCapacity(String value) {

        txt_cylinderCapacity.sendKeys(value);
        test.log(Status.PASS,"Cylinder capacity field is filled with: "+ value);
    }

    public String getErrorMessageOnCylinderCapacity(){
        return error_cylinderCapacity.getText();
    }

    public List<String> getDropDownOptions_Model(){
        return commonActions.getDropDownOptionsAsList(dd_model);
    }

    public void enterVehicleData(HashMap<String,String> testData) throws Exception {
        commonActions.selectByVisibleValue(dd_make,testData.get("Vehicle_Make"));
        commonActions.selectByVisibleValue(dd_model,testData.get("Vehicle_Model"));
        commonActions.enterText(txt_cylinderCapacity, testData.get("Vehicle_CylinderCapacity"));
        commonActions.enterText(txt_enginePerformance, testData.get("Vehicle_Enging_Performance"));
        commonActions.enterText(txt_dateOfManufacture,testData.get("Vehicle_Date_Manufacture"));
        commonActions.selectByVisibleValue(dd_numberOfSeats,testData.get("Vehicle_No_Seats_motorcycle"));
        commonActions.enterText(txt_listPrice, testData.get("Vehicle_List_Price"));
        commonActions.enterText(txt_annualMileage, testData.get("Vehicle_Annual_Mileage"));
    }

    public void clicNext(){
        btn_next.click();
    }
}
