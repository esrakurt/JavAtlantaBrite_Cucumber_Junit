package com.cybertek.step_definitions;

import com.cybertek.utilities.ExcelUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ManagerExcelTestSteps {

    @Given("a list of quotations specifications")
    public void a_list_of_quotations_specifications() {
        String file = "./src/test/resources/testData/ManagerExcel.xls";
        String sheet = "quotSpecs";
        ExcelUtil quotationData = new ExcelUtil(file, sheet);
        System.out.println(quotationData.getColumnsNames());

    }

    @Given("return all specification on xls sheet")
    public void return_all_specification_on_xls_sheet() {
        String file = "./src/test/resources/testData/ManagerExcel.xls";
        String sheet = "quotSpecs";
        ExcelUtil quotationData = new ExcelUtil(file, sheet);
        System.out.println(quotationData.getColumnData(0));

    }

    @Then("verify that spreadsheet contains {string}")
    public void verify_that_spreadsheet_contains(String string) {


    }



}
