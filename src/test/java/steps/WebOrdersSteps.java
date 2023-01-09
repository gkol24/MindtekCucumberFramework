package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderModule;
import utilities.BrowserUtils;
import utilities.Driver;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class WebOrdersSteps {
    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrderLoginPage = new WebOrdersLoginPage();
    WebOrdersOrderModule webOrdersOrderModule = new WebOrdersOrderModule();
    WebOrdersHomePage webOrdersHomePage = new WebOrdersHomePage();


    @When("user enters username {string} and password {string} and clicks on login button")
    public void user_enters_username_and_password_and_clicks_on_login_button(String username, String password) {

        webOrderLoginPage.username.sendKeys(username);
        webOrderLoginPage.password.sendKeys(password);
        webOrderLoginPage.loginBtn.click();
    }


    @Then("user validates application is logged in")
    public void user_validates_application_is_logged_in() {
        String expected = "Web Orders";
        String actual = driver.getTitle();
        System.out.println(actual);
        Assert.assertEquals(expected, actual);


    }


    @Then("user validates an error message {string}")
    public void userValidatesAnErrorMessage(String errorMessage) {
        String actualErrorMessage = webOrderLoginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }


    @When("user clicks on Order module")
    public void user_clicks_on_order_module() {
        webOrdersHomePage.orderModule.click();


    }

    @When("user selects {string} with {int}")
    public void user_selects_with_quantity(String product, int quantity) {
        BrowserUtils.selectDropdownByValue(webOrdersOrderModule.productDropdown, product);
        webOrdersOrderModule.quantityBox.sendKeys(Keys.CONTROL + "A");
        webOrdersOrderModule.quantityBox.sendKeys(Keys.BACK_SPACE);
        webOrdersOrderModule.quantityBox.sendKeys(quantity + "" + Keys.ENTER);
    }

    @Then("user validates total is calculated properly for {int}")
    public void user_validates_total_is_calculated_properly_for_quantity(int quantity) {
        int expectedTotal = 0;
        String pricePerUnit = webOrdersOrderModule.priceBox.getAttribute("value");
        String discountAmount = webOrdersOrderModule.discountBox.getAttribute("value");

        int pricePerUnitInt = Integer.parseInt(pricePerUnit);
        int discountAmountInt = Integer.parseInt(discountAmount);

        if (discountAmountInt == 0) {
            expectedTotal = quantity * pricePerUnitInt;

        } else {
            expectedTotal = quantity * pricePerUnitInt;
            expectedTotal = expectedTotal - (expectedTotal - discountAmountInt / 100);
        }
        System.out.println(expectedTotal);
        String actualTotal = webOrdersOrderModule.totalBox.getAttribute("value");
        int actualTotalInt = Integer.parseInt(actualTotal);


    }

    @When("user creates order with data")
    public void user_creates_order_with_data(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
       // List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        //System.out.println(data.get(0).get("zip"));
        //System.out.println(data.get(1).get("zip"));
        //System.out.println(data.toString());
        Map<String,String> data=dataTable.asMap(String.class, String.class);
        System.out.println(data.toString());

        BrowserUtils.selectDropdownByValue(webOrdersOrderModule.productDropdown, data.get("product"));
        webOrdersOrderModule.quantityBox.sendKeys(data.get("quantity"));
        webOrdersOrderModule.nameBox.sendKeys(data.get("name"));
        webOrdersOrderModule.streetBox.sendKeys(data.get("street"));
        webOrdersOrderModule.cityBox.sendKeys(data.get("city"));
        webOrdersOrderModule.stateBox.sendKeys(data.get("state"));
        webOrdersOrderModule.zipBox.sendKeys(data.get("zip"));
        webOrdersOrderModule.visaRadioBtn.click();
        webOrdersOrderModule.ccBox.sendKeys(data.get("cc"));
        webOrdersOrderModule.expDateBox.sendKeys(data.get("expire date"));
        webOrdersOrderModule.processBtn.click();
    }

    @Then("user validates success message {string}")
    public void user_validates_success_message(String expectedMessage) {
        // Write code here that turns the phrase above into concrete actions
        String actualMessage= webOrdersOrderModule.successMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

}