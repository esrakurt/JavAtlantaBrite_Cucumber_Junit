package com.cybertek.step_definitions;

import com.cybertek.pages.InventoryPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.DatabaseUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductSearchDBAndUIVerificationTestSteps {

    private InventoryPage inventoryPage;
    private String expextedProductName;
    private double expectedProductPrice;
    private String actualProductName;
    private double actualProductPrice;

    @Given("I'm on Inventory Products Page")
    public void i_m_on_Inventory_Products_Page() {
        inventoryPage = new InventoryPage();
        inventoryPage.login();
        inventoryPage.inventoryLink.click();

    }

    @When("I search for {string}")
    public void i_search_for(String anyProduct) {
        inventoryPage.productsSubPage.click();
        inventoryPage.XbuttonInSearchBox.click();
        inventoryPage.searchBox.sendKeys(anyProduct+Keys.ENTER);
        BrowserUtils.wait(7);
        inventoryPage.product.click();
//        List<String>productDetails = new ArrayList<>();
//        productDetails.add(inventoryPage.productName.getText());
//        productDetails.add(inventoryPage.productPrice.getText());
//        System.out.println(productDetails);
        expextedProductName = inventoryPage.productName.getText();
        expectedProductPrice = Double.parseDouble((inventoryPage.productPrice.getText()).substring(1).trim() );
        System.out.println(expextedProductName +" ..expexted ones.. "+ expectedProductPrice);
    }

    @When("I query db with {string}")
    public void i_query_db_with(String query) {
        DatabaseUtility.createConnection();
        List<Map<String,Object>> resultMap = DatabaseUtility.getQueryResultMap(query);
        actualProductName = (String) resultMap.get(0).get("name");
        actualProductPrice = Double.parseDouble(resultMap.get(0).get("list_price").toString());
        System.out.println(actualProductName +" ..actual ones.. "+ actualProductPrice);
    }

    @Then("UI data and DB data must match")
    public void ui_data_and_DB_data_must_match() {
        Assert.assertEquals(expextedProductName,actualProductName);
        Assert.assertEquals(expectedProductPrice,actualProductPrice,0);
    }




}
