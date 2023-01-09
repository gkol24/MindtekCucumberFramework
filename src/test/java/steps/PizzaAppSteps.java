package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Map;

public class PizzaAppSteps {

    WebDriver driver= Driver.getDriver();
    PizzaAppPage pizzaAppPage = new PizzaAppPage();
    String price;

    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        Map<String,String> data = dataTable.asMap(String.class,String.class);
        for(String value: data.values()){
            System.out.println(value);
        }
        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizzaDropdown, data.get("Pizza"));//selecting value from the pizza dropdown
        BrowserUtils.selectDropdownByValue(pizzaAppPage.toppings1Dropdown, data.get("Topping1"));
        BrowserUtils.selectDropdownByValue(pizzaAppPage.toppings2Dropdown, data.get("Topping2"));
        pizzaAppPage.pizzaQtyBox.sendKeys(Keys.CONTROL+"A");
        pizzaAppPage.pizzaQtyBox.sendKeys(data.get("Quantity"));
        pizzaAppPage.nameBox.sendKeys(data.get("Name"));
        price=pizzaAppPage.pizzaCost.getAttribute("value");
        pizzaAppPage.emailBox.sendKeys(data.get("Email"));
        pizzaAppPage.phoneBox.sendKeys(data.get("Phone"));
        if(pizzaAppPage.paymentOption.equals(pizzaAppPage.cashPayment)) {
            pizzaAppPage.cashPayment.click();
        }else {
            pizzaAppPage.creditCard.click();
            pizzaAppPage.placeOrderBox.click();
        }
    }

    @Then("user validates that order is created with massage {string} {string}")
    public void user_validates_that_order_is_created_with_massage(String expectedMessage, String expectedMessage2) {

        String actualMessage= pizzaAppPage.dialogWindow.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage+price+" "+expectedMessage2, actualMessage);



    }

}

