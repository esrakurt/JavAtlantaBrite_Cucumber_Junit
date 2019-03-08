package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    private WebDriver driver = Driver.getDriver();
    private LoginPage loginPage = new LoginPage();

    public InventoryPage(){

        PageFactory.initElements(driver,this);
    }

    public void login (){

        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

    }

    @FindBy(xpath = "//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[8]/a")
    public WebElement inventoryLink;

    @FindBy(className = "o_searchview_input")
    public WebElement searchBox;

    @FindBy (linkText = "Products")
    public WebElement productsSubPage;

    @FindBy(xpath = "//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement XbuttonInSearchBox;

    @FindBy(xpath = "//div[@class='oe_kanban_global_click o_kanban_record']")
    public WebElement product;

    @FindBy(xpath = "//h1/span")
    public WebElement productName;

    @FindBy(xpath = "//div[@class='o_content']//tbody/tr/td[2]/span[@name='list_price']")
    public WebElement productPrice;

    @FindBy(xpath = "(//div[@class='o_cp_buttons']/div/button)[1]")
    public WebElement createButton;

    @FindBy(xpath = "//h1/input")
    public WebElement productNameEntryBox;

    @FindBy(xpath = "(//tbody)[2]/tr/td[2]/div/input")
    public WebElement priceEntryBox;

    @FindBy(xpath = "(//div[@class='o_cp_buttons']/div/div[2]/button)[1]")
    public WebElement saveButton;





}
