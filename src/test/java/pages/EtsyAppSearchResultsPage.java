package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAppSearchResultsPage {
    public EtsyAppSearchResultsPage(){
    WebDriver driver= Driver.getDriver();
    PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//div/ol/li/div/div/a/div[2]/h3")
    public List<WebElement> listOfItemsTitles;

    @FindBy(xpath = "//span[@class='wt-hide-xs wt-show-md filter-expander']")
    public WebElement filterBtn;

    @FindBy(xpath = "//label[contains(text(), 'Over $1,500')]")
    public WebElement filterRadioBtnOver1500;

    @FindBy(xpath = "//label[contains(text(), 'Under $250')]")
    public WebElement filterRadioBtnUnder250;

    @FindBy(xpath = "//label[contains(text(), '$250 to $750')]")
    public WebElement filterRadioBtn250to750;

    @FindBy(xpath = "//label[contains(text(), '$500 to $1,000')]")
    public WebElement filterRadioBtn500to1000;


    @FindBy(xpath = " //button[contains(text(), 'Apply')]")
    public WebElement applyBtn;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-mt-xs-o']//p[1]//span[@class='currency-value']")
    //@FindBy(xpath = "//p[@class='wt-text-title-01 lc-price']")
    public List<WebElement> listOfItemPrices;


}
