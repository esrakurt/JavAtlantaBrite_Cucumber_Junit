package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMUserCustomersPage {

    public CRMUserCustomersPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Customers")
    public WebElement customersLink;


    public String getCustomersTitle(){
        String title = Driver.getDriver().findElement(By.xpath("//div[@class='o_control_panel']//ol//li")).getText();

        return title;
    }
    @FindBy (xpath = "//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public  WebElement xbuttononsearchbox;


    @FindBy (xpath = "//div[@class='o_cp_buttons']//div//button[1]")
    public WebElement newCustomerProfile;

    @FindBy (xpath = "//input[@class='o_field_char o_field_widget o_input']")
    public WebElement currentNameField;

    @FindBy (xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement nameField;

    @FindBy (xpath = "//div[@class='o_form_buttons_edit']//button[1]")
    public WebElement saveButton;

    @FindBy (xpath = "//ol[@class='breadcrumb']//li[2]")
    public WebElement NameDisplay;

    @FindBy (xpath = "(//label[@class='o_form_label'])[2]")
    public WebElement radioButtonCompany;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div[5]/ul/li[2]/a")
    public WebElement internalNotes;

    @FindBy(xpath = "//*[@class=\"o_field_text o_field_widget o_input\"]")
    public WebElement internalNotesEntered;

    @FindBy(xpath = "//*[@class=\"o_field_text o_field_widget\"]")
    public WebElement noteDisplayed;

    @FindBy (xpath = "//ul[@class='nav nav-tabs']//li[3]")
    public WebElement salesPurchasesbutton;

    @FindBy (xpath = "(//input[@type=\"checkbox\"])[4]")
    public WebElement customerButton;

    @FindBy (xpath = "(//input[@type=\"checkbox\"])[6]")
    public WebElement vendorButton;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]")
    public WebElement selectProfile;

    @FindBy (xpath = "//div[@class='o_form_buttons_view']//button[1]")
    public WebElement editProfile;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[2]")
    public WebElement discard;

    @FindBy (xpath = "//div[@class='modal-body']")
    public WebElement warningMessage;

    @FindBy (xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement confirmChanges;

    @FindBy (xpath = "//input[@class='o_searchview_input']")
    public WebElement searchbox;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/strong/span")
    public WebElement customerSearched;

    @FindBy (xpath = "//div[@class='btn-group btn-group-sm o_cp_switch_buttons']//button[2]")
    public WebElement listView;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[2]")
    public WebElement list;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[3]")
    public WebElement phone;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[4]")
    public WebElement email;

    public String getCrmUrl(){
        String CrmUrl = Driver.getDriver().getCurrentUrl();
        return CrmUrl;
    }

}



