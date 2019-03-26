package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManagerExcelDataBaseTest {

    private String file = "./src/test/resources/testData/ManagerExcel.xls";
    private String sheet = "productSpecs";
    private ExcelUtil productData = new ExcelUtil(file, sheet);


    @Given("the parameters in xl sheet entered the UI")
    public void the_parameters_in_xl_sheet_entered_the_UI() {

    }

    @When("I query db with results")
    public void i_query_db_with_results() {

    }

    @Then("XL data and DB data must match")
    public void xl_data_and_DB_data_must_match() {

    }



}
