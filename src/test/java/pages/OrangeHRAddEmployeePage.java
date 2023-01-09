package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHRAddEmployeePage {
    public OrangeHRAddEmployeePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(name = "firstName")
    public WebElement FirstName;

    @FindBy(name="middleName")
    public WebElement MiddleName;

    @FindBy(name="lastName")
    public WebElement LastName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[1]")
    public WebElement EmployeeID;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SubmitBtn;
}
