package com.cybertek.pages;



import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EventPage {

    public EventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(linkText = "Events")
    public WebElement EventButton;

    @FindBy(linkText = "Event Categories")
    public WebElement EventCategories;

    @FindBy(css = ".table-responsive tbody tr")
    public List<WebElement> EventList;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']")
    public WebElement Create;

    @FindBy(xpath ="//input[@placeholder='Event Name']")
    public WebElement EventName;

    @FindBy(xpath = "(//div[@class=\"o_input_dropdown\"])[1]/input")
    public WebElement Organizer;




    @FindBy(xpath = "(//div[@class=\"o_input_dropdown\"])[2]/input")
    public WebElement Location ;

    @FindBy(xpath = "(//button/span)[14]")
    public WebElement PopUpCreateButton;




    @FindBy(xpath = "//div[@name=\"date_begin\"]/input")
    public WebElement StartDate ;


    @FindBy(xpath = "//div[@name=\"date_end\"]/input")
    public WebElement EndDate ;

    @FindBy(xpath = "(//div[@class=\"o_input_dropdown\"])[5]/input")
    public WebElement Category ;


    @FindBy(xpath = "(//button)[8]")
    public WebElement Save ;

     @FindBy(xpath = "(//button)[47]")
    public WebElement PopUpOk ;


    @FindBy(xpath = "(//button)[7]")
    public WebElement SecondCreate ;



}
