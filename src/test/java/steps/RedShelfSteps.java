package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.RedShelfAddToCartPage;
import pages.RedShelfCartPage;
import pages.RedShelfMainPage;
import pages.RedShelfSearchResultPage;
import utilities.ConfigReader;
import utilities.Driver;

public class RedShelfSteps {

    WebDriver driver = Driver.getDriver();

    RedShelfMainPage redShelfMainPage = new RedShelfMainPage();
    RedShelfSearchResultPage redShelfSearchResultPage = new RedShelfSearchResultPage();
    RedShelfAddToCartPage redShelfAddToCartPage = new RedShelfAddToCartPage();
    RedShelfCartPage redShelfCartPage = new RedShelfCartPage();

    public String bookISBN;
    private static final String IN_CART = "IN CART";
    //private  static String emptyCart = "Your Cart is Empty";
   // public static String emptyCartButton;

    @When("user searches {string} book")
    public void user_searches_book(String book) throws InterruptedException {
        redShelfMainPage.searchCatalog.sendKeys("Purple Cow" + Keys.ENTER);

    }

    @When("user choose first book in search result")
    public void user_choose_first_book_in_search_result(){
        redShelfSearchResultPage.books.get(0).click();

    }

    @When("user clicks on Add To Cart button")
    public void user_clicks_on_add_to_cart_button() {
        redShelfAddToCartPage.addToCartBtn.click();

    }

    @Then("user clicks on view cart button and validates book is in cart")
    public void user_clicks_on_view_cart_button_and_validates_book_is_in_cart() throws InterruptedException {
        //redShelfAddToCartPage.viewCartBtn.click();
        //Thread.sleep(7000);
        //expected=redShelfCartPage.expectedBookTitle.getText();
        //System.out.println(expected);
        //actual=redShelfCartPage.actualBookTitle.getText();
        Assert.assertEquals(redShelfAddToCartPage.inCartLabel.getText(), IN_CART);

    }

    @When("user searches “Java data structure” book")
    public void user_searches_java_data_structure_book() {

        redShelfMainPage.searchCatalog.sendKeys("Java data stracture" + Keys.ENTER);
    }


    @Then("user validates first result page having no more than {int} books.")
    public void user_validates_first_result_page_having_no_more_than_books(Integer amount) {

        Assert.assertTrue(redShelfSearchResultPage.books.size() <= amount);

    }

    @When("user click on Add To Cart button")
    public void user_click_on_add_to_cart_button() {
        redShelfAddToCartPage.addToCartBtn.click();

    }

    @When("user clicks on empty cart button")
    public void user_clicks_on_empty_cart_button(String emptyCart) throws InterruptedException {
        redShelfAddToCartPage.viewCartBtn.click();
        redShelfCartPage.emptyCartBtn.click();

    }

    @Then("user validates “Your Cart is Empty“ message")
    public void user_validates_your_cart_is_empty_message(String message) {
        String emptyCart = redShelfCartPage.cartIsEmptyMessage.getText();
        String expected = "Your Cart is Empty";
        Assert.assertEquals(expected,emptyCart);
    }


    @When("user clicks on {string} and stores ISBN number")
    public void userClicksOnAndStoresISBNNumber(String arg0) {
        redShelfMainPage.searchCatalog.sendKeys("Purple Cow"+Keys.ENTER);
        redShelfSearchResultPage.books.get(0).click();
        bookISBN = redShelfAddToCartPage.bookSbnNum.getText();
        System.out.println(bookISBN);

    }
    @When("user search for a book with stored ISBN number")
        public void userSearchForABookWithStoredISBNNumber() {
            redShelfAddToCartPage.searchBtn.sendKeys(bookISBN+ Keys.ENTER);

    }

    @Then("user validates that search result has book")
    public void userValidatesThatSearchResultHasBook() {
        String expectedMess= "Purple Cow, New Edition";
        String actual = redShelfAddToCartPage.bookTitle.getText();
        System.out.println(actual);
        Assert.assertEquals(expectedMess,actual);

    }
}