package com.cybertek.step_definitions;

import com.cybertek.pages.SalesDBTestsPage;
import com.cybertek.utilities.DatabaseUtility;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.*;

public class SalesDBTestsSteps {

    SalesDBTestsPage salesDBTestsPage = new SalesDBTestsPage();


//  1) STEPS for Verify the Sales-Quotation Numbers
    @When("user is on Sales page")
    public void user_is_on_Sales_page() {

        salesDBTestsPage.SalesButton.click();
    }

    List<WebElement> quotations;
    List<String> expectedDataList = new ArrayList<>();
    @Then("gets the list of quotation numbers from UI")
    public void gets_the_list_of_quotation_numbers_from_UI() {

        quotations = salesDBTestsPage.salesQuotations;
        for (WebElement w : quotations){
            expectedDataList.add(w.getText());
        }
        System.out.println(expectedDataList);
    }

    List<Object> dataList;
    @Then("gets the list of quotation numbers form DB")
    public void gets_the_list_of_quotation_numbers_form_DB() {

        String sql = "select name\n" +
                     "from sale_order;";
        dataList = DatabaseUtility.getColumnData(sql, "name");
        System.out.println(dataList);
    }

    @Then("verify that the quotation numbers are matching")
    public void verify_that_the_quotation_numbers_are_matching() {
        for(String s : expectedDataList){
            Assert.assertTrue(dataList.contains(s));
        }
    }


    // 2)   STEPS for Verify the amount of total sales

    List<WebElement> totalSales;
    List<String> expectedTotalSales = new ArrayList<>();
    List<String > unexpectedSalesData = new ArrayList<>();
    @Then("gets the list of sales total from UI")
    public void gets_the_list_of_sales_total_from_UI() {
        totalSales = salesDBTestsPage.salesTotal;
        for(WebElement w : totalSales){
            if(!w.getText().contains("€")) {
                expectedTotalSales.add(w.getText().substring(2).replace(",", ""));
            }else{
                unexpectedSalesData.add(w.getText());
            }
        }
        System.out.println("Unexpected Data: " + unexpectedSalesData);
        System.out.println("Expected Data: " +expectedTotalSales);
    }

    List<Object> actualData;
    @Then("gets the list of sales total form DB")
    public void gets_the_list_of_sales_total_form_DB() {
        actualData = DatabaseUtility.getColumnData("select amount_total\n" +
                "from sale_order \n" +
                "order by amount_total asc;", "amount_total");
        System.out.println("Actual Data: " + actualData);
    }

    @Then("verify that the total numbers are matching")
    public void verify_that_the_total_numbers_are_matching() {
        for(String s: expectedTotalSales){
            Assert.assertTrue(actualData.toString().contains(s));
        }

    }


//  3) STEPS for Verify the name and price of Apple In-Ear Headphones
    @Then("user navigate to products page")
    public void user_navigate_to_products_page() {
        salesDBTestsPage.productsButton.click();
    }
    String productName;
    String productPrice;
    @Then("gets the product name and price from website")
    public void gets_the_product_name_and_price_from_website() {
          productName = salesDBTestsPage.productName.getText();
          productPrice = salesDBTestsPage.productPrice.getText();

        System.out.println("Product name: " + productName  + " Product price: " + productPrice);
    }
    List<List<Object>> DBData;
    @Then("verify the data")
    public void verify_the_data() {
        DBData = DatabaseUtility.getQueryResultList("select name, list_price\n" +
                "from product_template\n" +
                "where name = 'Apple In-Ear Headphones';");

        System.out.println(DBData.toString());

        Assert.assertTrue(DBData.toString().contains(productName));
        Assert.assertTrue(DBData.toString().contains(productPrice.substring(2)));

    }


//   4) STEPS for Verify whether the name of item created in on DB
    @Then("user clicks on products and then clicks on create")
    public void user_clicks_on_products_and_then_clicks_on_create() {
        salesDBTestsPage.productsButton.click();
        salesDBTestsPage.create.click();
    }

    @Then("creates a new product {string}")
    public void creates_a_new_product(String newItem) {
        salesDBTestsPage.enterProductName.sendKeys(newItem);
        salesDBTestsPage.save.click();
        salesDBTestsPage.productsButton.click();
    }
    String expectedProductName;
    List<Object> productNamesDB;
    @Then("user gets the name of item from UI and DB")
    public void user_gets_the_name_of_item_from_UI_and_DB() {

        // getting name from UI
        expectedProductName = salesDBTestsPage.getProductName("A Test Item");
        System.out.println("Expected Product Name: " + expectedProductName);

        //getting name from DB
        productNamesDB = DatabaseUtility.getColumnData("select name\n" +
                "from product_template;", "name");
        System.out.println(productNamesDB);
    }

    @Then("user verifies the name appears on DB")
    public void user_verifies_the_name_appears_on_DB() {

        Assert.assertTrue(productNamesDB.contains(expectedProductName));
    }




}
