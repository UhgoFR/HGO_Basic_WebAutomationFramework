package reusableComponents;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static testBase.ObjectRepo.test;

public class CommonActions {
    public List<String> getDropDownOptionsAsList(WebElement element){
        Select os = new Select(element);
        List<WebElement> list_elements = os.getOptions();
        List<String> actualContents = new ArrayList<String>();
        for (WebElement ref:list_elements) {
            actualContents.add(ref.getText());
        }
       //test.log(Status.INFO,"Retrieve options from drop down: "+element.getAttribute("nane")+" Options: "+actualContents);
        return actualContents;
    }

    public void enterText(WebElement element, String textValue){
        element.clear();
        element.sendKeys(textValue);
        //test.log(Status.INFO,"Enter text: "+textValue+" On field:"+element.getAttribute("nane"));
    }

    public void selectByVisibleValue(WebElement element, String textValue) throws Exception {
        Select os = new Select(element);
        try{
            os.selectByVisibleText(textValue);
        }catch(Exception e){
            throw new Exception("Value is not present in drop down for element- unable to select value: "+textValue);
        }
       //test.log(Status.INFO,"Selected option: "+textValue+" On field:"+element.getAttribute("nane"));
    }

    public void selectRadioButtonOption(List<WebElement> element, String value){
        for (WebElement ref:element) {
            if (ref.getText().equalsIgnoreCase(value)){
                ref.click();
                break;
            }
        }
    }

    public void selectCheckBoxes(List<WebElement> element, String checks){
        String[] values = checks.split(",");
        for (String str:values) {
            for (WebElement ele:element) {
                if (ele.getText().equalsIgnoreCase(str)){
                    ele.click();
                    break;
                }
            }
        }

    }
}
