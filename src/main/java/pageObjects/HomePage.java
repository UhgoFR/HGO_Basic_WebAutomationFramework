package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class HomePage extends TestBase {
    //Only page objects + respective methods
    //page object factory

    @FindBy(id = "nav_automobile")
    WebElement link_automobile;

    @FindBy(id = "nav_truck")
    WebElement link_truck;

    @FindBy(id = "nav_motorcycle")
    WebElement link_motorcycle;

    @FindBy(id = "nav_camper")
    WebElement link_camper;

    //Constructor to use init element method
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public void clickOnMotorcycleLink(){
        link_motorcycle.click();
    }

}
