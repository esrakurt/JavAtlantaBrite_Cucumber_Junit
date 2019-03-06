package com.cybertek.step_definitions;

import com.cybertek.pages.CRMUserPipelineChangeOpportunityInfoPage;
import com.cybertek.pages.CRMUserPipelinePage;
import com.cybertek.pages.CRMUserPipelineQualifiedPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CRMUserPipelineTestsSteps {

    CRMUserPipelinePage crmUserPipelinePage = new CRMUserPipelinePage();
    CRMUserPipelineChangeOpportunityInfoPage crmUserPipelineChangeOpportunityInfoPage = new CRMUserPipelineChangeOpportunityInfoPage();
    CRMUserPipelineQualifiedPage qualifiedPage = new CRMUserPipelineQualifiedPage();
    LoginPage loginPage = new LoginPage();


    //STEPS FOR Create an Opportunity as User Test

    @Given("user on the pipeline page after login using valid credentials")
    public void user_on_the_pipeline_page_after_login_using_valid_credentials() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //crmUserPipelinePage.BriteErpDemo.click();
        crmUserPipelinePage.signIn.click();
        crmUserPipelinePage.email.sendKeys(ConfigurationReader.getProperty("CRMUserEmail"));
        crmUserPipelinePage.password.sendKeys(ConfigurationReader.getProperty("CRMUserPassword"));
        crmUserPipelinePage.loginButton.click();
        crmUserPipelinePage.CRMButton.click();
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

    @And("Verify the module tabs contains {string} module")
    public void verify_the_module_tabs_contains_module(String moduleName) {
        ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/testData/CRMUserPipelineData.xlsx", "modules");

        List<Map<String, String>> expectedModules = excelUtil.getDataList();
        for (Map<String, String> expectedModule : expectedModules) {
            moduleName = expectedModule.get("module name");
            System.out.println(moduleName);

            List<WebElement> listOfActualModules = crmUserPipelinePage.getListOfHeaders();
            List<String> allModules = new ArrayList<>();
            for (WebElement module : listOfActualModules) {
                allModules.add(module.getText());
            }
            System.out.println(allModules);

            Assert.assertTrue(allModules.contains(moduleName));
        }
    }

    // STEPS FOR Create new opportunity with detail information as user Test

    @Then("Enter name of new opportunity {int}")
    public void enter_name_of_new_opportunity(Integer int1) {
        ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/testData/CRMUserPipelineData.xlsx", "data");

        switch (int1) {
            case 1:
                crmUserPipelinePage.opportunityTitle.sendKeys(excelUtil.getCellData(1, 0));
                break;
            case 2:
                crmUserPipelinePage.opportunityTitle.sendKeys(excelUtil.getCellData(2, 0));
                break;
        }
    }

    @Then("Click on create and edit button")
    public void click_on_create_and_edit_button() {
        crmUserPipelinePage.createAndEdit.click();
    }


    @Then("Enter data of {string} for all areas")
    public void enter_data_of_for_all_areas(Integer int1) {
        ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/testData/CRMUserPipelineData.xlsx", "data");

        List<Map<String, String>> excelData = excelUtil.getDataList();

        for (int i = 0; i < excelData.size(); i++) {
            crmUserPipelinePage.opportunityTitle.sendKeys(excelData.get(i).get("opportunity name"));
            crmUserPipelinePage.createAndEdit.click();
            crmUserPipelinePage.expectedRevenue1.clear();
            crmUserPipelinePage.expectedRevenue1.sendKeys(excelData.get(i).get("expected revenue"));
            crmUserPipelinePage.probability.clear();
            crmUserPipelinePage.probability.sendKeys(excelData.get(i).get("probability"));
            crmUserPipelinePage.email1.sendKeys(excelData.get(i).get("email1"));
            crmUserPipelinePage.phone.sendKeys(excelData.get(i).get("phone"));
            crmUserPipelineChangeOpportunityInfoPage.saveButton.click();
            if (i == excelData.size()-1) {
                break;
            }
            crmUserPipelinePage.CRMButton.click();
            BrowserUtils.wait(3);
            Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary btn-sm o-kanban-button-new']")).click();
        }
    }


// STEPS FOR Creating an event using calender icon

    @When("Click on calender icon on top right")
    public void click_on_calender_icon_on_top_right() {

        crmUserPipelinePage.calendar.click();
    }

    @Then("Select a date")
    public void select_a_date() {

        crmUserPipelinePage.pickDate(18);
        crmUserPipelinePage.day.click();
        BrowserUtils.wait(3);
        crmUserPipelinePage.pickTime("09:00:00");
    }

    @Then("Create an event using event {int}")
    public void create_an_event_using_event(Integer int1) {
        ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/testData/CRMUserPipelineData.xlsx", "event");

        switch (int1) {
            case 1:
                crmUserPipelinePage.summary.sendKeys(excelUtil.getCellData(1, 0));
                crmUserPipelinePage.create1.click();
                break;
            case 2:
                crmUserPipelinePage.summary.sendKeys(excelUtil.getCellData(2, 0));
                crmUserPipelinePage.create1.click();
        }
    }

    // STEPS FOR Verifying pivot table measures

    @When("Click on pivot icon on top right")
    public void click_on_pivot_icon_on_top_right() {
        crmUserPipelinePage.pivot.click();
    }

    @Then("Click on measures button")
    public void click_on_measures_button() {
        crmUserPipelinePage.measures.click();
    }

    @Then("Verify the measure subtitles are matching with the {string}")
    public void verify_the_measure_subtitles_are_matching_with_the(String string) {

        ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/testData/CRMUserPipelineData.xlsx", "pivot measures");

        List<WebElement> allSubtitles = crmUserPipelinePage.getListOfSubtitles();
        List<String> actualSubtitles = new ArrayList<>();
        for (WebElement subtitle : allSubtitles) {
            actualSubtitles.add(subtitle.getText());
        }
        System.out.println("Actual Subtitles: " + actualSubtitles);

        List<Map<String, String>> measureSubtitles = excelUtil.getDataList();
        for (int i = 0; i < measureSubtitles.size(); i++) {
            System.out.println("Subtitle " + i + ": " + measureSubtitles.get(i).get("measure"));
            Assert.assertTrue(actualSubtitles.contains(measureSubtitles.get(i).get("measure")));
            System.out.println("Subtitle matched with the actual");
        }
    }



}



//    @Then("Enter data of {int} for all areas")
//    public void enter_data_of_for_all_areas(Integer int1) {
//        ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/testData/CRMUserPipelineData.xlsx", "data");
//
//        switch (int1) {
//            case 1:
//                crmUserPipelinePage.expectedRevenue1.clear();
//                crmUserPipelinePage.expectedRevenue1.sendKeys(excelUtil.getCellData(1, 1));
//                crmUserPipelinePage.probability.clear();
//                crmUserPipelinePage.probability.sendKeys(excelUtil.getCellData(1, 2));
//                crmUserPipelinePage.email1.sendKeys(excelUtil.getCellData(1, 3));
//                crmUserPipelinePage.phone.clear();
//                crmUserPipelinePage.phone.sendKeys(excelUtil.getCellData(1, 4));
//                break;
//
//            case 2:
//                crmUserPipelinePage.expectedRevenue1.clear();
//                crmUserPipelinePage.expectedRevenue1.sendKeys(excelUtil.getCellData(2, 1));
//                crmUserPipelinePage.probability.clear();
//                crmUserPipelinePage.probability.sendKeys(excelUtil.getCellData(2, 2));
//                crmUserPipelinePage.email1.sendKeys(excelUtil.getCellData(2, 3));
//                crmUserPipelinePage.phone.clear();
//                crmUserPipelinePage.phone.sendKeys(excelUtil.getCellData(2, 4));
//                break;
//        }
//
//    }

