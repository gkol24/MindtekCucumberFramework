package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

public class RedShelfCartPage {
    public RedShelfCartPage(){
        WebDriver driver = Driver.getDriver();
    }
    @FindBy(xpath = "//h1")
    public WebElement actualBookTitle;

    @FindBy(xpath ="//a[@class='title']")
    public WebElement expectedBookTitle;

    @FindBy(xpath = "//button[@class='btn btn-grey']")
    public WebElement emptyCartBtn;

    @FindBy(xpath = "//p[@class='subtotal-field']")
    public WebElement cartIsEmptyMessage;
}
