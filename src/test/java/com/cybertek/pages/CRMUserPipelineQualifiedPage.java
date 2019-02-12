package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMUserPipelineQualifiedPage {

    public CRMUserPipelineQualifiedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='o_kanban_group ui-sortable o_kanban_has_progressbar'][2]//div[@class='oe_kanban_content'])[2]")
    public WebElement opportunityUnderQualified;

    @FindBy(xpath = "(//div[@class='o_kanban_group ui-sortable o_kanban_has_progressbar'][2]//div[@class='oe_kanban_content'])[2]//div//strong//span")
    public WebElement expectedTitleOfOpportunityUnderQualified;

    @FindBy(xpath = "//h1//span[@class='o_field_char o_field_widget o_required_modifier']")
    public WebElement actualTitleOfOpportunityUnderQualified;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default oe_highlight'][2]")
    public WebElement markWon;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default oe_highlight'][2]")
    public WebElement markLost;

    @FindBy(xpath = "//div[@class='label label-success pull-right']")
    public WebElement wonOrLostStatus;

    @FindBy(xpath = "//input[@class='o_input ui-autocomplete-input']")
    public WebElement reasonForLost;

    @FindBy(xpath = "//button[@name='action_lost_reason_apply']")
    public WebElement submitOnReason;

}
