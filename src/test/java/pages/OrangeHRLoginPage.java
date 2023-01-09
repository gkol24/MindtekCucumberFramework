package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHRLoginPage {
    public OrangeHRLoginPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(name="username")
    public WebElement username1;
    @FindBy(name = "password")
    public WebElement password1;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn1;
}
