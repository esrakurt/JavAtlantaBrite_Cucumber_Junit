package com.cybertek.pages;



import com.cybertek.utilities.Driver;
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





}
