package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHRMainPage {
    public OrangeHRMainPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="(//a[@class='oxd-main-menu-item'])[1]" )
    public WebElement AdminBtn;



    @FindBy(xpath = "(//a[@class='oxd-main-menu-item'])[2]")
    public WebElement PiMBtn;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement AddBtn;

    }

    //@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    //public WebElement AddBtn;

