package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomersPage {

    public CustomersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@data-action-id='365'][1]")
    public WebElement CRM1;

    @FindBy(xpath = "(//strong[@class='o_kanban_record_title oe_partner_heading']/span)[1]")
    public WebElement customerNameOnCart;

    @FindBy(xpath = "//span[@class='o_field_char o_field_widget o_required_modifier']")
    public WebElement customerNameOnAccount;

    @FindBy(xpath = "//button[@aria-label='kanban']")
    public WebElement kanbanViewButton;

    @FindBy(xpath = "//span[@class='btn-group btn-group-sm']/button[2]")
    public WebElement rightArrowButton;

    @FindBy(xpath = "//span[@class='btn-group btn-group-sm']/button")
    public WebElement leftArrowButton;

    @FindBy(xpath = "//span[@class='o_pager_value']")
    public WebElement numberInterval2;


    public List<String> nameListMakerKanbanView(){
        List<WebElement> customerCards = Driver.getDriver().findElements(By.xpath("//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']/div[2]/strong/span"));
        List<String> namesList80= new ArrayList<>();
        for(WebElement a : customerCards){
            namesList80.add(a.getText());
        }
        return namesList80;
    }

    public List<String> nameListMakerListView(){
        List<WebElement> customerCards = Driver.getDriver().findElements(By.xpath("//td[@class='o_data_cell o_readonly_modifier']"));
        List<String> namesList80= new ArrayList<>();
        for(WebElement a : customerCards){
            namesList80.add(a.getText());
        }
        return namesList80;
    }


    // ---------------NEW ONES-------------------

    @FindBy(xpath = "//a[@class='list-group-item'][2]")
    public WebElement BriteErpDemo ;

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(linkText = "CRM")
    public WebElement CRMButton;

    @FindBy(xpath = "(//a[@data-action-id='48'])[1]")
    public WebElement Customers;

    @FindBy(xpath = "//div[@class='o_kanban_image']")
    public WebElement CustomerCardImages;

    @FindBy(xpath = "//ol[@class='breadcrumb']/li")
    public WebElement CustomersHeader;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement CreateButton;

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement nameField;

    @FindBy(xpath = "//div[@class='o_form_buttons_edit']/button")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='o_form_buttons_edit']/button[2]")
    public WebElement discardButton;

    @FindBy(xpath = "//button[@aria-label='list']")
    public WebElement listViewButton;

    @FindBy(xpath = "(//div[@class='o_radio_item']/input)[1]")
    public WebElement radioButtonIndividual;

    @FindBy(xpath = "(//div[@class='o_radio_item']/input)[2]")
    public WebElement radioButtonCompany;

    @FindBy(className = "modal-body")
    public WebElement warningPopUp;

    @FindBy(xpath = "//div[@class='modal-footer']/button[1]")
    public WebElement warningOkButton;

    @FindBy(xpath = "//input[@placeholder='Company']")
    public WebElement companyDropdown;


}
