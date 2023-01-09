package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RedShelfAddToCartPage {
    public RedShelfAddToCartPage() {

        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-role='offering-options-add-to-cart-button']")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//span[data-role='offering-in-cart']")
    public WebElement inCartLabel;

    @FindBy(xpath = "//button[@data-role='offering-options-view-cart-link']")
    public WebElement viewCartBtn;


    @FindBy(xpath = "//span[@data-role='product-isbns']")
    public WebElement bookSbnNum;

    @FindBy(xpath = "rs-input-input")
    public WebElement searchBtn;

    @FindBy(xpath = "//h1")
    public WebElement bookTitle;
}
