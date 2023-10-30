package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class SelectPriceOptionPage extends TestBase {

    @FindBy(id = "nextsendquote" )
    WebElement btn_next;

    public SelectPriceOptionPage(){
        PageFactory.initElements(driver,this);
    }

    public String getPriceForPlan(String plan){
        String xpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public void selectPlanOption(String plan){
        String xpath = "//input[@name='Select Option' and @value='"+plan+"']/parent::label";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickNext(){
        btn_next.click();
    }
}
