package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerQuotationsPage {

    public ManagerQuotationsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[5]/ul[1]/li[2]/a/span")
    public WebElement Quotations;

    @FindBy (xpath = "//button[@accesskey='c']")
    public WebElement createButtonInQuotations;

    @FindBy (xpath = "//h1/span")
    public WebElement newQuotationsFunctionHeader;

    @FindBy (xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class='o_notification_manager']/div/div")
    public WebElement errorMessageInQuotation;

    @FindBy (xpath = "(//*[@id=\"ui-id-204\"]/li/a/em")
    public WebElement customerBox;

//    Select s = new Select(customerDrpDown);
//
//    public WebElement firstSelectedOption = s.getFirstSelectedOption();


    @FindBy (xpath = "//*[@id='o_field_input_569']")
    public WebElement invoiceAddressEntryBox;

    @FindBy (xpath = "//*[@id='o_field_input_570']")
    public WebElement deliveryAddressEntryBox;

    @FindBy (xpath = "//*[@id='o_field_input_573']")
    public WebElement priceListEntryBox;




    public String getQuotationsTitle(){
        String title = Driver.getDriver().getTitle();
        return title;
    }

}
