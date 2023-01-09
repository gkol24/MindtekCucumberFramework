package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHRAddUserPage {
    public OrangeHRAddUserPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
    public WebElement UserRoleDropdown;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
    public WebElement StatusDropdown;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-text-input--before']")
    public WebElement EmployeeName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement Username;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    public WebElement Password;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
    public WebElement ConfirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SubmitBtn;

}
