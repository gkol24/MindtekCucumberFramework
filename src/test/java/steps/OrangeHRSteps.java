package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.Driver;

public class OrangeHRSteps {
    WebDriver driver = Driver.getDriver();
    OrangeHRLoginPage orangeHRLoginPage = new OrangeHRLoginPage();
    OrangeHRMainPage orangeHRMainPage=new OrangeHRMainPage();
    OrangeHRAddEmployeePage orangeHRAddEmployeePage=new OrangeHRAddEmployeePage();
    OrangeHRAddUserPage orangeHRAddUserPage=new OrangeHRAddUserPage();
    OrangeHRPIMPage orangeHRPIMPage=new OrangeHRPIMPage();

    @When("user enters username1 {string} and password1 {string} and clicks on login button1")
    public void user_enters_username1_and_password1_and_clicks_on_login_button1(String username, String password) {

            orangeHRLoginPage.username1.sendKeys(username);
            orangeHRLoginPage.password1.sendKeys(password);
            orangeHRLoginPage.loginBtn1.click();
            orangeHRMainPage.AdminBtn.click();
            orangeHRMainPage.AddBtn.click();
            orangeHRAddEmployeePage.FirstName.sendKeys("Oliver");
            orangeHRAddEmployeePage.MiddleName.sendKeys("Max");
            orangeHRAddEmployeePage.LastName.sendKeys("Nowak");
            orangeHRAddEmployeePage.EmployeeID.sendKeys("1001");
            orangeHRAddEmployeePage.SubmitBtn.click();
            orangeHRPIMPage.SubmitBtn.click();



    }
    @When("user click on Admin selection")
    public void user_click_on_admin_selection() {
        orangeHRMainPage.AdminBtn.click();
        orangeHRMainPage.AddBtn.click();

        Select select1=new Select(orangeHRAddUserPage.UserRoleDropdown);
        select1.selectByVisibleText("Admin");

        orangeHRAddUserPage.EmployeeName.sendKeys("Oliver Max Nowak");

        Select select2=new Select(orangeHRAddUserPage.StatusDropdown);
        select2.selectByVisibleText("Enabled");

        orangeHRAddUserPage.Username.sendKeys("OMNowak1001!");
        orangeHRAddUserPage.Password.sendKeys("Max1234!");
        orangeHRAddUserPage.ConfirmPassword.sendKeys("Max1234!");
        orangeHRAddUserPage.SubmitBtn.click();

    }
    @When("user click on Add button")
    public void user_click_on_add_button() {
        orangeHRMainPage.AddBtn.click();
    }

    }