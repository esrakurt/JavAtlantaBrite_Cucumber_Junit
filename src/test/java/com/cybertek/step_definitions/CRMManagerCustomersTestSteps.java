package com.cybertek.step_definitions;

import com.cybertek.pages.CustomersPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CRMManagerCustomersTestSteps {

    CustomersPage cp = new CustomersPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);


    @Given("navigate to URL and select BriteErpDemo database")
    public void navigate_to_URL_and_select_BriteErpDemo_database() {
        Driver.getDriver().get("http://54.148.96.210/web/login");  //This is new url provided later on
        //cp.BriteErpDemo.click();   We don't need this action anymore
    }


    @Given("login with valid credentials")
    public void login_with_valid_credentials() {
        cp.email.sendKeys(ConfigurationReader.getProperty("CRMManagerEmail"));
        cp.password.sendKeys(ConfigurationReader.getProperty("CRMManagerPassword") + Keys.ENTER);
    }

    @When("navigate CRM module")
    public void navigate_CRM_module() {
        cp.CRMButton.click();
    }

    @Then("go to Customers page")
    public void go_to_Customers_page() {
        cp.Customers.click();
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
    }

    @When("Customers header is displayed")
    public void header_is_displayed() {
        Assert.assertEquals(cp.CustomersHeader.getText(), "Customers");
    }

    @Then("customer cards exist on the page")
    public void customer_cards_exist_on_the_page() {
        Assert.assertTrue(cp.CustomerCardImages.isDisplayed());
    }

    @When("go to Create screen")
    public void go_to_Create_screen() {
        cp.CreateButton.click();
    }

    @Then("leave the name field empty")
    public void leave_the_name_field_empty() {
        cp.nameField.clear();
    }

    @Then("click on save button")
    public void click_on_save_button() {
        cp.saveButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "New - Odoo");
    }

    @When("fill the required fields")
    public void fill_the_required_fields() {
        cp.nameField.clear();
        cp.nameField.sendKeys("SampleName123");
    }

    @Then("it should navigate to the new customers account page")
    public void it_should_navigate_to_the_new_customers_account_page() {
        wait.until(ExpectedConditions.titleIs("SampleName123 - Odoo"));
        Assert.assertEquals(Driver.getDriver().getTitle(), "SampleName123 - Odoo");
    }

    @Then("click on Discard button")
    public void click_on_Discard_button() {
        cp.discardButton.click();
    }

    @Then("warning message should exist")
    public void warning_message_should_exist() {
        Assert.assertTrue(cp.warningPopUp.isDisplayed());
    }

    @Then("click on Ok button")
    public void click_on_Ok_button() {
        cp.warningOkButton.click();
    }

    @Then("it should navigate back to the Customers page")
    public void it_should_navigate_back_to_the_Customers_page() {
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        Assert.assertEquals(cp.CustomersHeader.getText(), "Customers");
    }

    @Given("Kanban view is selected as default")
    public void kanban_view_is_selected_as_default() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("view_type=kanban&model"));
    }

    @When("click on List button")
    public void click_on_List_button() {
        cp.listViewButton.click();
    }

    @Then("the page switches to list view")
    public void the_page_switches_to_list_view() {
        wait.until(ExpectedConditions.urlContains("view_type=list&model"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("view_type=list&model"));
    }

    @Given("Individual radio button is selected as default")
    public void individual_radio_button_is_selected_as_default() {
        Assert.assertTrue(cp.radioButtonIndividual.isSelected());
    }

    @Given("Company radio button is not selected")
    public void company_radio_button_is_not_selected() {
        Assert.assertTrue(!cp.radioButtonCompany.isSelected());
    }

    @When("click on Company button")
    public void click_on_Company_button() throws InterruptedException {
        cp.radioButtonCompany.click();
        Thread.sleep(2000);
    }

    @Then("Individual button will be un-selected")
    public void individual_button_will_be_un_selected() {
        Assert.assertTrue(!cp.radioButtonIndividual.isSelected());
    }

    @Then("Company button will be selected")
    public void company_button_will_be_selected() {
        Assert.assertTrue(cp.radioButtonCompany.isSelected());
    }


    @When("total number of customer cards should be {int}")
    public void total_number_of_customer_cards_should_be(Integer int1) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(cp.nameListMakerKanbanView().size() == 80);
    }

    @When("click on right arrow button")
    public void click_on_right_arrow_button() throws InterruptedException {
    cp.rightArrowButton.click();
    Thread.sleep(3000);
    }

    @Then("verify that number interval {string} displayed")
    public void verify_that_number_interval_displayed(String string) {
        Assert.assertEquals(cp.numberInterval2.getText(), "81-160");
    }

    List<String> namesList80First;
    @Then("save all customer names on existing cards")
    public void save_all_customer_names_on_existing_cards() {
    namesList80First= cp.nameListMakerKanbanView();
    }

    @When("click on left arrow button")
    public void click_on_left_arrow_button() {
    cp.leftArrowButton.click();
    }

    List<String> namesList80Second;
    @Then("save all customer names on existing cards again")
    public void save_all_customer_names_on_existing_cards_again() throws InterruptedException {
    Thread.sleep(3000);
    namesList80Second=cp.nameListMakerKanbanView();
    }

    List<String> namesList80inListView;
    @Then("save all customer names on existing cards in List view")
    public void save_all_customer_names_on_existing_cards_in_List_view() {
    namesList80inListView = cp.nameListMakerListView();
    }

    @Then("verify that two name lists match")
    public void verify_that_two_name_lists_match() {
    Assert.assertEquals(namesList80First, namesList80Second);
    }

    @Then("verify that two name lists are matching")
    public void verify_that_two_name_lists_are_matching() {
    Assert.assertEquals(namesList80First, namesList80inListView);
    }

}
