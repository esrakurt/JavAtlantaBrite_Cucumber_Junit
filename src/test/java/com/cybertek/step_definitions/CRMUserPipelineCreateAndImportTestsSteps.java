package com.cybertek.step_definitions;

import com.cybertek.pages.CRMUserPipelineChangeOpportunityInfoPage;
import com.cybertek.pages.CRMUserPipelinePage;
import com.cybertek.pages.CRMUserPipelineQualifiedPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CRMUserPipelineCreateAndImportTestsSteps {

    CRMUserPipelinePage crmUserPipelinePage = new CRMUserPipelinePage();
    CRMUserPipelineChangeOpportunityInfoPage crmUserPipelineChangeOpportunityInfoPage = new CRMUserPipelineChangeOpportunityInfoPage();
    CRMUserPipelineQualifiedPage qualifiedPage = new CRMUserPipelineQualifiedPage();
    LoginPage loginPage = new LoginPage();

    //STEPS FOR Create an Opportunity as User Test

    @Given("user on the pipeline page after login using valid credentials")
    public void user_on_the_pipeline_page_after_login_using_valid_credentials() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        crmUserPipelinePage.BriteErpDemo.click();
        crmUserPipelinePage.signIn.click();
        crmUserPipelinePage.email.sendKeys(ConfigurationReader.getProperty("CRMUserEmail"));
        crmUserPipelinePage.password.sendKeys(ConfigurationReader.getProperty("CRMUserPassword"));
        crmUserPipelinePage.loginButton.click();
        crmUserPipelinePage.CRMButton.click();
//        crmUserPipelinePage.loginAsUser();
    }

    @When("Click on create button")
    public void click_on_create_button() {
        crmUserPipelinePage.createButton.click();
    }

    @Then("Enter name of new opportunity as {string}")
    public void enter_name_of_new_opportunity_as(String string) {
        crmUserPipelinePage.opportunityTitle.sendKeys(string);
    }

    @Then("Enter expected revenue")
    public void enter_expected_revenue() {
        crmUserPipelinePage.expectedRevenue.clear();
        crmUserPipelinePage.expectedRevenue.sendKeys(crmUserPipelinePage.randomQuantity());
    }

    @Then("Click on one of the priority stars")
    public void click_on_one_of_the_priority_stars() {
        crmUserPipelinePage.priority.click();
    }

    @Then("Click on create")
    public void click_on_create() {
        crmUserPipelinePage.create.click();
    }

    @Then("Close driver")
    public void close_driver() {
        Driver.closeDriver();
    }

    //STEPS FOR Change the opportunity information as user Test

    @When("Click on recently created {string}")
    public void click_on_recently_created(String opptName) {
        crmUserPipelineChangeOpportunityInfoPage.getTheNameOfNewCreatedOpportunity(opptName);
    }

    @Then("Click on edit button")
    public void click_on_edit_button() {
        crmUserPipelineChangeOpportunityInfoPage.editButton.click();
    }

    @Then("Clear the information")
    public void clear_the_information() {
        crmUserPipelineChangeOpportunityInfoPage.infoNeededToChange.clear();
    }

    @Then("Enter new information {string}")
    public void enter_new_information(String title) {
        crmUserPipelineChangeOpportunityInfoPage.infoNeededToChange.sendKeys(title);
    }

    @Then("Click on save button")
    public void click_on_save_button() {
        crmUserPipelineChangeOpportunityInfoPage.saveButton.click();
    }

    //STEPS FOR Searching Opportunity Test

    @When("Clear the search box by clicking the x")
    public void clear_the_search_box_by_clicking_the_x() {
        crmUserPipelinePage.xIconOnSearchBox.click();
    }

    @Then("Enter the name of recently created {string}")
    public void enter_the_name_of_recently_created_opportunity(String newOppt) {
        crmUserPipelinePage.searchBox.sendKeys(newOppt);
    }

    @Then("Verify the name of the opportunity is matching with the name of {string}")
    public void verify_the_name_of_the_opportunity_is_matching_with_the_name_of(String string) {
        String actualName = crmUserPipelinePage.searchBoxFirstItem.getText();
        Assert.assertTrue(actualName.contains(string));
    }

    //STEPS FOR Importing a File Test

    @When("Click on import button")
    public void click_on_import_button() {
        crmUserPipelinePage.importButton.click();
    }

    @Then("Verify the the title includes Import a File")
    public void verify_the_the_title_includes_Import_a_File() {
        Assert.assertTrue(crmUserPipelinePage.importAFileTitle.getText().contains("Import a File"));
    }

    @Then("Click on Load File button.")
    public void click_on_Load_File_button() {
        crmUserPipelinePage.loadFile.click();
    }

    //STEPS FOR Importing a File Test

    @When("Verify the create and import buttons are existing.")
    public void verify_the_create_and_import_buttons_are_existing() {
        Assert.assertTrue(crmUserPipelinePage.createButton.getText().contains("Create"));
        Assert.assertTrue(crmUserPipelinePage.importButton.getText().contains("Import"));
    }

    //STEPS FOR Item Under New Category

    @Then("Click on the {string} under New")
    public void click_on_the_under_New(String newOppt) {
        qualifiedPage.clickOpportunity(newOppt);
    }

    @Then("Verify the name of opportunity includes {string}")
    public void verify_the_name_of_opportunity_includes(String expectedName) {
        Assert.assertEquals(expectedName, qualifiedPage.actualNameOfOpportunity.getText());
    }


    //STEPS FOR Changing Status Tests

    @Then("Click on {string} under New")
    public void click_on_under_New(String string) {
        qualifiedPage.clickOpportunity(string);
    }

    @Then("Click on Mark Won")
    public void click_on_Mark_Won() {
        qualifiedPage.markWon.click();
    }

    @Then("Verify that the status has changed to won")
    public void verify_that_the_status_has_changed_to_won() {
        Assert.assertTrue(qualifiedPage.wonStatus.isDisplayed());
    }

    @Then("Click on Mark Lost")
    public void click_on_Mark_Lost() {
        qualifiedPage.markLost.click();
    }

    @Then("Enter {string} to change the status")
    public void enter_to_change_the_status(String string) {
        qualifiedPage.reasonForLost.sendKeys(string);
    }

    @Then("Click on submit")
    public void click_on_submit() {
        qualifiedPage.submitOnReason.click();
    }

    @Then("Verify that the status has changed to lost")
    public void verify_that_the_status_has_changed_to_lost() {
        Assert.assertTrue(qualifiedPage.lostStatus.getText().contains("Lost"));
    }

    //STEPS FOR Module Options Tests

//    @And("Verify the module tabs contains {string} module")
//    public void verify_the_module_tabs_contains_module(String moduleName) {
//        List<WebElement> listOfModules = crmUserPipelinePage.getListOfHeaders();
//        List<String> allModules = new ArrayList<>();
//        for (WebElement module : listOfModules) {
//            allModules.add(module.getText());
//        }
//        System.out.println(allModules);
//
//        Assert.assertTrue(allModules.contains(moduleName));
//    }

    @And("Verify the module tabs contains {string} module")
    public void verify_the_module_tabs_contains_module(String moduleName) {
        ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/testData/CRMUserPipelineData.xlsx", "modules");

        List<Map<String, String>> expectedModules = excelUtil.getDataList();
        for (Map<String, String> expectedModule : expectedModules) {
            moduleName = expectedModule.get("module name");
            System.out.println(moduleName);

        }

        List<WebElement> listOfActualModules = crmUserPipelinePage.getListOfHeaders();
        List<String> allModules = new ArrayList<>();
        for (WebElement module : listOfActualModules) {
            allModules.add(module.getText());
        }
            System.out.println(allModules);

        Assert.assertTrue(allModules.contains(moduleName));
    }


}
