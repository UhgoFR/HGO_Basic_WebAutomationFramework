package insuranceCalculation_Motorcicle;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErrorTest_Motorcycle extends TestBase {

    @Test (enabled = false)
    public void errorMessage_CylinderCapacityField(){
        homePage.clickOnMotorcycleLink();
        enterVehicleDataPage.enterCylinderCapacity("3333");
        String actualErrorMsg = enterVehicleDataPage.getErrorMessageOnCylinderCapacity();
        String expectedErrorMsg = "Must be a number between 1 and 2000";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Cyclinder capacity field error message not as expected");
    }
    @Test(enabled = false)
    public void errorMessage_CylinderCapacityField_02(){
        homePage.clickOnMotorcycleLink();
        enterVehicleDataPage.enterCylinderCapacity("200");
        String actualErrorMsg = enterVehicleDataPage.getErrorMessageOnCylinderCapacity();
        String expectedErrorMsg = "Must be a number between 1 and 2000";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Cyclinder capacity field error message not as expected");
    }

    @Test (enabled = true)
    public void verifyModelDropDownOption() {
        homePage.clickOnMotorcycleLink();
        List<String> actualValues = enterVehicleDataPage.getDropDownOptions_Model();
        //test.log(Status.INFO, "Retrieved list content for Model drop down:  "+actualValues);
        List<String> expectedValues = Arrays.asList("– please select –", "Scooter", "Three-Wheeler", "Moped","Motorcycle");
        Assert.assertEquals(actualValues,expectedValues,"Error in drop down values comparison for Model field");
    }
}
