package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMUserPipelineQualifiedPage {

    CRMUserPipelinePage crmUserPipelinePage = new CRMUserPipelinePage();

    public CRMUserPipelineQualifiedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1//span[@class='o_field_char o_field_widget o_required_modifier']")
    public WebElement actualNameOfOpportunity;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default oe_highlight'][2]")
    public WebElement markWon;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default oe_highlight'][2]")
    public WebElement markLost;

    @FindBy(xpath = "//div[@class='label label-success pull-right']")
    public WebElement wonStatus;

    @FindBy(xpath = "//div[@class='label label-danger pull-right']")
    public WebElement lostStatus;

    @FindBy(xpath = "//input[@class='o_input ui-autocomplete-input']")
    public WebElement reasonForLost;

    @FindBy(xpath = "//button[@name='action_lost_reason_apply']")
    public WebElement submitOnReason;


    public void clickOpportunity (String nameOfOpportunity){
        WebElement opptUnderQualified = Driver.getDriver().findElement(
                By.xpath("//div[@data-id='1']//div[@class='oe_kanban_content']//span[.='"+nameOfOpportunity+"']"));
        if (opptUnderQualified == null){
            Assert.fail("There is no such element found.");
        }else{
            opptUnderQualified.click();
        }
    }

    public String getNameOfOpportunity(String nameOfOpportunity){
        String actualNameOfOpportunity = Driver.getDriver().findElement(
                By.xpath("//div[@data-id='1']//div[@class='oe_kanban_content']//span[.='"+nameOfOpportunity+"']")).getText();
        return actualNameOfOpportunity;
    }

}
