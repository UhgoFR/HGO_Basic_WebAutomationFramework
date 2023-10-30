package insuranceCalculation_Motorcicle;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reusableComponents.ExcelOperations;
import testBase.TestBase;

import java.io.IOException;
import java.util.HashMap;


public class EndToEndTests_Motorcycle extends TestBase {

    ExcelOperations excel = new ExcelOperations("InsurancePremium");

    @Test (dataProvider = "vehData" )
    public void insuranceCalculate(Object obj1) throws Exception {

                                            //typecasting obj1
        HashMap<String, String> testData = (HashMap<String, String>) obj1;

        test.log(Status.INFO, "Test data:   "+testData);

        homePage.clickOnMotorcycleLink();
        enterVehicleDataPage.enterVehicleData(testData);
        enterVehicleDataPage.clicNext();
        enterInsuranceDataPage.enterInsuranceData(testData);
        enterInsuranceDataPage.clicNext();
        enterProductDataPage.enterProductData(testData);
        enterProductDataPage.clickNext();

        Assert.assertEquals(testData.get("PriceValidation_Gold"), selectPriceOptionPage.getPriceForPlan("Gold"), "Gold plan pricer not matched");
        Assert.assertEquals(testData.get("PriceValidation_Silver"), selectPriceOptionPage.getPriceForPlan("Silver"), "Silver plan pricer not matched");
        Assert.assertEquals(testData.get("PriceValidation_Platinum"), selectPriceOptionPage.getPriceForPlan("Platinum"), "Platinum plan pricer not matched");
        Assert.assertEquals(testData.get("PriceValidation_Ultimate"), selectPriceOptionPage.getPriceForPlan("Ultimate"), "Ultimate plan pricer not matched");

        selectPriceOptionPage.selectPlanOption(testData.get("SelectOption"));
        selectPriceOptionPage.clickNext();

    }

    //Dataprovider method --> return object array
    @DataProvider (name = "vehData")
    public Object[][] testDataSupplier() throws Exception {
        Object[][] obj = new Object[excel.getRowCount()][1];
        for (int i = 1; i <= excel.getRowCount(); i++) {
            HashMap<String, String> testData = excel.getTestDataInMap(i);
            obj[i-1][0] = testData;
        }
        return obj;
    }
}
