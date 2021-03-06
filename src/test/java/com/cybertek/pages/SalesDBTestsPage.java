package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import cucumber.api.java.en_lol.WEN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalesDBTestsPage {

    public SalesDBTestsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Sales")
    public WebElement SalesButton;

    @FindAll({@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[2]")})
    public List<WebElement> salesQuotations;

    @FindAll({@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[6]")})
    public List<WebElement> salesTotal;

    @FindBy(xpath = "(//ul[@class='oe_secondary_submenu nav nav-pills nav-stacked'])[4]//li[1]")
    public WebElement productsButton;

    @FindBy(xpath = "//span[.='Apple In-Ear Headphones']")
    public WebElement productName;

    @FindBy(xpath = "(//span[@class='o_field_monetary o_field_number o_field_widget'])[1]")
    public WebElement productPrice;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']")
    public WebElement create;

    @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement enterProductName;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement save;

    public String getProductName(String name) {
        String productname = Driver.getDriver().findElement(By.xpath("//span[.='" + name + "']")).getText();
        return productname;
    }


}
