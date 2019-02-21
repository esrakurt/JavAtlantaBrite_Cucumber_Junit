package com.cybertek.step_definitions;

import com.cybertek.pages.CRMUserCustomersPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class CRMUserCustomersTestSteps {
    LoginPage loginPage=new LoginPage();
    WebDriver driver= Driver.getDriver();
    CRMUserCustomersPage crmUserCustP=new CRMUserCustomersPage();

    @Given("User on the login page")
    public void user_on_the_login_page() {
        driver.get(ConfigurationReader.getProperty("url"));

    }
    @When("User selects BriteERPDemo")
    public void user_selects_BriteERPDemo() {
        loginPage.BriteErpDemo.click();
    }
    @Then("User logs in using {string} and {string}")
    public void user_logs_in_using_and(String usr, String pass) {
        loginPage.login("eventsCRM_User@info.com", "opJu56KKL39");
    }

    @Then("User clicks on CRM module")
    public void user_clicks_on_CRM_module() {
        loginPage.clickCRModule();
    }

    @Given("User on the CRM module")
    public void user_on_the_CRM_module() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains("crm"));
        Assert.assertTrue(driver.getCurrentUrl().contains("crm"));
    }

    @When("User clicks on the Customers page")
    public void user_clicks_on_the_Customers_page() {
        BrowserUtils.wait(5);
        crmUserCustP.customersLink.click();
    }

    @Then("User should be able to see Customers page.")
    public void user_should_be_able_to_see_Customers_page() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.titleContains("Customers"));
      Assert.assertTrue(crmUserCustP.getCustomersTitle().contains("Customers"));

    }
    @Given("User on the Customers page")
    public void user_on_the_Customers_page() {
        crmUserCustP.customersLink.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.titleContains("Customers"));
        System.out.println(crmUserCustP.getCustomersTitle());
    }

    @When("User clicks on create button")
    public void user_clicks_on_create_button() {
        crmUserCustP.newCustomerProfile.click();
        BrowserUtils.wait(5);
    }

    @Then("User should be able to enter a {string}")
    public void user_should_be_able_to_enter_a(String name) {
        BrowserUtils.wait(5);
     crmUserCustP.nameField.sendKeys(name);
    }

    @Then("User should be able to click on save to create new customer profile.")
    public void user_should_be_able_to_click_on_save_to_create_new_customer_profile() {
       BrowserUtils.wait(5);
        crmUserCustP.saveButton.click();
    }

    @Then("User should select Company option")
    public void user_should_select_Company_option() {
       crmUserCustP.radioButtonCompany.click();
    }

    @Then("User should be able to enter company name.")
    public void user_should_be_able_to_enter_company_name() {
        crmUserCustP.nameField.sendKeys("Everland Company");
    }

    @Then("User should be able to select Internal Notes option")
    public void user_should_be_able_to_select_Internal_Notes_option() {
       crmUserCustP.internalNotes.click();
    }

    @Then("User should be able to enter notes in the textbox")
    public void user_should_be_able_to_enter_notes_in_the_textbox() {
        crmUserCustP.internalNotesEntered.sendKeys("Growing company");
    }

    @Then("User should be able to select Sales\\/Purchases option")
    public void user_should_be_able_to_select_Sales_Purchases_option() {
        crmUserCustP.salesPurchasesbutton.click();
    }

    @Then("User should be able to select option Vendor or Customer.")
    public void user_should_be_able_to_select_option_Vendor_or_Customer() {
       crmUserCustP.customerButton.click();
        BrowserUtils.wait(5);
    }

    @When("user selects a profile from the list")
    public void user_selects_a_profile_from_the_list() {
        crmUserCustP.selectProfile.click();
        BrowserUtils.wait(5);
    }

    @Then("User should be able to click on edit")
    public void user_should_be_able_to_click_on_edit() {
       crmUserCustP.editProfile.click();
    }

    @Then("User should be able to make changes")
    public void user_should_be_able_to_make_changes() {
        crmUserCustP.nameField.clear();
        crmUserCustP.nameField.sendKeys("Mrs. Jason");
    }

    @Then("User should be able to click on save to save changes.")
    public void user_should_be_able_to_click_on_save_to_save_changes() {
        crmUserCustP.saveButton.click();
    }

    @Then("User should be able to click on discard")
    public void user_should_be_able_to_click_on_discard() {
        crmUserCustP.discard.click();
    }

    @Then("User should receive a message {string}")
    public void user_should_receive_a_message(String string) {
       Assert.assertTrue(crmUserCustP.warningMessage.getText().contains("The record has been modified, your changes will be discarded. Do you want to proceed?"));
    }

    @Then("User should be able to click on OK button to discard changes.")
    public void user_should_be_able_to_click_on_OK_button_to_discard_changes() {
        crmUserCustP.confirmChanges.click();

    }

    @When("User clicks on the searchbox")
    public void user_clicks_on_the_searchbox() {
        crmUserCustP.searchbox.click();
    }

    @Then("User should be able to enter a customer name {string} in the search box")
    public void user_should_be_able_to_enter_a_customer_name_in_the_search_box(String string) {
        crmUserCustP.searchbox.sendKeys("Mr. Jones");
    }

    @Then("User should be able to click enter to filter")
    public void user_should_be_able_to_click_enter_to_filter() {
        crmUserCustP.searchbox.sendKeys(Keys.ENTER);
        BrowserUtils.wait(5);
    }

    @Then("User should be able to view the profiles searched for")
    public void user_should_be_able_to_view_the_profiles_searched_for() {
        Assert.assertTrue(crmUserCustP.customerSearched.getText().contains("Mr. Jones"));
        System.out.println(crmUserCustP.customerSearched.getText());
    }

    @When("User clicks on the x button on the searchbox")
    public void user_clicks_on_the_x_button_on_the_searchbox() {
        crmUserCustP.searchbox.sendKeys("Mr. Jones"+ Keys.ENTER);
        crmUserCustP.xbuttononsearchbox.click();

    }

    @Then("User should be able to clear the searchbox")
    public void user_should_be_able_to_clear_the_searchbox() {
        Assert.assertTrue(crmUserCustP.searchbox.getText().contains(""));
    }

    @When("User clicks on the listview option")
    public void user_clicks_on_the_listview_option() {
        crmUserCustP.listView.click();
    }

    @Then("User should be able to view the list of customers in a list format")
    public void user_should_be_able_to_view_the_list_of_customers_in_a_list_format() {
        Assert.assertTrue(crmUserCustP.list.getText().contains("Name"));
    }


}
