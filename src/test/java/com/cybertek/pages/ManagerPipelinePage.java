package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManagerPipelinePage {

    public ManagerPipelinePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='o_searchview_facet']//div[2]")
    public WebElement xButtonInSearchBox;

    @FindBy(xpath = "//div[@class='o_cp_right']/div[3]/button[2]")
    public WebElement listView;

    @FindBy(xpath = "//tbody/tr/td/div/input[1]")
    public WebElement firstTableRowInListView;

    @FindBy(xpath = "//div[@class='o_cp_right']/div[3]/button[4]")
    public WebElement pivotView;

    @FindBy(xpath = "//div[@class='o_cp_right']/div[3]/button[5]")
    public WebElement calender;

    @FindBy(xpath = "//div[@class='o_cp_right']/div[3]/button[3]")
    public WebElement graphView;

    @FindBy(xpath = "//button[contains(text(),'Measures')]")
    public WebElement measuresButton;

    @FindBy(xpath = "//a[.='Days to Assign']")
    public WebElement daysToAssign;

    @FindBy(xpath = "(//*[.='Days to Assign'])[6]")
    public WebElement daysToAssignHeader;

    @FindBy(xpath = "//a[.='Days to Close']")
    public WebElement daysToCloseButton;

    @FindBy(xpath = "(//*[.='Days to Close'])[6]")
    public WebElement daysToCloseHeader;





//    Select s = new Select(dropDownMenu);
//
//    public void selectDaysToAssign(){
//        s.selectByVisibleText("Days To Assign");
//    }
//
//    public void selectDaysToClose(){
//        s.selectByVisibleText("Days To Close");
//    }
//
//    public void selectBounce(){
//        s.selectByVisibleText("Bounce");
//    }
//
//    public void selectProbability(){
//        s.selectByVisibleText("Probability");
//    }
//
//    public void selectExpectedRevenue(){
//        s.selectByVisibleText("Expected Revenue");
//    }

    @FindBy(linkText = "Pipeline")
    public WebElement pipelineLink;


    public String getPipelineTitle(){
        String title = Driver.getDriver().getTitle();
        return title;
    }

    public void gotoGraphAndClickMeasures () {
        this.graphView.click();
        this.measuresButton.click();

    }



}
