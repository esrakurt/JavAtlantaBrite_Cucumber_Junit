package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPipelinePage {

    public ManagerPipelinePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/ol/li")
    public WebElement pipelineXXXXX;

    @FindBy(linkText = "Pipeline")
    public WebElement pipelineLink;

    @FindBy(xpath = "//div[@class='o_cp_buttons']//div//button[1]")
    public WebElement createButtonOnPipelinePage;

    @FindBy(xpath = "//span[@class='o_kanban_title']")
    public WebElement addNewColumn;

    @FindBy(xpath = "//input[@class='form-control o_input']")
    public WebElement columnTitleEntryBox;

    @FindBy(xpath = "//div[@data-id='7']/div/div/span")
    public WebElement newColumnTitle;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public WebElement importButton;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_import_cancel']")
    public WebElement importCancelButton;








    public String getPipelineTitle(){
        String title = Driver.getDriver().getTitle();
        return title;
    }



}
