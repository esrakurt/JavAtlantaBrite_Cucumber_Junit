package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CRMUserPipelinePage {

    public CRMUserPipelinePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;

    //Sign in
    @FindBy(linkText="Sign in")
    public WebElement signIn;

    //Sign in
    @FindBy(linkText="BriteErpDemo")
    public WebElement BriteErpDemo;

    @FindBy(linkText = "CRM")
    public WebElement CRMButton;

    @FindBy(xpath = "//a[@data-menu-xmlid='crm.menu_crm_opportunities']")
    public WebElement pipelineLink;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new']")
    public WebElement createButton;

    @FindBy(xpath = "//footer//button[1]")
    public WebElement create;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public WebElement importButton;

    @FindBy(xpath = "//ol[@class='breadcrumb']//li[2]")
    public WebElement importAFileTitle;

    @FindBy(xpath = "//span[@class='input-group-btn'][1]")
    public WebElement loadFile;

    @FindBy(xpath = "//td//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement opportunityTitle;

    @FindBy(xpath = "(//div[@class='o_input_dropdown']//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement customer;

    @FindBy(xpath = "//div[@class='o_row']//input[@class='o_field_float o_field_number o_field_widget o_input']")
    public WebElement expectedRevenue;

    @FindBy(xpath = "//tbody//tr[4]//td[2]//div//a[2]")
    public WebElement priority;

    @FindBy(xpath = "//div[@class='o_searchview_facet']//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement xIconOnSearchBox;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "(//div//ul[@class='dropdown-menu o_searchview_autocomplete']//li[1])")
    public WebElement searchBoxFirstItem;

    @FindBy(xpath = "//span[.='Create & Edit']")
    public WebElement createAndEdit;


    @FindBy(xpath = "//input[@class='o_input']")
    public WebElement expectedRevenue1;

    @FindBy(xpath = "//input[@class='o_field_integer o_field_number o_field_widget o_input']")
    public WebElement probability;

    @FindBy(xpath = "//input[@class='o_field_email o_field_widget o_input']")
    public WebElement email1;

    @FindBy(xpath = "//input[@class='o_field_phone o_field_widget o_input']")
    public WebElement phone;

    @FindBy(xpath = "//div[@class='o_priority o_field_widget']//a[1]")
    public WebElement priority1;

    @FindBy(xpath = "//button[@aria-label='calendar']")
    public WebElement calendar;

    @FindBy(xpath = "//button[@class='o_calendar_button_day btn btn-sm btn-default']")
    public WebElement day;

    public void pickDate(int day){
        Driver.getDriver().findElement(By.xpath("//a[.='"+day+"']")).click();
    }

    public void pickTime(String time){
        Driver.getDriver().findElement(By.xpath("//tr[@data-time='" +time +"']")).click();
    }

    @FindBy(xpath = "//input[@class='o_input']")
    public WebElement summary;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement create1;

    @FindBy(xpath = "//button[@aria-label='pivot']")
    public WebElement pivot;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm dropdown-toggle']")
    public WebElement measures;


    public List<WebElement> getListOfSubtitles(){
        List<WebElement> subtitles = Driver.getDriver().findElements(
                By.xpath("//ul[@class='dropdown-menu o_pivot_measures_list']//li"));
        return subtitles;
    }


    public List<WebElement> getListOfHeaders(){
        List<WebElement> headers = Driver.getDriver().findElements(
                By.xpath("//ul[@class='nav navbar-nav navbar-left oe_application_menu_placeholder']//li//a//span"));
        for (WebElement header:headers) {
        }
        return headers;
    }

    // Method for login to CRM module as user
    public void loginAsUser() {

        BriteErpDemo.click();
        signIn.click();
        email.sendKeys(ConfigurationReader.getProperty("CRMUserEmail"));
        password.sendKeys(ConfigurationReader.getProperty("CRMUserPassword"));
        loginButton.click();
        CRMButton.click();
    }

    public String randomQuantity() {
        Random r = new Random();
        int qtty = r.nextInt(999) + 1;
        String rndmQuantity = (" " + qtty + " ").trim();

        return rndmQuantity;
    }

}
