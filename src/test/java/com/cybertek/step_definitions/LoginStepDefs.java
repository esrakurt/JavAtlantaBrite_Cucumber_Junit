package com.cybertek.step_definitions;


import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefs {

    LoginPage login = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.wait(1);


    }

    @When("user logs in using {string}")
    public void user_logs_in_using(String role) {
        if (role.equalsIgnoreCase("manager")) {
            login.login(ConfigurationReader.getProperty("CRMManagerEmail"), ConfigurationReader.getProperty("CRMManagerPassword"));
        } else if ((role.equalsIgnoreCase("user"))) {
            login.login(ConfigurationReader.getProperty("CRMUserEmail"), ConfigurationReader.getProperty("CRMUserPassword"));
        }
    }

    @Then("CRM module should be displayed")
    public void crm_module_should_be_displayed() {
        login.clickCRModule();
    }




}